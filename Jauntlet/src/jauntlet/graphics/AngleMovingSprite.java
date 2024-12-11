package jauntlet.graphics;

import jauntlet.Direction;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Tony
 */
public class AngleMovingSprite extends MovingSprite
{
    protected Map<Direction, BufferedImage> images;

    public AngleMovingSprite(BufferedImage right, BufferedImage left, BufferedImage up, BufferedImage down)
    {
        this(right, left, up, down, up, up, right, left);
    }

    public AngleMovingSprite(BufferedImage right, BufferedImage left, BufferedImage up, BufferedImage down,
                             BufferedImage upRight, BufferedImage upLeft, BufferedImage downRight, BufferedImage downLeft)
    {
        images = new HashMap<>();
        images.put(Direction.RIGHT, right);
        images.put(Direction.LEFT, left);
        images.put(Direction.UP, up);
        images.put(Direction.DOWN, down);
        images.put(Direction.UP_RIGHT, upRight);
        images.put(Direction.UP_LEFT, upLeft);
        images.put(Direction.DOWN_RIGHT, downRight);
        images.put(Direction.DOWN_LEFT, downLeft);
        currentImage = right;
    }

    @Override    
    public void setDirection(Direction direction)
    {
        this.direction = direction;
        if (direction == null) return;
        currentImage = images.get(direction);
    }
    
    @Override
    public void persist(BufferedWriter out) throws IOException {} // Not placed on the map for saving

    @Override
    public void completeLoad(String[] options){}
}