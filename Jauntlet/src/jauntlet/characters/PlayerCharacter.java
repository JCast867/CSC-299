package jauntlet.characters;

import jauntlet.characters.weapons.ProjectileWeapon;
import jauntlet.Direction;
import jauntlet.graphics.AngleMovingSprite;
import jauntlet.map.Location;
import jauntlet.graphics.Sprite;
import jauntlet.items.Item;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Tony
 */
public abstract class PlayerCharacter extends AngleMovingSprite
{
    protected int maxHealth = 10;
    protected int boltLimit = 3;
    private int treasure;
    private int health;
    private Direction lastFacing = Direction.RIGHT;
    private List<ProjectileWeapon> bolts;
    private List<Item> items;
    
    public PlayerCharacter(BufferedImage right, BufferedImage left, BufferedImage up, BufferedImage down)
    {
        super(right, left, up, down);
        items = new ArrayList<>();
        bolts = new ArrayList<>();
    }

    public ProjectileWeapon attack()
    {
        if (bolts.size() >= boltLimit) {return null;}
        
        ProjectileWeapon bolt = createBolt();
        bolts.add(bolt);
        bolt.setDirection(lastFacing);
        Location boltLocation = myLocation.clone();
        boltLocation.bump(lastFacing);
        bolt.setLocation(boltLocation);
        return bolt;
    }
    
    protected abstract ProjectileWeapon createBolt();

    public void boltImpacted(ProjectileWeapon bolt) 
    {
        bolts.remove(bolt);
    }

    public void addItem(Item i)
    {
        items.add(i);
    }

    public boolean checkAndRemove(Class itemClass) 
    {
        for (Iterator<Item> i = items.iterator(); i.hasNext(); )
        {
            Item item = i.next();
            if (item.getClass().equals(itemClass))
            {
                i.remove();
                return true;
            }
        }
        return false;
    }

    public boolean containsInstance(Class itemClass) 
    {
        for (Item i : items)
        {
            if (i.getClass().equals(itemClass))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public Sprite takeDamage(int amount)
    {
        health -= amount;
        if (health <= 0)
        {
            return null;
        }
        return this;
    }
    
    public void addHealth(int healthBenefit) 
    {
        health += healthBenefit;
        if (health > maxHealth)
        {
            health = maxHealth;
        }
    }
    
    public void addTreasure(int amount)
    {
        treasure += amount;
    }

    @Override
    public void setDirection(Direction direction) 
    {
        super.setDirection(direction);
        if (direction != null)
        {
            lastFacing = direction;
        }
    }


    
    
    public int getHealth() {return health;}
    public int getMaxHealth() {return maxHealth;}
    public int getTreasure() {return treasure;}
    public List<Item> getItems() {return items;}
    public Direction getLastFacing() {return lastFacing;}
}