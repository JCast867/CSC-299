package jauntlet;

import jauntlet.characters.PlayerCharacter;
import jauntlet.map.PlayableMap;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

/**
 *
 * @author Tony
 */
public class UserControls extends KeyAdapter
{
    java.util.Map<Direction, Boolean> currentlyHeld = new HashMap<>();

    private PlayableMap map;
    private PlayerCharacter character;

    public UserControls(PlayableMap map, PlayerCharacter character)
    {
        this.character = character;
        this.map = map;
    }

    @Override
    public void keyReleased(KeyEvent e) 
    {
        switch (e.getKeyChar()) 
        {
            case 'w':
                currentlyHeld.remove(Direction.UP);
                break;
            case 's':
                currentlyHeld.remove(Direction.DOWN);
                break;
            case 'a':
                currentlyHeld.remove(Direction.LEFT);
                break;
            case 'd':
                currentlyHeld.remove(Direction.RIGHT);
                break;
        }
        character.setDirection(checkDirection());
    }
    
    @Override
    public void keyPressed(KeyEvent e)
    {
        switch (e.getKeyChar()) 
        {
            case 'w':
                currentlyHeld.put(Direction.UP, Boolean.TRUE);
                currentlyHeld.remove(Direction.DOWN);
                break;
            case 's':
                currentlyHeld.put(Direction.DOWN, Boolean.TRUE);
                currentlyHeld.remove(Direction.UP);
                break;
            case 'a':
                currentlyHeld.put(Direction.LEFT, Boolean.TRUE);
                currentlyHeld.remove(Direction.RIGHT);
                break;
            case 'd':
                currentlyHeld.put(Direction.RIGHT, Boolean.TRUE);
                currentlyHeld.remove(Direction.LEFT);
                break;
            case ' ':
                map.attack();
                break;
        }
        character.setDirection(checkDirection());
    }
    
    private Direction checkDirection()
    {
        if (currentlyHeld.size() > 0)
        {
            int total = 0;
            for (Direction held : currentlyHeld.keySet())
            {
                total += held.getValue();
            }
            return Direction.valueOf(total);
        }
        return null;
    }        
}