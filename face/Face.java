package face;

import java.awt.*;
import java.lang.Math;

public class Face {
    // Constants, holds mouth angles
    static final int FROWN[] = {0, 180};
    static final int NEUTRAL[] = {0, 180};
    static final int SMILE[] = {0, -180};

    // member variables
    private Oval head;
    private Oval eyes[] = new Oval[2];
    private Smile smile;
    private int mouthE;

    // Returns the height of the head Oval object.
    public int getHeight(){ return head.getHeight(); }

    // Returns the width of the head Oval object.
    public int getWidth(){ return head.getWidth(); }

    public void setDimensions(int w, int h){
        int eyeW = w / 5;
        int eyeH = h / 3;

        head.setWidth(w);
        eyes[0].setWidth(eyeW);
        eyes[1].setWidth(eyeW);
        smile.setWidth(eyeW * 3);

        head.setHeight(h);
        eyes[0].setHeight(eyeH);
        eyes[1].setHeight(eyeH);
        if (mouthE != 1)
            smile.setHeight(h / 2);
    }

    public void setPosition(int x, int y){
        int eyeX = x + eyes[0].getWidth();
        int eyeY = y + (eyes[0].getHeight() / 2);
        int mouthY = y + (head.getHeight() / 2);
        head.setX(x);
        eyes[0].setX(eyeX);
        eyes[1].setX(eyeX + (eyes[1].getWidth() * 2));
        smile.setX(eyeX);

        head.setY(y);
        eyes[0].setY(eyeY);
        eyes[1].setY(eyeY);
        switch (mouthE){
            case 0:
                smile.setY(mouthY);
                break;
            case 1:
                smile.setY(mouthY + (eyes[0].getHeight() / 2));
                break;
            case 2:
                smile.setY(y + eyes[0].getHeight());
                break;
            default:
                assert false: "You should not be here.";
                break;
        }
    }

    public void setAngle(int mouthConstant){
        switch (mouthConstant){
            case 0:
                smile.setStart(FROWN[0]);
                smile.setArc(FROWN[1]);
                break;
            case 1:
                smile.setStart(NEUTRAL[0]);
                smile.setArc(NEUTRAL[1]);
                break;
            case 2:
                smile.setStart(SMILE[0]);
                smile.setArc(SMILE[1]);
                break;
            default:
                assert false: "Invalid value passed.";
                break;
        }
    }

    // Default constructor
    public Face(){
        this(0, 0, 0, 0);
    }

    // Creates a new Face of a given size in a given position.
    public Face(int x, int y, int width, int height){
        // The main Oval
        head = new Oval();
        eyes[0] = new Oval();
        eyes[1] = new Oval();
        smile = new Smile();

        setDimensions(width, height);
        setPosition(x, y);
        mouthE = (int)(Math.random()*3);
        setAngle(mouthE);
    }

    // Paints the objects of the Face.
    public void paintFace(Graphics g){
        head.paintOval(g);
        eyes[0].paintOval(g);
        eyes[1].paintOval(g);
        smile.paintSmile(g);
    }

    // Returns a String representation of the Face.
    public String toString(){
        return "Head: " + head + "\nLeft eye: " + eyes[0] + "\nRight eye: " + eyes[1] + "\nMouth: "
            + smile;
    }
}
