package face;

import java.awt.Graphics;

public class Smile {
    // Member variables for the size, position, and angle of the Smile.
    private int xPosition, yPosition;
    private int width, height;
    private int startAngle, arcAngle;

    // Returns the X coordinate of the Smile.
    public int getX(){ return xPosition; }

    // Returns the Y coordinate of the Smile.
    public int getY(){ return yPosition; }

    // Returns the width of the Smile.
    public int getWidth(){ return width; }

    // Returns the height of the Smile.
    public int getHeight(){ return height; }

    // Returns the starting angle of the Smile.
    public int getStart(){ return startAngle; }

    // Returns the arc angle of the Smile.
    public int getArc(){ return arcAngle; }

    // Sets the X coordinate of the Smile to the given int.
    public void setX(int x){ xPosition = x; }

    // Sets the Y coordinate of the Smile to the given int.
    public void setY(int y){ yPosition = y; }

    // Sets the width of the Smile to the given int.
    public void setWidth(int w){ width = w; }

    // Sets the height of the Smile to the given int.
    public void setHeight(int h){ height = h; }

    // Sets the starting angle of the Smile to the given int.
    public void setStart(int s){ startAngle = s; }

    // Sets the arc angle of the Smile to the given int.
    public void setArc(int a){ arcAngle = a; }

    // Default constructor.
    Smile(){
        this(0,0,0,0,0,0);
    }

    // Creates a new Smile of given size, position, and angle.
    Smile(int x, int y, int w, int h, int s, int a){
        setX(x);
        setY(y);
        setWidth(w);
        setHeight(h);
        setStart(s);
        setArc(a);
    }

    // Paints the Smile.
    public void paintSmile(Graphics g){
        g.drawArc(xPosition, yPosition, width, height, startAngle, arcAngle);
    }

    // Returns a String representation of the Smile.
    public String toString(){
        return "X = " + xPosition + ", Y = " + yPosition + ", width = " + width + ", height = " + 
            height + ", start angle = " + startAngle + ", arc angle = " + arcAngle;
    }
}
