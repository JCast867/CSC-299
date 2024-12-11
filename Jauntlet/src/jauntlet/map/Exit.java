package jauntlet.map;

import jauntlet.characters.PlayerCharacter;
import jauntlet.graphics.InteractableSprite;
import jauntlet.graphics.Sprite;
import static jauntlet.graphics.Sprite.defaultSpriteSize;
import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 *
 * @author <Tony>
 */
public class Exit extends Sprite implements InteractableSprite
{
    private static final Color EXIT_COLOR = Color.BLACK;
    private static final Color EXIT_TEXT = Color.WHITE;
    private String nextMap;
    private String exitText = "Exit";

    public Exit()
    {
    }
    
    @Override
    public void draw(Graphics g, int x, int y) 
    {
        g.setColor(EXIT_COLOR);
        g.fillRect(x, y, defaultSpriteSize, defaultSpriteSize);
        g.setColor(EXIT_TEXT);
        g.drawString(exitText, x + 2, y + defaultSpriteSize/2 - 2);
    }

    @Override
    public Sprite takeDamage(int amount) 
    {
        return this;
    }

    @Override
    public boolean interactionAllowed(PlayerCharacter c) 
    {
        return true;
    }

    @Override
    public boolean initiateInteraction(PlayerCharacter c) {
        return true;
    }

    @Override
    public void persist(BufferedWriter out) throws IOException 
    {
        persistBase(out);
        out.write(", " + nextMap);
    }

    @Override
    public void completeLoad(String[] options)
    {
        nextMap = options[3].trim();
    }

    public void setExitText(String exitText)
    {
        this.exitText = exitText;
    }

    public void setNextMap(String nextMap)
    {
        this.nextMap = nextMap;
    }
    
}
