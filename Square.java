import java.awt.*;

public class Square extends Shape {
    Square(){
        super();
    }

    public Square(int w, int h, int x, int y, String l, Color s, Color lC){
        super(w, h, x, y, l, s, lC);
    }

    public Square(int w, int h, int x, int y, String l, int sR, int sG, int sB, int lR, int lG, 
                    int lB){
        super(w, h, x, y, l, sR, sG, sB, lR, lG, lB);
    }

    public void paintShape(Graphics g){
        g.setColor(shapeColor);
        g.fillRect(xPosition, yPosition, width, height);
        g.setColor(letterColor);
        g.drawString(letter, centerX, centerY);
    }
}
