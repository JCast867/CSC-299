package jauntlet.map;

import jauntlet.Direction;

/**
 *
 * @author Tony
 */
public class Location 
{
    public int x;
    public int y;

    public Location(int x, int y) 
    {
        this.x = x;
        this.y = y;
    }

    public Location() {}

    @Override
    public Location clone()
    {
        return new Location(x, y);
    }
    
    public Location bump(Direction direction) 
    {
        switch (direction)
        {
            case UP:        this.y--; break;
            case DOWN:       this.y++; break;
            case LEFT:       this.x--; break;
            case RIGHT:      this.x++; break;
            case UP_LEFT:    this.y--; this.x--; break;
            case UP_RIGHT:   this.y--; this.x++; break;
            case DOWN_LEFT:  this.y++; this.x--; break;
            case DOWN_RIGHT: this.y++; this.x++; break;
        }
        return this;
    }

    @Override
    public String toString() {
        return x + "," + y;
    }
    
    
}