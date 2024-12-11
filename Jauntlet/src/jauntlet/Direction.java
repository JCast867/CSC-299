package jauntlet;

/**
 *
 * @author Tony
 */
public enum Direction
{
    UP(1), UP_RIGHT(21), RIGHT(20), DOWN_RIGHT(22), DOWN(2), DOWN_LEFT(12), LEFT(10), UP_LEFT(11);

    private int value;
    Direction(int value) {this.value = value;}
    public int getValue() {return value;}
    public static Direction valueOf(int x)
    {
        for (Direction d : values())
        {
            if (d.value == x)
            {
                return d;
            }
        }
        return null;
    }

    public Direction next() 
    {
        Direction[] directions = this.getClass().getEnumConstants();
        return this.ordinal() != directions.length - 1 ? directions[this.ordinal() + 1] : directions[0];
    }

    public Direction previous() 
    {
        Direction[] directions = this.getClass().getEnumConstants();
        return this.ordinal() != 0 ? directions[this.ordinal() - 1] : directions[directions.length - 1];
    }
}
