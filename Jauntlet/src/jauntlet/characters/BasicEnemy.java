package jauntlet.characters;

import jauntlet.Direction;
import jauntlet.graphics.AngleMovingSprite;
import jauntlet.map.Location;
import jauntlet.graphics.AutonomousSprite;
import jauntlet.graphics.Sprite;
import jauntlet.map.PlayableMap;
import java.awt.image.BufferedImage;

/**
 *
 * @author Tony
 */
public class BasicEnemy extends AngleMovingSprite implements AutonomousSprite
{
    private int speed = 10;
    private int damage = 1;
    private PlayableMap map;

    public BasicEnemy(BufferedImage right, BufferedImage left, BufferedImage up, BufferedImage down, PlayableMap map)
    {
        super(right, left, up, down);
        this.map = map;
    }
    
    @Override
    public void update() 
    {
        Direction d = null;
        Location nearest = map.getNearestCharacter(myLocation);
        int xDiff = nearest.x - myLocation.x;
        int yDiff = nearest.y - myLocation.y;

        d = (xDiff > 0) ? Direction.RIGHT : (xDiff < 0) ? Direction.LEFT : null;
        if (d == null)
        {
            d = (yDiff > 0) ? Direction.DOWN : (yDiff < 0) ? Direction.UP : null;
        } else if (yDiff > 0)
        {
            d = (d == Direction.LEFT) ? Direction.DOWN_LEFT : Direction.DOWN_RIGHT;
        } else if (yDiff < 0)
        {
            d = (d == Direction.LEFT) ? Direction.UP_LEFT : Direction.UP_RIGHT;
        }
        if (! map.move(this, d)) // Try to move towards the nearest character
        {
            if (! map.move(this, d.next())) // If you can't try one step counter-clockwise
            {
                map.move(this, d.previous()); // If you still can't try one step clockwise
            }
        }
    }

    @Override
    public Sprite impact(Sprite s) 
    {
        return s.takeDamage(damage);
    }

    @Override
    public Sprite takeDamage(int amount) 
    {
        damage = damage - amount;
        if (damage <= 0)
        {
            return null;
        } else
        {
            return this;
        }
    }

    public void attack(Sprite destination)
    {
        destination.takeDamage(damage);
    }
}