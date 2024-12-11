package jauntlet.characters.weapons;

import jauntlet.Direction;
import jauntlet.graphics.AutonomousSprite;
import jauntlet.graphics.Sprite;
import jauntlet.map.Location;

/**
 *
 * @author Tony
 */
public interface ProjectileWeapon extends AutonomousSprite
{
    public void setLocation(Location l);
    public void setDirection(Direction d);
    public Sprite impact(Sprite sprite);
}