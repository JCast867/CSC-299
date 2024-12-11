package jauntlet.map.builder;

import jauntlet.characters.Spawner;
import jauntlet.graphics.ImageFactory;
import jauntlet.graphics.Sprite;
import jauntlet.items.Food;
import jauntlet.items.Key;
import jauntlet.items.Treasure;
import jauntlet.map.Door;
import jauntlet.map.Exit;
import jauntlet.map.Floor;
import jauntlet.map.Location;
import jauntlet.map.Wall;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Tony
 */
public class AvailableSprites 
{
    private List<Sprite> candidates;
    private Map<String, Sprite> byName;
        
    public AvailableSprites()
    {
        candidates = new ArrayList<>();
        byName = new HashMap<>();
        ImageFactory imf = ImageFactory.getInstance();
        add(new Wall(null));
        add(new Treasure(imf.getImage("./assets/treasure.png")));
        add(new Food(imf.getImage("./assets/salad.png")));
        add(new Door(false));
        add(new Door(true));
        add(new Key(imf.getImage("./assets/key.png")));
        add(new Spawner(imf.getImages("./assets/ghost-spawner-max.png", "./assets/ghost-spawner-mid.png", "./assets/ghost-spawner-min.png")));
        add(new Exit());
        add(new Floor(imf.getImage("./assets/floor.png")));
    }

    public void add(Sprite candidate)
    {
        candidates.add(candidate);
        byName.put(candidate.getClass().getCanonicalName(), candidate);
    }
    
    public List<Sprite> getCandidates() 
    {
        return candidates;
    }
    
    public Sprite loadSprite(String line)
    {
        String[] options = line.split(",");
        
        Sprite s = byName.get(options[0]);
        if (s == null) {return null;}
        s = s.clone();
    
        s.setLocation(new Location(Integer.parseInt(options[1].trim()), Integer.parseInt(options[2].trim())));
        s.completeLoad(options);

        return s;
    }
    
}