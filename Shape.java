import java.awt.*;

abstract class Shape {
    private int width, height;
    private int xPosition, yPosition;
    private String letter;
    private Color shapeColor, letterColor;

    // Implement later
    // private Face face;

    public final int getWidth(){ return width; }

    public final int getHeight(){ return height; }

    public final int getX(){ return xPosition; }

    public final int getY(){ return yPosition; }

    public final String getLetter(){ return letter; }

    public final Color getSColor(){ return shapeColor; }

    public final Color getLColor(){ return letterColor; }

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


    public Shape(){
        this(0, 0, 0, 0, "", 0, 0, 0, 0, 0, 0);
    }
    
    public Shape(int w, int h, int x, int y, String l, Color s, Color lC){
        setWidth(w);
        setHeight(h);
        setX(x);
        setY(y);
        setLetter(l);
        setSColor(s);
        setLColor(lC);
    }

    public Shape(int w, int h, int x, int y, String l, int sR, int sG, int sB, int lR, int lG, 
                int lB){
        setWidth(w);
        setHeight(h);
        setX(x);
        setY(y);
        setLetter(l);
        setSColor(sR, sG, sB);
        setLColor(lR, lG, lB);
    }
}
