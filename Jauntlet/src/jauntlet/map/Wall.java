package jauntlet.map;

import jauntlet.graphics.Sprite;
import static jauntlet.graphics.Sprite.defaultSpriteSize;
import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 *
 * @author Tony
 */
public class Wall extends Sprite
{
    public Wall(Location l)
    {
        setLocation(l);
    }

    @Override
    public void draw(Graphics g, int x, int y) 
    {
        g.setColor(Color.DARK_GRAY);
        g.fill3DRect(x, y, defaultSpriteSize, defaultSpriteSize, true);
    }

    @Override
    public Sprite takeDamage(int amount) 
    {
        return this;
    }

    @Override
    public void persist(BufferedWriter out) throws IOException 
    {
        persistBase(out);
    }

    @Override
    public void completeLoad(String[] options){}
}