package jauntlet.map.builder;

import jauntlet.graphics.ImageFactory;
import jauntlet.graphics.Sprite;
import jauntlet.map.Floor;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Tony
 */
public class MapEditorWindow extends JFrame
{
    private boolean saved;
    private MapEditor map;
    private SpriteSelectionPanel ssp;
    private AvailableSprites as;

    public MapEditorWindow(MapEditor map, AvailableSprites as) 
    {
        this.map = map;
        this.as = as;
        this.ssp = new SpriteSelectionPanel(as.getCandidates());
        ssp.setPreferredSize(new Dimension(Sprite.defaultSpriteSize * 2, this.getHeight()));
        map.setSsp(ssp);
        
        this.setTitle(map.getName());
        this.setBounds(10, 10, 800, 700);
        this.setVisible(true);
        this.getContentPane().add(ssp, BorderLayout.WEST);
        this.getContentPane().add(map);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e) 
            {
                if (saved)
                {
                    return;
                }
                switch (JOptionPane.showConfirmDialog(MapEditorWindow.this, "Unsaved, do you wish to save?"))
                {
                    case JOptionPane.YES_OPTION: 
                    {
                        try {
                            map.save(new File(map.getName() + MapLoader.MAP_EXTENSION));
                            dispose();
                        } catch (IOException ex) {
                            Logger.getLogger(MapEditorWindow.class.getName()).log(Level.SEVERE, null, ex);
                            JOptionPane.showMessageDialog(null, "Error when saving");
                        }
                    }
                        break;

                    case JOptionPane.NO_OPTION: dispose(); break;
                    case JOptionPane.CANCEL_OPTION: break;
                }
            }
        });
    }

    public MapEditorWindow(int width, int height, String mapName, AvailableSprites as) 
    {
        this(new MapEditor(width, height, new Floor(ImageFactory.getInstance().getImage("./assets/floor.png"))), as);
    }
}