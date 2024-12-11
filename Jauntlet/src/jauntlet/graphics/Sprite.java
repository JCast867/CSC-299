package jauntlet.graphics;

import jauntlet.map.Location;
import java.awt.Graphics;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tony
 */
public abstract class Sprite implements Cloneable
{
    private boolean remove;
    protected Location myLocation;
    public static final int defaultSpriteSize = 30;

    public abstract void draw(Graphics g, int x, int y);
    
    public void setLocation(Location location)
    {
        myLocation = location;
    }

    public Location getLocation() {
        return myLocation;
    }
    
    public abstract Sprite takeDamage(int amount);
    
    public boolean isRemove() 
    {
        return remove;
    }

    public void setRemove(boolean remove) 
    {
        this.remove = remove;
    }

    @Override
    public Sprite clone() 
    {
        try 
        { 
            return (Sprite) super.clone();
        } catch (CloneNotSupportedException ex) 
        {
            Logger.getLogger(Sprite.class.getName()).log(Level.SEVERE, null, ex);
            return null; 
        }
    }

    public abstract void persist(BufferedWriter out) throws IOException;
    
    protected void persistBase(BufferedWriter out) throws IOException 
    {
        out.write(this.getClass().getCanonicalName());
        out.write(", ");
        out.write(this.myLocation.toString());
    }

    public abstract void completeLoad(String[] options);
}