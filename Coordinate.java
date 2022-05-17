
/**
 * Coordinate class.
 * This lets us deal with 2D Cartesian coordinates
 *
 * @author Bill
 * @version Jul 9 2020
 * Updated 18-May-2022 to add a copy method.
 */
public class Coordinate
{
    private int x; // X value of the coordinate
    private int y; // Y value of the coordinate

    /**
     *  create a blank coordinate at the origin
     */
    public Coordinate() 
    {
        this.x=0;
        this.y=0;
    }

    /**
     *   create a specific coordinate
     */
    public Coordinate(int x, int y) 
    {
        // initialise instance variables
        this.x=x;
        this.y=y;
    }
    
    /**
     *   create a copy of a specific coordinate
     */
    public Coordinate(Coordinate c) 
    {
        // initialise instance variables
        this.x=c.getX();
        this.y=c.getY();
    }

    /**
     * Set a particular value for X
     */
    public void setX(int x) {this.x=x;}  

    /**
     * Set a particular value for Y
     */
    public void setY(int y) {this.y=y;}  

    /**
     * Return X value
     */
    public int getX(){return this.x;}  

    /**
     * Return Y value
     */
    public int getY() {return this.y;}  
    
    /**
     * Copy another coordinate
     */
    public void copy(Coordinate from){
        this.x = from.getX();
        this.y = from.getY();
    }

}
