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
public class Food extends BaseItem implements Item
{
    private int healthBenefit = 10;
    
    public Food(BufferedImage image) {super(image);}
    
    @Override
    public Sprite takeDamage(int amount) 
    {
        healthBenefit -= amount;
        if (healthBenefit > 0)
        {
            return this;
        }
        return null;
    }

    @Override
    public void applyTo(PlayerCharacter c) 
    {
        c.addHealth(healthBenefit);
    }

    @Override
    public void persist(BufferedWriter out) throws IOException 
    {
        persistBase(out);
        out.write(", " + healthBenefit);
    }

    @Override
    public void completeLoad(String[] options)
    {
        healthBenefit = Integer.parseInt(options[3].trim());
    }
}