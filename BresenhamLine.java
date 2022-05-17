
/**
 * Does a line using Bresenham.  Handles shallow downward lines
 *
 * @author Bill Viggers
 * @version 5-May-22
 * Adjusted 18-May-22 to ensure left-right coordinates and 
 *   handle (shallow) downward lines
 */
public class BresenhamLine
{
    // instance variables - replace the example below with your own
    final boolean VERBOSE=true;

    /**
     * Constructor for objects of class Plot
     */

    public BresenhamLine(){
        Coordinate one=new Coordinate(-2,5);
        Coordinate two=new Coordinate(10,-2);
        BLine(one,two,true);
        
         one=new Coordinate(10, -5);
         two=new Coordinate(-2,-12);
        BLine(one,two,true);
        
        
    }

    public BresenhamLine(boolean plot){
        if (plot){
            Coordinate one=new Coordinate(0,0);
            Coordinate two=new Coordinate(10,7);
            BLine(one,two,true);
        }
    }

    Board myBoard = new Board();

    // we use coordinate.getX() to get the X value of a coordinate and 
    // coordinate.getY() to get the Y value of a coordinate.
    public void BLine(Coordinate start, Coordinate end, boolean plot)
    {

        // First make sure that start is to the left of end
        if (start.getX() > end.getX()) { // swap them
         Coordinate temp = new Coordinate(start);
         start.copy(end);
         end.copy(temp);
        } // Coordinates are now in the right order.
        
        
        // Bresenham parameters as demoed in csfieldguide.
        // Yes the names are ugly names, but that is how they are shown in csfield guide.

        int yStep=1;  // What do we adjust Y by for each move in X?
        int a = (end.getY()-start.getY())*2;             // A is the difference between Y values.  The vertical rise
        // If the line is sloping downward, we reverse yStep and a
        if (start.getY() > end.getY()){ // we are sloping downward
            yStep=-1;
            a=-a;
        } // fix paramters for downward lines
        
        int b = a - 2*(end.getX()-start.getX());         // B is rise minus twice the diffrence in X values (the run)
        int p = a-(end.getX()-start.getX());             // And P we use for working out whether we will go up or not
        
        
        if (VERBOSE) System.out.println("Calculating A as "+a+", B as "+b+"; and p as "+p);
        int y=start.getY();
        for (int x=start.getX();x<=end.getX();x++){
            if (VERBOSE){
                System.out.print("p is now "+p);
                System.out.println("; Plotting at "+x+","+y);
            }
            if (plot) myBoard.plot(new Coordinate(x,y));
            // Do Bresenham maths.  
            // This version only works with lines sloping up to the right at no more than 45 degrees.
            if (p < 0) { //draw on same line
                p+=a;
            } else {  // move up a line
                y+=yStep;
                p+=b;
            } // we moved up a line

        } // for x;
    } // Bresenham Line
}
