package jauntlet.items;

import jauntlet.characters.PlayerCharacter;
import jauntlet.graphics.Sprite;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 *
 * @author Tony
 */
public class Key extends BaseItem implements Item
{
    @Override
    public void applyTo(PlayerCharacter c) 
    {
        c.addItem(this);
    }
    
    public Key(BufferedImage image) 
    {
        super(image);
    }
    
    @Override
    public Sprite takeDamage(int amount) 
    {
        return this;
    }

    @Override
    public void persist(BufferedWriter out) throws IOException 
    {
        persistBase(out);
    }

    @Override
    public void completeLoad(String[] options){}
}
