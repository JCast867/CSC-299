package jauntlet.graphics;

import jauntlet.Direction;
import jauntlet.map.Location;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Tony
 */
public abstract class MovingSprite extends Sprite
{
    protected int speed = 10;
    private int speedCycle = 0;
    private boolean moveOK = true;
    protected Direction direction;
    protected BufferedImage currentImage;

    public void tick()
    {
        if (moveOK) return;
        speedCycle++;
        
        if (speedCycle >= speed)
        {
            speedCycle = 0;
            moveOK = true;
        }
        
    }
    public boolean isReadyToMove()
    {
        if (moveOK)
        {
            speedCycle = 0;
            return true;
        } else
        {
            return false;
        }
    }
    
    public Direction getDirection()
    {
        return direction;
    }

    public void setDirection(Direction direction)
    {
        this.direction = direction;
    }

    @Override
    public void draw(Graphics g, int x, int y)
    {
        g.drawImage(currentImage, x, y, null);
    }

    @Override
    public Sprite takeDamage(int amount) 
    {
        return this;
    }

    @Override
    public void setLocation(Location location) 
    {
        super.setLocation(location);
        moveOK = false;
    }   
}