import java.awt.*;

abstract class Shape {
    // Member variables
    protected int width, height;
    protected int xPosition, yPosition;
    protected int centerX, centerY;
    protected String letter;
    protected Color shapeColor, letterColor;

    // Implement later
    // protected Face face;

    // Getter methods
    public final int getWidth(){ return width; }

    public final int getHeight(){ return height; }

    public final int getX(){ return xPosition; }

    public final int getY(){ return yPosition; }

    public final int getCenterX(){ return centerX; }

    public final int getCenterY(){ return centerY; }

    public final String getLetter(){ return letter; }

    public final Color getSColor(){ return shapeColor; }

    public final Color getLColor(){ return letterColor; }

    // Setter methods
    public final void setWidth(int w){ width = w; }

    public final void setHeight(int h){ height = h; }

    public final void setX(int x){ xPosition = x; }

    public final void setY(int y){ yPosition = y; }

    // Should only be a single character.
    public final void setLetter(String l){ letter = l; }

    public final void setSColor (Color s){shapeColor = s; }

    public final void setSColor(int r, int g, int b){ shapeColor = new Color(r, g, b); }

    public final void setLColor (Color l){letterColor = l; }

    public final void setLColor(int r, int g, int b){ letterColor = new Color(r, g, b); }

    public final void setCenter(){
        centerX = xPosition + (width / 2);
        centerY = yPosition + (height / 2);
    }

    // Default constructor
    public Shape(){
        this(0, 0, 0, 0, "", 0, 0, 0, 0, 0, 0);
    }

    // Creates new Shape with Color objects for the colors
    public Shape(int w, int h, int x, int y, String l, Color s, Color lC){
        setWidth(w);
        setHeight(h);
        setX(x);
        setY(y);
        setLetter(l);
        setSColor(s);
        setLColor(lC);
        setCenter();
    }

    // Creates new Shape with individual rgb values for the colors
    public Shape(int w, int h, int x, int y, String l, int sR, int sG, int sB, int lR, int lG, 
                int lB){
        setWidth(w);
        setHeight(h);
        setX(x);
        setY(y);
        setLetter(l);
        setSColor(sR, sG, sB);
        setLColor(lR, lG, lB);
        setCenter();
    }

    // Abstract method for how to draw the Shape
    public abstract void paintShape(Graphics g);

    // Returns String representation of this Shape
    public String toString(){
        return "Width: " + width + "; Height: " + height + "; x,y: (" + xPosition + "," + yPosition
         + "); center(x,y): (" + centerX + "," + centerY + "); Letter: " + letter + 
         "; Shape Color: " + shapeColor + "; Letter Color: " + letterColor;
    }

    // Implement later
    // public void paintFace(){}
}
