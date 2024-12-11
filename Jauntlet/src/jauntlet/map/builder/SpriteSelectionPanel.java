package jauntlet.map.builder;

import jauntlet.graphics.Sprite;
import jauntlet.map.Location;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Tony
 */
public class SpriteSelectionPanel extends JPanel implements MouseListener
{
    private List<Sprite> candiates;
    private Sprite selected;

    public SpriteSelectionPanel(List<Sprite> candiates) 
    {
        this.candiates = candiates;
        selected = candiates.get(0);
        this.addMouseListener(this);
    }

    @Override
    public void paint(Graphics g) 
    {
        g.setColor(new Color(0x333333));
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.YELLOW);
        g.setFont(new Font(g.getFont().getName(), Font.BOLD, 8));
        g.drawString("Sprite Selection", 0, 15);
        int count = 1;
        g.setColor(Color.GRAY);
        g.drawRect(0, Sprite.defaultSpriteSize - 1, Sprite.defaultSpriteSize, candiates.size() * Sprite.defaultSpriteSize + 2);
        for (Sprite s: candiates)
        {
            Location l = new Location(0, count++);
            s.setLocation(l);
            s.draw(g, s.getLocation().x * Sprite.defaultSpriteSize, s.getLocation().y * Sprite.defaultSpriteSize);
            if(s == selected)
            {
                g.setColor(Color.YELLOW);
                g.drawRect(0, l.y * Sprite.defaultSpriteSize, Sprite.defaultSpriteSize, Sprite.defaultSpriteSize);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) 
    {
        if (e.getX() > Sprite.defaultSpriteSize) {return;}
        int index = e.getY() / Sprite.defaultSpriteSize - 1;
        if (index >= candiates.size() || index < 0) {return;}
        selected = candiates.get(index);
        this.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e){}

    @Override
    public void mouseReleased(MouseEvent e){}

    @Override
    public void mouseEntered(MouseEvent e){}

    @Override
    public void mouseExited(MouseEvent e){}

    public Sprite getSelected() 
    {
        return selected.clone();
    }
}