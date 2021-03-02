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
                // System.out.println("polygon = " + polygon)
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

    public boolean colorRange(Color c1, Color c2){
        if (c1.getRed() + COL_DIF <= c2.getRed() || c1.getRed() - COL_DIF >= c2.getRed()){
            if (c1.getGreen() + COL_DIF <= c2.getGreen() || c1.getGreen() - COL_DIF >= c2.getGreen()){
                if (c1.getBlue() + COL_DIF <= c2.getBlue() || c1.getBlue() - COL_DIF >= c2.getBlue()){
                    return true;
                }
            }
        }
        return false;
    }

    public void setColors(){
        for(int row = 0; row < GRID_SIZE; row++){
            for (int col = 0; col < GRID_SIZE; col++){
                tilling[row][col].setSColor(generateColor());
                do {
                    tilling[row][col].setLColor(generateColor());
                } while(colorRange(tilling[row][col].getSColor(), tilling[row][col].getLColor()));
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
