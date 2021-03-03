package face;

import java.awt.Graphics;

public class Oval {
    // Member variables for the size and position of the Oval
    private int widthRadius, heightRadius;
    private int xPosition, yPosition;

    // Sets the width of the Oval to the given int.
    public void setWidth(int w){ widthRadius = w; }

    //Sets the height of the Oval to the given int.
    public void setHeight(int h){ heightRadius = h; }

    // Sets the X coordinate to the given int.
    public void setX(int x){ xPosition = x; }

    // Sets the Y coordinate to the given int.
    public void setY(int y){ yPosition = y; }

    // Returns the width of the Oval.
    public int getWidth(){ return widthRadius; }

    // Returns the height of the Oval.
    public int getHeight(){ return heightRadius; }

    // Returns the X coordinate of the Oval.
    public int getX(){ return xPosition; }

    // Returns the Y coordinate of the Oval.
    public int getY(){ return yPosition; }

    // Default constructor.
    Oval(){
        this(0,0,0,0);
    }

    // Creates a new Oval of given size and position.
    Oval(int width, int height, int x, int y){
        setWidth(width);
        setHeight(height);
        setX(x);
        setY(y);
    }

    // Paints the Oval.
    public void paintOval(Graphics g){
        g.drawOval(xPosition, yPosition, widthRadius, heightRadius);
    }

    // Returns a String representation of the Oval.
    public String toString(){
        return "X = " + xPosition + ", Y = " + yPosition + ", width = " + widthRadius + ", height = " + 
            heightRadius;
    }
}
