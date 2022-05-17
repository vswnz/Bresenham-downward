
/**
 * Draw a pair of axis on the screen.  Then use it to draw a board.

 *
 * @author Bill
 * @version Jul 9th 2020
 * Updated May 4th 2022 to allow plotting of squares.
 * Modified May 18th 2022  to draw two axis for Bresenham 0 column/row
 * 
 */

// Libraries for GUI
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;  // geometry stuff for lines

public class Board extends JFrame {
    //    final String imageFile = "mole100.png";// Feel free to use a water pipe image if you have one.

    final int wSize=1000;  // How big is the window?
    final int IMAGESIZE=100;  // how big is our plot size in total (includes + and - values).
    final int CENTER=IMAGESIZE/2; // middle of image, or the x/y origin.
    final int SQUARE=wSize/IMAGESIZE; // how big is each square.
    boolean grid[][] = new boolean[IMAGESIZE][IMAGESIZE];  // what we plot.

    //Variables for what we want to display
    boolean displayAxis=true;

    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        if (displayAxis){ // Show the axis if we want to.
            //Line2D - xstart,ystart,xend,yend
            //X axis
            Line2D lin = new Line2D.Float(10, wSize/2, wSize-10, wSize/2);
            g2.draw(lin);
            // Add 2nd X axis for Bresenham 0 row
            lin = new Line2D.Float(10, wSize/2-SQUARE, wSize-10, wSize/2-SQUARE);
            g2.draw(lin);

            //Y axis; Starts 50 points further down due to title bar.
            lin = new Line2D.Float(wSize/2, 60, wSize/2, wSize-10);
            g2.draw(lin);
            // add 2nd Y axis for Bresehman 0 column
            lin = new Line2D.Float(wSize/2+SQUARE, 60, wSize/2+SQUARE, wSize-10);
            g2.draw(lin);

        } // Display the axis
        //Display any squares we want plotted.
        for (int x=0;x<IMAGESIZE;x++)
            for (int y=0; y<IMAGESIZE;y++){
                if (grid[x][y]){
                    g.setColor(Color.BLACK);
                    g.fillRect(x*SQUARE,wSize-((y+1)*SQUARE),SQUARE,SQUARE);
                    //Uncomment next line for debugging.
                    //System.out.println("Square at: "+x+","+y);
                } // if point should be plotted.
            } // for y
    } //paint

    // Set the appropriate cooridate
    public void plot(Coordinate c){
        // We offset by CENTER as the coordinates can be negative.
        // Ideally we would do error checking here to make sure nobody has provided 
        // coordiates that are too negative or too high.
        grid[c.getX()+CENTER][c.getY()+CENTER]=true;
        repaint();

    }

    // Unset the appropriate cooridate
    public void unPlot(Coordinate c){
        // See comments for plot.
        grid[c.getX()+CENTER][c.getY()+CENTER]=false;
        repaint();
    }

    // This method sets up the basic frame we will use.
    public Board(){
        setTitle("Bresenham");  //Whateveryou want the window to be called.

        this.getContentPane().setPreferredSize(new Dimension(wSize,wSize));  
        this.getContentPane().setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.pack();
        this.setVisible(true);

    }
}
