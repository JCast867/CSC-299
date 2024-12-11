package jauntlet.graphics;

import jauntlet.characters.PlayerCharacter;

/**
 *
 * @author Tony
 */
public interface InteractableSprite 
{
    /**
     * Checks if the player can interact with this sprite
     * @param c - the character
     * @return true if allowed
     */
    public boolean interactionAllowed(PlayerCharacter c);
    
    /**
     * Makes the move to interact (if allowed)
     * @param c - the character
     * @return true, if the interaction should remove the object from the map
     */
    public boolean initiateInteraction(PlayerCharacter c);
}
