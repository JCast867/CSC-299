package jauntlet.map.builder;

import jauntlet.graphics.Sprite;
import jauntlet.map.Floor;
import jauntlet.map.Location;
import jauntlet.map.Map;
import jauntlet.map.Wall;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Tony
 */
public class MapEditor extends Map implements MouseListener, MouseMotionListener
{
    private final int width;
    private final int height;
    private SpriteSelectionPanel ssp;

    private int startX = -1;
    private int startY = -1;
    private int endX   = -1;
    private int endY   = -1;
    
    public MapEditor(int width, int height, Sprite defaultFloor)
    {
        super(width, height, defaultFloor, new Location(0, 0), new Location(width-1, height-1));
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.width = width;
        this.height = height;
        this.addVerticalWall(0, height - 1, 0);
        this.addVerticalWall(0, height - 1, width - 1);
        this.addHorizontalWall(0, width - 1, 0);
        this.addHorizontalWall(0, width - 1, height - 1);
    }

    @Override
    public void paint(Graphics g) 
    {
        super.paint(g);
        g.setColor(Color.GREEN);
        for (int x = 0; x < width; x++)
        {
            g.drawLine(x * Sprite.defaultSpriteSize, 0, x * Sprite.defaultSpriteSize, this.getHeight());
        }

        for (int y = 0; y < width; y++)
        {
            g.drawLine(0, y * Sprite.defaultSpriteSize, this.getWidth(), y * Sprite.defaultSpriteSize);
        }
    }

    public void save(File to) throws IOException
    {
        BufferedWriter out = new BufferedWriter(new FileWriter(to));
        
        out.write(map[0].length + ", " + map.length);
        out.newLine();
        floor.persist(out);
        out.newLine();
        for (Sprite[] row : map)
        {
            for (Sprite s : row)
            {
                if (s != null)
                {
                    s.persist(out);
                    out.newLine();
                }
            }
        }
        out.close();
    }        
    
    @Override
    public void mouseClicked(MouseEvent e) 
    {
        int indexY = e.getY() / Sprite.defaultSpriteSize;
        if (indexY < 0 || indexY >= height) return;
        
        int indexX = e.getX() / Sprite.defaultSpriteSize;
        if (indexX < 0 || indexX >= width) return;
        
        Sprite selected = ssp.getSelected();
        if (selected instanceof Floor)
        {
            selected = null; // Use floor for clearing
        }
        this.set(selected, new Location(indexX, indexY));
        this.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        startX = e.getX() / Sprite.defaultSpriteSize;
        startY = e.getY() / Sprite.defaultSpriteSize;
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        if (endX == -1) {return;} // Not a drag
        
        if (! (ssp.getSelected() instanceof Wall)) {return;} // Only applies to walls
        
        if (startX == endX)
        {
            this.addVerticalWall(startY, endY, endX);
        } else if (startY == endY)
        {
            this.addHorizontalWall(startX, endX, endY);
        }
        
        startX = -1;
        startY = -1;
        endX = -1;
        endY = -1;
        this.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e){}

    @Override
    public void mouseExited(MouseEvent e){}

    @Override
    public void mouseDragged(MouseEvent e) 
    {
        endX = e.getX() / Sprite.defaultSpriteSize;
        endY = e.getY() / Sprite.defaultSpriteSize;
    }

    @Override
    public void mouseMoved(MouseEvent e) {}

    public void setSsp(SpriteSelectionPanel ssp) {this.ssp = ssp;}

    @Override
    protected void calculateDisplayedMap(){}
}
