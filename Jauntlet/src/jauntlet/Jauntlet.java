package jauntlet;

import jauntlet.characters.Barbarian;
import jauntlet.characters.Elf;
import jauntlet.characters.Ninja;
import jauntlet.characters.PlayerCharacter;
import jauntlet.map.Floor;
import jauntlet.characters.Wizard;
import jauntlet.graphics.ImageFactory;
import jauntlet.graphics.Sprite;
import jauntlet.map.PlayableMap;
import jauntlet.map.builder.AvailableSprites;
import jauntlet.map.builder.MapLoader;
import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Tony
 */
public class Jauntlet
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        ImageFactory imf = ImageFactory.getInstance();
        int width = 200;
        int height = 200;

        PlayerCharacter ninja = new Ninja(imf.getImage("./assets/ninja-right.png"), 
                                            imf.getImage("./assets/ninja-left.png"), 
                                            imf.getImage("./assets/ninja-up.png"),
                                            imf.getImage("./assets/ninja-down.png"));

        PlayerCharacter barbarian = new Barbarian(imf.getImage("./assets/barbarian-right.png"), 
                                            imf.getImage("./assets/barbarian-left.png"), 
                                            imf.getImage("./assets/barbarian-up.png"),
                                            imf.getImage("./assets/barbarian-right.png"));

        PlayerCharacter wizard = new Wizard(imf.getImage("./assets/wizard-right.png"), 
                                            imf.getImage("./assets/wizard-left.png"), 
                                            imf.getImage("./assets/wizard-up.png"),
                                            imf.getImage("./assets/wizard-right.png"));
        
        PlayerCharacter elf = new Elf(imf.getImage("./assets/elf-right.png"), 
                                      imf.getImage("./assets/elf-left.png"), 
                                      imf.getImage("./assets/elf-up.png"),
                                      imf.getImage("./assets/elf-down.png"));
        PlayerCharacter character = ninja;
        
        Floor f = new Floor(imf.getImage("./assets/floor.png"));
        PlayableMap map = null;
        MapLoader loader = new MapLoader(new AvailableSprites());
        try
        {
            map = (PlayableMap) loader.loadMap(new File("TestMe.txt"), false);
            map.setCharacter(character);
        } catch (IOException ex)
        {
            Logger.getLogger(Jauntlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        GameStatusBar status = new GameStatusBar(character);
        GameController controller = new GameController(map, status);
        
        JFrame window = new JFrame("Jauntlet");
        window.setBounds(0, 0, (width) * Sprite.defaultSpriteSize, (height+2) * Sprite.defaultSpriteSize);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(status, BorderLayout.NORTH);
        window.getContentPane().add(map);
        window.setVisible(true);
        
        window.setFocusTraversalKeysEnabled(false);
        window.addKeyListener(new UserControls(map, character));
        controller.start();
    }
}