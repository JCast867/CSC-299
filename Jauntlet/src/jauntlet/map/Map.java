package jauntlet.map;

import jauntlet.graphics.Sprite;
import static jauntlet.graphics.Sprite.defaultSpriteSize;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Tony
 */
public abstract class Map extends JPanel
{
    protected Sprite [][] map;
    protected Sprite floor;
    protected Location topLeftStart;
    protected Location bottomRightEnd;

    public Map(int width, int height, Sprite defaultFloor, Location topLeftStart, Location bottomRightEnd)
    {
        map                 = new Sprite[height][width];
        floor               = defaultFloor;
        this.topLeftStart   = topLeftStart;
        this.bottomRightEnd = bottomRightEnd;
    }

    protected abstract void calculateDisplayedMap();
    
    public void setSprite(Sprite s, Location l)
    {
        set(s, l);
    }

    @Override
    public void paint(Graphics g)
    {
        calculateDisplayedMap();
        Location floorLocation = new Location(0, 0);
        floor.setLocation(floorLocation);
        
        for (int row = topLeftStart.y; row <= bottomRightEnd.y; row++)
        {
            for (int column = topLeftStart.x; column <= bottomRightEnd.x; column++)
            {
                Sprite s = map[row][column];
                draw(g, floor);
                if (s != null)
                {
                    draw(g, s);
                }
                floorLocation.x += 1;
            }
            floorLocation.x = 0;
            floorLocation.y += 1;
        }
    }

    protected void set(Sprite s, Location at)
    {
        map[at.y][at.x] = s;
        if (s != null) s.setLocation(at);
    }
    
    protected Sprite get(Location l)
    {
        return map[l.y][l.x];
    }

    public void addHorizontalWall(int startX, int stopX, int y)
    {
        for (int i = startX; i <= stopX; i++)
        {
            Location l = new Location(i, y);
            set(new Wall(l), l);
        }
    }

    public void addVerticalWall(int startY, int stopY, int x)
    {
        for (int i = startY; i <= stopY; i++)
        {
            Location l = new Location(x, i);
            set(new Wall(l), l);
        }
    }

    public boolean isEmpty(Location l) 
    {
        return map[l.y][l.x] == null;
    }

    protected void replace(Location l, Sprite original, Sprite replacement) 
    {
        if (replacement == null)
        {
            set(null, l);
        } else
        {
            setSprite(replacement, l);
        }

        if (original != replacement)
        {
           original.setRemove(true);
        }
    }
    
    protected void draw(Graphics g, Sprite s)
    {
        int xIndex = s.getLocation().x - topLeftStart.x;
        int yIndex = s.getLocation().y - topLeftStart.y;
        if (s instanceof Floor) {
        	xIndex = s.getLocation().x;
        	yIndex = s.getLocation().y;
        }
        s.draw(g, xIndex * defaultSpriteSize, yIndex * defaultSpriteSize);
    }
}