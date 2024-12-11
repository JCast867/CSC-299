package jauntlet.graphics;

import jauntlet.Direction;
import jauntlet.map.Location;
import java.awt.Graphics;
import java.io.IOException;

/**
 *
 * @author Tony
 */
public interface AutonomousSprite 
{
    public void update() throws IOException;
    public void draw(Graphics g, int x, int y);
    public Location getLocation();
    public Sprite impact(Sprite s);
    public void tick();

    public boolean isRemove();

    public void setDirection(Direction d);
}
