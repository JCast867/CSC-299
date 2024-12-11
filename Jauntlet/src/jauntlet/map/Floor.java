package jauntlet.map;

import jauntlet.graphics.SingleImageSprite;
import jauntlet.graphics.Sprite;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Tony
 */
public class Floor extends SingleImageSprite
{
    public Floor(BufferedImage image)
    {
        super(image);
    }
    
//    @Override
//    public void draw(Graphics g, int x, int y)
//    {
//        g.setColor(Color.GRAY);
//        g.fillRect(x, y, defaultSpriteSize, defaultSpriteSize);
//        
//        g.setColor(Color.DARK_GRAY);
//        int number = 5;
//        for (int i = 0; i < number; i++)
//        {
//            int nextLevel = myLocation.y + i * defaultSpriteSize / number;
//            g.drawLine(x, nextLevel, x + defaultSpriteSize, nextLevel);
//            int shift = (i % 2) * defaultSpriteSize / number / 2;
//            for (int j = 0; j < number; j++)
//            {
//                int nextBrick = x + j * defaultSpriteSize / number + shift;
//                g.drawLine(nextBrick, nextLevel, nextBrick, nextLevel + defaultSpriteSize);
//            }
//        }
//    }   

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