
/**
 * Does a line using y=mx+c.
 *
 * @author Bill Viggers
 * @version 5-May-22
 */
public class MathsLine
{
    // instance variables - replace the example below with your own
    final boolean VERBOSE=false;

    /**
     * Constructor for objects of class Plot
     */
    
    public MathsLine(){
        Coordinate one=new Coordinate(0,0);
        Coordinate two=new Coordinate(10,7);
        MLine(one,two,true);
    }
    
    Board myBoard = new Board();
    
    public void MLine(Coordinate one, Coordinate two, boolean plot)
    {

        if (VERBOSE){
        System.out.println("From: "+one.getX()+", "+one.getY()+" to "+two.getX()+","+two.getY());    
        
        }
        
        float m =(float) (two.getY()-one.getY()) / (two.getX()-one.getX());
        float c = (float) (one.getY()*two.getX() - two.getY()*one.getX()) / (two.getX()-one.getX());
        
        
        int y =0;
        if (VERBOSE) System.out.println("Calculating  M is "+m+", C as "+c);
        for (int x=one.getX();x<=two.getX();x++){
             y=Math.round(m*x+c);
            if (VERBOSE){
            System.out.println("; Plotting at "+x+","+y);
        }
            if (plot) myBoard.plot(new Coordinate(x,y));
        } // for x;
    } // MATHS Line
}
