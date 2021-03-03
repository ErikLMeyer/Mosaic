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

    // Returns the height of the head Oval object.
    public int getHeight(){ return head.getHeight(); }

    // Returns the width of the head Oval object.
    public int getWidth(){ return head.getWidth(); }

    // Default constructor
    public Face(){
        this(0, 0, 0, 0);
    }

    // Creates a new Face of a given size in a given position.
    public Face(int x, int y, int width, int height){
        // The main Oval
        head = new Oval(width, height, x, y);

        // Creates the eyes based on the attributes of the head.
        int eyeW, eyeH, eyeX, eyeY;
        eyeH = height / 3;
        eyeW = width / 5;
        eyeX = x + eyeW;
        eyeY = y + (eyeH / 2);
        eyes[0] = new Oval(eyeW, eyeH, eyeX, eyeY);
        eyes[1] = new Oval(eyeW, eyeH, eyeX + (eyeW*2), eyeY);

        // Creates the mouth based on the attributes of the head and eyes.
        int mouthE = (int)(Math.random()*3);
        int mouthX = eyeX;
        int mouthY = y + (height / 2);
        int mouthW = eyeW * 3;
        int mouthH = height / 2;

        // Switch statement determines the state of the mouth.
        switch(mouthE){
            case 0:
                smile = new Smile(mouthX, mouthY, mouthW, mouthH, FROWN[0], FROWN[1]);
                break;
            case 1:
                smile = new Smile(mouthX, mouthY + (eyeH / 2), mouthW, 0, NEUTRAL[0], NEUTRAL[1]);
                break;
            case 2:
                smile = new Smile(mouthX, y + eyeH, mouthW, mouthH, SMILE[0], SMILE[1]);
                break;
            default:
                System.out.println("Learn how to random.");
                break;
        }
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
