/*************************************************************************
 *  Compilation:  javac Sierpinski.java
 *  Execution:    java Sierpinski
 *
 *  @author: Prithish Balakrishnan
 *
 *************************************************************************/

public class Sierpinski {

    // Height of an equilateral triangle whose sides are of the specified length. 
    public static double height(double length) {
        return Math.sqrt(3)*length*0.5;
	// WRITE YOUR CODE HERE
    }

    // Draws a filled equilateral triangle whose bottom vertex is (x, y) 
    // of the specified side length. 
    public static void filledTriangle(double x, double y, double length) {
        double[] xPos = new double[3];
        double[] yPos = new double[3];
        double topLeftX = x-(length/2);
        double topLeftY = height(length)+y;
        double topRightX = x+(length/2);
        double topRightY = height(length)+y;
        xPos[0] = x;
        yPos[0] = y;
        xPos[1] = topLeftX;
        yPos[1] = topLeftY;
        xPos[2] = topRightX;
        yPos[2] = topRightY;
        StdDraw.filledPolygon(xPos,yPos);
	// WRITE YOUR CODE HERE
    }

    // Draws a Sierpinski triangle of order n, such that the largest filled 
    // triangle has bottom vertex (x, y) and sides of the specified length. 
    public static void sierpinski(int n, double x, double y, double length) {
        if(n==0){
            return;
        }
        filledTriangle(x,y,length);
        sierpinski(n-1,x-length/2,y,length/2);
        sierpinski(n-1,x+length/2,y,length/2);
        sierpinski(n-1,x,height(length)+y,length/2);
	// WRITE YOUR CODE HERE
    }

    // Takes an integer command-line argument n; 
    // draws the outline of an equilateral triangle (pointed upwards) of length 1; 
    // whose bottom-left vertex is (0, 0) and bottom-right vertex is (1, 0); and 
    // draws a Sierpinski triangle of order n that fits snugly inside the outline. 
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double[] x = {0,0.5,1.0};
        double[] y = {0,height(1.0),0.0};
        StdDraw.polygon(x,y);
        sierpinski(n,0.5,0,0.5);

	// WRITE YOUR CODE HERE 
    }
}
