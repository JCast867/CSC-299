package jauntlet;

import jauntlet.map.Map;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author Tony
 */
public class GameController implements ActionListener
{
    private Timer timer;
    private Map map;
    private GameStatusBar status;
    
    public GameController(Map map, GameStatusBar status) 
    {
        this.map = map;
        this.status = status;
        timer = new Timer(1000/20, this);
    }
    
    public void start()
    {
        timer.start();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        map.repaint();
        status.repaint();
    }
}