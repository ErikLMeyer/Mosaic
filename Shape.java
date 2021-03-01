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
}
