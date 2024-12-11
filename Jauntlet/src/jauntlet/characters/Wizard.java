package jauntlet.characters;

import jauntlet.characters.weapons.ProjectileWeapon;
import jauntlet.characters.weapons.Bolt;
import jauntlet.graphics.ImageFactory;
import java.awt.image.BufferedImage;

/**
 *
 * @author Tony
 */
public class Wizard extends PlayerCharacter
{
    public Wizard(BufferedImage right, BufferedImage left, BufferedImage up, BufferedImage down) 
    {
        super(right, left, up, down);
        this.speed = 5;
        this.maxHealth = 40;
        this.addHealth(30);
    }

    @Override
    protected ProjectileWeapon createBolt() 
    {
        ImageFactory imf = ImageFactory.getInstance();
        return new Bolt(this, 
                        imf.getImage("./assets/missle-right.png"), imf.getImage("./assets/missle-left.png"), 
                        imf.getImage("./assets/missle-up.png"), imf.getImage("./assets/missle-down.png"),
                        imf.getImage("./assets/missle-up-right.png"), imf.getImage("./assets/missle-up-left.png"),
                        imf.getImage("./assets/missle-down-right.png"), imf.getImage("./assets/missle-down-left.png"));
    }
    
    
}
