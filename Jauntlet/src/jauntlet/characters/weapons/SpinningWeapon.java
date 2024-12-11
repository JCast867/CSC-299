package jauntlet.characters.weapons;

import jauntlet.characters.PlayerCharacter;
import jauntlet.graphics.AutonomousSprite;
import jauntlet.graphics.MovingSprite;
import jauntlet.graphics.Sprite;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Tony
 */
public class SpinningWeapon extends MovingSprite implements ProjectileWeapon, AutonomousSprite
{
    private PlayerCharacter shooter;
    private int damage = 1;
    private List<BufferedImage> images;
    private int cycle;
    
    public SpinningWeapon(PlayerCharacter shooter, List<BufferedImage> stages) 
    {
        this.shooter = shooter;
        this.images = stages;
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
        cycle++;
        if (cycle >= images.size())
        {
            cycle = 0;
        }
        currentImage = images.get(cycle);
        myLocation.bump(direction);
    }
    
    @Override
    public void persist(BufferedWriter out) throws IOException {} // Not placed on the map for saving
    
    @Override
    public void completeLoad(String[] options){}
}