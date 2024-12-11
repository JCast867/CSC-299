package jauntlet.items;

import jauntlet.characters.PlayerCharacter;
import jauntlet.graphics.WalkableSprite;
import java.awt.Graphics;

/**
 *
 * @author Tony
 */
public interface Item extends WalkableSprite
{
    void applyTo(PlayerCharacter c);
    void paintAt(Graphics g, int x, int y);
}
