package jauntlet.graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Tony
 */
public class ImageFactory 
{
    private static ImageFactory singleton = new ImageFactory();
    public static ImageFactory getInstance() {return singleton;}
    
    private ImageFactory() {}
    
    private Map<String, BufferedImage> images = new HashMap<>();
    
    public List<BufferedImage> getImages(String... paths)
    {
        List<BufferedImage> images = new ArrayList<>();
        for (String p : paths)
        {
            images.add(getImage(p));
        }
        return images;
    }
    
    public BufferedImage getImage(String path)
    {
        BufferedImage image = images.get(path);
        if (image != null) {return image;}
        
        try 
        {
            image = ImageIO.read(new File(path));
        } catch (IOException ex) 
        {
            Logger.getLogger(ImageFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        images.put(path, image);
        return image;
    }
}