package jauntlet.characters;

import jauntlet.Direction;
import jauntlet.map.Location;
import jauntlet.graphics.AutonomousSprite;
import jauntlet.graphics.Sprite;
import jauntlet.map.PlayableMap;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Tony
 */
public class Spawner extends Sprite implements AutonomousSprite
{
    private int stage = 0;
    private int spawnCycle = 0;
    private final int spawnRate = 40;
    private List<BufferedImage> stages;
    private PlayableMap map;
    private SpawnFactory sf;

    @Override
    public void tick() 
    {
        // No changes over time currently
    }
    
    public Spawner(List<BufferedImage> stageImages)
    {
        this.sf  = new SpawnFactory();
        stages   = stageImages;
    }

    public void setMap(PlayableMap map)
    {
        this.map = map;
    }
    
    @Override
    public void draw(Graphics g, int x, int y) 
    {
        g.drawImage(stages.get(stage), x, y, null);
    }

    @Override
    public Sprite takeDamage(int amount) 
    {
        stage = stage + 1;
        if (stage >= stages.size())
        {
            return null;
        } else
        {
            return this;
        }
    }

    @Override
    public void update() throws IOException
    {
        spawnCycle++;
        if (spawnCycle == spawnRate)
        {
            spawnCycle = 0;
            BasicEnemy newBaddie = sf.spawn(map);
            for (Direction d : Direction.values())
            {
                Location spawnLocation = myLocation.clone().bump(d);
                if (map.isEmpty(spawnLocation))
                {
                    map.setSprite(newBaddie, spawnLocation);
                    break;
                }
            }
        }
    }

    @Override
    public void setDirection(Direction d){ /* Does not move */ }
    
    @Override
    public Sprite impact(Sprite s) 
    {
        return s; // Does not do anything when run into
    }
    
    @Override
    public void persist(BufferedWriter out) throws IOException 
    {
        persistBase(out);
//        out.write(", " + );
    }

    @Override
    public void completeLoad(String[] options){}
}