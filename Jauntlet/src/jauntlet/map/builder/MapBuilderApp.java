package jauntlet.map.builder;

import javax.swing.JFrame;

/**
 *
 * @author Tony
 */
public class MapBuilderApp 
{
    public static void main(String[] args) 
    {
        JFrame window = new JFrame("Jauntlet Map Builder");
        AvailableSprites as = new AvailableSprites();
        MapLoader loader = new MapLoader(as);
        NewMap builder = new NewMap(loader, as);
        window.getContentPane().add(builder);
        window.setBounds(0, 0, 500, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
