package jauntlet;

import jauntlet.characters.PlayerCharacter;
import jauntlet.graphics.Sprite;
import jauntlet.items.Item;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Tony
 */
public class GameStatusBar extends JPanel
{
    private PlayerCharacter character;

    public GameStatusBar(PlayerCharacter character) 
    {
        this.character = character;
        this.setPreferredSize(new Dimension(300, 30));
    }

    @Override
    public void paint(Graphics g) 
    {
        g.setColor(Color.DARK_GRAY);
        g.fill3DRect(0, 0, this.getWidth(), this.getHeight(), true);
        g.setColor(Color.YELLOW);
        g.drawString("Health: " + character.getHealth() + "/" + character.getMaxHealth(), 5, 12);
        g.drawString("Treasure: " + character.getTreasure(), 5, 25);
        
        int count = 0;
        for (Item i : character.getItems())
        {
            i.paintAt(g, 100 + count++ * Sprite.defaultSpriteSize, 5);
        }
    }
    
    
    
}
