import javax.swing.JPanel;
import java.lang.Math;
import java.awt.*;

public class MosaicPanel extends JPanel{
    private final int GRID_SIZE = 12;
    private final int COL_DIF = 50;
    private Shape tilling[][];
    private int height, width;

    public void tile(){
        for(int row = 0; row < GRID_SIZE; row++){
            for (int col = 0; col < GRID_SIZE; col++){
                int polygon = (int)(Math.random() * 2);
                if (polygon == 0){
                    tilling[row][col] = new Square();
                } else{
                    tilling[row][col] = new Circle();
                }
            }
        }
    }

    public void setDimensions(){
        width = super.getWidth() / GRID_SIZE;
        height = super.getHeight() / GRID_SIZE;
        for(int row = 0; row < GRID_SIZE; row++){
            for (int col = 0; col < GRID_SIZE; col++){
                tilling[row][col].setWidth(width);
                tilling[row][col].setHeight(height);
                tilling[row][col].setX(row * width);
                tilling[row][col].setY(col * height);
                tilling[row][col].setCenter();
            }
        }
    }

    public String generateLetters(){
        char letterC = (char)(Math.floor((Math.random() * (0x5a - 0x41 + 1)) + 0x41));
        return Character.toString(letterC);
    }

    public void setLetters(){
        for (int row = 0; row < GRID_SIZE; row++){
            for (int col = 0; col < GRID_SIZE; col++){
                tilling[row][col].setLetter(generateLetters());
            }
        }
    }

    public Color generateColor(){
        int red = (int)(Math.random() * 256);
        int green = (int)(Math.random() * 256);
        int blue = (int)(Math.random() * 256);

        return new Color(red, green, blue);
    }

    public Color adjustedColor(Color c){
        Color potColor = generateColor();
        int red = potColor.getRed();
        int green = potColor.getGreen();
        int blue = potColor.getBlue();

        /*
            This big ol' block of if statements determines if each color component is within a value
            of 50 of the passed in color's component. If it is the component is adjusted to be 
            outside that range.
        */
        if (Math.abs(c.getRed() - potColor.getRed()) < COL_DIF){
            if (potColor.getRed() >= c.getRed()){
                if (potColor.getRed() + COL_DIF >= 0xFF){
                    red = c.getRed() - COL_DIF;
                } else
                    red = potColor.getRed() + COL_DIF;
            } else{
                if (potColor.getRed() - COL_DIF < 0){
                    red = c.getRed() + COL_DIF;
                } else{
                    red = potColor.getRed() - COL_DIF;
                }
            }
        }
        if (Math.abs(c.getGreen() - potColor.getGreen()) < COL_DIF){
            if (potColor.getGreen() >= c.getGreen()){
                if (potColor.getGreen() + COL_DIF >= 0xFF){
                    green = c.getGreen() - COL_DIF;
                } else
                    green = potColor.getGreen() + COL_DIF;
            } else{
                if (potColor.getGreen() - COL_DIF < 0){
                    green = c.getGreen() + COL_DIF;
                } else{
                    green = potColor.getGreen() - COL_DIF;
                }
            }
        }
        if (Math.abs(c.getBlue() - potColor.getBlue()) < COL_DIF){
            if (potColor.getBlue() >= c.getBlue()){
                if (potColor.getBlue() + COL_DIF >= 0xFF){
                    blue = c.getBlue() - COL_DIF;
                } else
                    blue = potColor.getBlue() + COL_DIF;
            } else{
                if (potColor.getBlue() - COL_DIF < 0){
                    blue = c.getBlue() + COL_DIF;
                } else{
                    blue = potColor.getBlue() - COL_DIF;
                }
            }
        }

        return new Color(red, green, blue);
    }

    public void setColors(){
        for(int row = 0; row < GRID_SIZE; row++){
            for (int col = 0; col < GRID_SIZE; col++){
                tilling[row][col].setSColor(generateColor());
                tilling[row][col].setLColor(adjustedColor(tilling[row][col].getSColor()));
            }
        }
    }

    public MosaicPanel(){
        tilling = new Shape[GRID_SIZE][GRID_SIZE];

        tile();
        setDimensions();
        setLetters();
        setColors();
    }

    public void retile(){
        tile();
        setDimensions();
        setLetters();
        setColors();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        setDimensions();
        for (int row = 0; row < GRID_SIZE; row++){
            for (int col = 0; col < GRID_SIZE; col++){
                tilling[row][col].paintShape(g);
            }
        }
    }
}
