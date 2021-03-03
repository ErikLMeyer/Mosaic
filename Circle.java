import java.awt.*;

public class Circle extends Shape {
    // Constructors. All of them work as described in Shape
    public Circle(){
        super();
    }

    public Circle(int w, int h, int x, int y, String l, Color s, Color lC){
        super(w, h, x, y, l, s, lC);
    }

    public Circle(int w, int h, int x, int y, String l, int sR, int sG, int sB, int lR, int lG, 
                    int lB){
        super(w, h, x, y, l, sR, sG, sB, lR, lG, lB);
    }

    // Paints a Circle to the screen
    public void paintShape(Graphics g){
        g.setColor(shapeColor);
        g.fillOval(xPosition, yPosition, width, height);
        g.setColor(letterColor);
        g.drawString(letter, centerX, centerY);
    }
}
