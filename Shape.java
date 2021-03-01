import java.awt.*;

abstract class Shape {
    private int width, height;
    private int xPosition, yPosition;
    private String letter;
    private Color shapeColor, letterColor;

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
}
