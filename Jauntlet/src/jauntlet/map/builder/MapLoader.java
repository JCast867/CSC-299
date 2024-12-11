package jauntlet.map.builder;

import jauntlet.characters.Spawner;
import jauntlet.graphics.Sprite;
import jauntlet.map.Map;
import jauntlet.map.PlayableMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Tony
 */
public class MapLoader 
{
    public static final String MAP_EXTENSION = ".jlt";
    private AvailableSprites as;

    public MapLoader(AvailableSprites as) 
    {
        this.as = as;
    }

    public static boolean exists(String fileName)
    {
        return new File(fileName + MAP_EXTENSION).exists();
    }
    
    public Map loadMap(File from, boolean editable) throws IOException
    {
        BufferedReader in = new BufferedReader(new FileReader (from));
        Map map = constructMap(in, editable);
        map.setName(from.getName().substring(0, from.getName().length() - MAP_EXTENSION.length()));
        String line = in.readLine();
        while (line != null)
        {
            Sprite next = as.loadSprite(line);
            if (next != null)
            {
                map.setSprite(next, next.getLocation());
                if (next instanceof Spawner && map instanceof PlayableMap)
                {
                    Spawner spawner = (Spawner) next;
                    spawner.setMap((PlayableMap) map);
                }            
            }
            line = in.readLine();
        }
        return map;
    }

    private Map constructMap(BufferedReader in, boolean editable) throws IOException
    {
        String input = in.readLine();
        String[] dimentions = input.split(",");
        int width = Integer.parseInt(dimentions[0].trim());
        int height = Integer.parseInt(dimentions[1].trim());
        Sprite defaultFloor = as.loadSprite(in.readLine());
        if (editable)
        {
            return new MapEditor(width, height, defaultFloor);
        }
        return new PlayableMap(width, height, defaultFloor);
    }
}
