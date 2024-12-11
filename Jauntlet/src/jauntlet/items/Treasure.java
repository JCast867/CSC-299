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
public class Treasure extends BaseItem implements Item
{
    private int amount = 100;

    public Treasure(BufferedImage image) {super(image);}
    
    @Override
    public Sprite takeDamage(int amount) 
    {
        return this;
    }

    @Override
    public void applyTo(PlayerCharacter c) 
    {
        c.addTreasure(amount);
    }

    @Override
    public void persist(BufferedWriter out) throws IOException 
    {
        persistBase(out);
        out.write(", " + amount);
    }

    @Override
    public void completeLoad(String[] options)
    {
        amount = Integer.parseInt(options[3].trim());
    }
}