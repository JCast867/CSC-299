package jauntlet.items;

import jauntlet.graphics.SingleImageSprite;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Tony
 */
public abstract class BaseItem extends SingleImageSprite implements Item
{
    public BaseItem(BufferedImage image) {super(image);}
    
    @Override
    public void paintAt(Graphics g, int x, int y)
    {
        g.drawImage(image, x, y, null);
    }
    
}
