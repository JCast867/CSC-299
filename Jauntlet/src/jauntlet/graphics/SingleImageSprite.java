package jauntlet.graphics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Tony
 */
public abstract class SingleImageSprite extends Sprite
{
    protected BufferedImage image;

    public SingleImageSprite(BufferedImage image) 
    {
        this.image = image;
    }
    
    @Override
    public void draw(Graphics g, int x, int y) 
    {
        g.drawImage(image, x, y, null);
    }    
}
