package jauntlet.characters.weapons;

import jauntlet.characters.PlayerCharacter;
import jauntlet.graphics.AngleMovingSprite;
import jauntlet.graphics.AutonomousSprite;
import jauntlet.graphics.Sprite;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 *
 * @author Tony
 */
public class Bolt extends AngleMovingSprite implements ProjectileWeapon, AutonomousSprite
{
    private PlayerCharacter shooter;
    private int damage = 1;
    
    public Bolt(PlayerCharacter shooter, 
                BufferedImage right, BufferedImage left, BufferedImage up, BufferedImage down,
                BufferedImage upRight, BufferedImage upLeft, BufferedImage downRight, BufferedImage downLeft)
    {
        super(right, left, up, down, upRight, upLeft, downRight, downLeft);
        this.shooter = shooter;
    }

    @Override
    public Sprite impact(Sprite sprite) 
    {
        shooter.boltImpacted(this);
        return sprite.takeDamage(damage);        
    }

    @Override
    public void update() throws IOException 
    {
        myLocation.bump(direction);        
    }
    
    
}
