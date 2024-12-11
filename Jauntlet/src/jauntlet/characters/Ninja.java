package jauntlet.characters;

import jauntlet.characters.weapons.ProjectileWeapon;
import jauntlet.characters.weapons.SpinningWeapon;
import jauntlet.graphics.ImageFactory;
import java.awt.image.BufferedImage;

/**
 *
 * @author Tony
 */
public class Ninja extends PlayerCharacter
{
    public Ninja(BufferedImage right, BufferedImage left, BufferedImage up, BufferedImage down)
    {
        super(right, left, up, down);
        this.speed = 2;
        this.maxHealth = 60;
        this.addHealth(50);
    }

    @Override
    protected ProjectileWeapon createBolt()
    {
        ImageFactory imf = ImageFactory.getInstance();
        return new SpinningWeapon(this, 
                                  imf.getImages("./assets/star-1.png", "./assets/star-2.png"));
    }
}
