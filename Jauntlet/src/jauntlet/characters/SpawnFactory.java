package jauntlet.characters;

import jauntlet.graphics.ImageFactory;
import jauntlet.map.PlayableMap;

/**
 *
 * @author Tony
 */
public class SpawnFactory 
{
    public BasicEnemy spawn(PlayableMap map)
    {
        ImageFactory imf = ImageFactory.getInstance();
        return new BasicEnemy(imf.getImage("./assets/ghost-right.png"), 
                              imf.getImage("./assets/ghost-left.png"), 
                              imf.getImage("./assets/ghost-up.png"), 
                              imf.getImage("./assets/ghost-right.png"), map);        
    }
}
