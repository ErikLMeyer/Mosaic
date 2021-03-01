import java.awt.*;

public class Circle extends Shape {
    public Circle(){
        super();
    }

    public void paintComponent(Graphics g){
        g.setColor(getSColor());
        g.fillOval(getX(), getY(), getWidth(), getHeight());
        g.setColor(getLColor());
        g.drawString(getLetter(), getCenterX(), getCenterY());
    }
}
