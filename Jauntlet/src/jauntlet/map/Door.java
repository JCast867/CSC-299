package jauntlet.map;

import jauntlet.characters.PlayerCharacter;
import jauntlet.graphics.InteractableSprite;
import jauntlet.graphics.Sprite;
import jauntlet.items.Key;
import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 *
 * @author Tony
 */
public class Door extends Sprite implements InteractableSprite
{
    private static final Color DOOR_COLOR = new Color(0x853500);
    private static final int DOOR_INSET = defaultSpriteSize / 2 - defaultSpriteSize / 10;
    private static final int DOOR_WIDTH = defaultSpriteSize / 5;
    private boolean vertical;

    public Door(boolean vertical) 
    {
        this.vertical = vertical;
    }
    
    @Override
    public void draw(Graphics g, int x, int y) 
    {
        g.setColor(DOOR_COLOR);
        if (vertical)
        {
            
            g.fill3DRect(x + DOOR_INSET, y, 
                         DOOR_WIDTH, defaultSpriteSize, true);
        } else
        {
            g.fill3DRect(x, y + DOOR_INSET, 
                         defaultSpriteSize, DOOR_WIDTH, true);
        }            
    }

    @Override
    public Sprite takeDamage(int amount) 
    {
        return this;
    }

    @Override
    public boolean interactionAllowed(PlayerCharacter c) 
    {
        return c.containsInstance(Key.class);
    }

    @Override
    public boolean initiateInteraction(PlayerCharacter c) {
        return c.checkAndRemove(Key.class);
    }

    @Override
    public void persist(BufferedWriter out) throws IOException 
    {
        persistBase(out);
        out.write(", " + vertical);
    }

    @Override
    public void completeLoad(String[] options)
    {
        vertical = Boolean.parseBoolean(options[3].trim());
    }
}
