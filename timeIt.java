
/**
 * Write a description of class timeIt here.
 *
 * @author Bill Viggers
 * @version 11-May-2022
 */

public class timeIt
{
    
    
final int COUNT=1000000000; // how many times we do the test.

    public timeIt()
    {
        // initialise instance variables
        BresenhamLine b=new BresenhamLine(false);      // make the Bresenham object
        Coordinate one=new Coordinate (0,0);
        Coordinate two=new Coordinate (10,7);
        long startTime=System.currentTimeMillis(); // remember when we start in milliseconds
        for (int i=0;i<COUNT;i++)               // we'll do a lot of them
            b.BLine(one,two, false);
        long endTime=System.currentTimeMillis(); // remember when we start in milliseconds
        System.out.println("Using Bresenham it took "+(endTime-startTime)+" milliseconds to calculate "+COUNT+" short lines");
        
        MathsLine m=new MathsLine();
        startTime=System.currentTimeMillis(); // remember when we start in milliseconds
        for (int i=0;i<COUNT;i++)               // we'll do a lot of them
            m.MLine(one,two, false);
        endTime=System.currentTimeMillis(); // remember when we start in milliseconds
        System.out.println("Using mathgs it took "+(endTime-startTime)+" milliseconds to calculate "+COUNT+" short lines");
        
        
        
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
 
}
