package jauntlet.characters;

import jauntlet.characters.weapons.Bolt;
import jauntlet.characters.weapons.ProjectileWeapon;
import jauntlet.graphics.ImageFactory;
import java.awt.image.BufferedImage;

/**
 *
 * @author Tony
 */
public class Elf extends PlayerCharacter
{
    public Elf(BufferedImage right, BufferedImage left, BufferedImage up, BufferedImage down)
    {
        super(right, left, up, down);
        this.speed = 3;
        this.maxHealth = 40;
        this.addHealth(30);
    }

    @Override
    protected ProjectileWeapon createBolt()
    {
        ImageFactory imf = ImageFactory.getInstance();
        return new Bolt(this, 
                        imf.getImage("./assets/arrow-right.png"), imf.getImage("./assets/arrow-left.png"), 
                        imf.getImage("./assets/arrow-up.png"), imf.getImage("./assets/arrow-down.png"),
                        imf.getImage("./assets/arrow-up-right.png"), imf.getImage("./assets/arrow-up-left.png"),
                        imf.getImage("./assets/arrow-down-right.png"), imf.getImage("./assets/arrow-down-left.png"));
    }

}