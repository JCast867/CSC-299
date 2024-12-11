package jauntlet.characters;

import jauntlet.characters.weapons.SpinningWeapon;
import jauntlet.characters.weapons.ProjectileWeapon;
import jauntlet.graphics.ImageFactory;
import java.awt.image.BufferedImage;

/**
 *
 * @author Tony
 */
public class Barbarian extends PlayerCharacter
{
    public Barbarian(BufferedImage right, BufferedImage left, BufferedImage up, BufferedImage down)
    {
        super(right, left, up, down);
        this.speed = 6;
        this.maxHealth = 80;
        this.addHealth(50);
    }

    @Override
    protected ProjectileWeapon createBolt()
    {
        ImageFactory imf = ImageFactory.getInstance();
        return new SpinningWeapon(this, 
                                  imf.getImages("./assets/star-1.png", "./assets/star-2.png"));
//                                  imf.getImages("./assets/axe-1.png", "./assets/axe-3.png", 
//                                                "./assets/axe-3.png", "./assets/axe-4.png"));
    }
}