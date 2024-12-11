package jauntlet.map;

import jauntlet.Direction;
import static jauntlet.Direction.DOWN;
import static jauntlet.Direction.LEFT;
import static jauntlet.Direction.RIGHT;
import jauntlet.characters.BasicEnemy;
import jauntlet.characters.PlayerCharacter;
import jauntlet.characters.weapons.ProjectileWeapon;
import jauntlet.graphics.AutonomousSprite;
import jauntlet.graphics.InteractableSprite;
import jauntlet.graphics.MovingSprite;
import jauntlet.graphics.Sprite;
import jauntlet.graphics.WalkableSprite;
import jauntlet.items.Item;
import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tony
 */
public class PlayableMap extends Map
{
    private boolean currentlyUpdating = false;
    private PlayerCharacter character;
    private List<AutonomousSprite> autos;
    private List<AutonomousSprite> addToAutos;

    public PlayableMap(int width, int height, Sprite defaultFloor)
    {
        super(width, height, defaultFloor, new Location(0, 0), new Location(width-1, height-1));
        autos = new ArrayList<>();
        addToAutos = new ArrayList<>();
    }

    public void attack()
    {
        ProjectileWeapon bolt = character.attack();
        if (bolt == null) {return;}
        autos.add(bolt);
    }
    
    public void setSprite(Sprite s, Location l)
    {
        super.setSprite(s, l);
        if (s instanceof AutonomousSprite)
        {
            if (currentlyUpdating)
            {
                addToAutos.add((AutonomousSprite) s);
            } else
            {
                autos.add((AutonomousSprite) s);
            }
        }
    }

    public Location getNearestCharacter(Location myLocation) 
    {
        return character.getLocation();
    }

    public boolean isLegalMove(MovingSprite mover, Location location, Direction direction)
    {
        // See if the destination is free
        Location working = location.clone().bump(direction);
        Sprite destination = get(working);

        switch(direction)
        {
            case UP, DOWN, LEFT, RIGHT -> {
                // only up to the destination
                break;
            }
            default -> {
                // Check diagonal moves to stop inappropriate 'between' moves
                working = location.clone().bump(direction.next());
                Sprite adjacent = get(working);
                if (adjacent != null && !(adjacent instanceof WalkableSprite))
                {
                    // if it is, check the counterclockwise direction
                    working = location.clone().bump(direction.previous());
                    adjacent = get(working);
                    if (adjacent != null && !(adjacent instanceof WalkableSprite)) // The two diagonals are impassible
                    {
                        return false;
                    }
                }
            }
        }
        
        // The path is not blocked
        if (destination == null) {return true;}

        if (destination instanceof PlayerCharacter && 
            ! (mover instanceof PlayerCharacter)) 
        {return true;} // enemies can impact characters
        if (! (mover instanceof PlayerCharacter)) {return false;} // non players can't land on special spaces
        // Only players left
        
        if (destination instanceof InteractableSprite &&  // If you could walk on it
            ((InteractableSprite) destination).interactionAllowed(character)) // and are allowed
        {return true;}

        return destination instanceof WalkableSprite; // If you can walk on it do so
    }

   public boolean move(MovingSprite s, Direction d)
    {
        if (! s.isReadyToMove()) {return false;}
        Location originalLocation = s.getLocation().clone();
        if (d != null && isLegalMove(s, originalLocation, d))
        {
            s.getLocation().bump(d);
            Sprite destination = get(s.getLocation());
            if (s instanceof PlayerCharacter && destination instanceof Item)
            {
                Item i = (Item) destination;
                i.applyTo(character);
            } else if (destination instanceof InteractableSprite)
            {
                InteractableSprite is = (InteractableSprite) destination;
                if (! is.initiateInteraction(character))
                {
                    return false; // Don't finish the move if failed
                }
            } else if (destination instanceof PlayerCharacter &&
                       s instanceof BasicEnemy)
            {
                BasicEnemy enemy = (BasicEnemy) s;
                enemy.attack(destination);
                replace(originalLocation, enemy, null);
                return true;
            }
            set((Sprite) s, s.getLocation());
            set(null, originalLocation);
            return true;
        }
        return false;
    }

    @Override
    public void paint(Graphics g) 
    {
        super.paint(g);
        character.tick();
        updateAutos(g);
        move(character, character.getDirection());        
    }
   
    private synchronized void updateAutos(Graphics g)
    {
        currentlyUpdating = true;
        for (Iterator<AutonomousSprite> i = autos.iterator(); i.hasNext(); )
        {
            AutonomousSprite s = i.next();
            s.tick();
            if (s.isRemove())
            {
                i.remove();
                continue;
            }
            Sprite target = get(s.getLocation());
            if (target != null && target != s)
            {
                replace(target.getLocation(), target, s.impact(target));
                i.remove();
                draw(g, (Sprite) s);
                continue;
            }
            try 
            {
                s.update();
            } catch (IOException ex) 
            {
                Logger.getLogger(Map.class.getName()).log(Level.SEVERE, null, ex);
            }
            draw(g, (Sprite) s);
        }
        autos.addAll(addToAutos);
        addToAutos.clear();
        currentlyUpdating = false;
    }           

    public void setCharacter(PlayerCharacter c) 
    {
        character = c;
        c.setLocation(new Location(5, 1));
        set(character, c.getLocation());
    }

    @Override
    protected void calculateDisplayedMap()
    {
        int halfWidthVisible = this.getWidth() / 2 / Sprite.defaultSpriteSize + 1;
        int halfHeightVisible = this.getHeight() / 2  / Sprite.defaultSpriteSize + 1;
        
        Location mapCenter = character.getLocation().clone().bump(character.getLastFacing());
        
        topLeftStart.x = mapCenter.x - halfWidthVisible;
        topLeftStart.y = mapCenter.y - halfHeightVisible;
        bottomRightEnd.x = mapCenter.x + halfWidthVisible;
        bottomRightEnd.y = mapCenter.y + halfHeightVisible;
        
        if (topLeftStart.x < 0)
        {
            bottomRightEnd.x = bottomRightEnd.x - topLeftStart.x; 
            topLeftStart.x = 0;
        }
        
        if (bottomRightEnd.x >= map[0].length) 
        {
            bottomRightEnd.x = map[0].length - 1;
        } 
        
        if (topLeftStart.y < 0)
        {
            bottomRightEnd.y = bottomRightEnd.y - topLeftStart.y; // shift the screen down;
            topLeftStart.y = 0;
        }
        
        if (bottomRightEnd.y >= map.length) {bottomRightEnd.y = map.length - 1;} // Max bottom is the edge of the map
    }
}