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

    public int adjustValue(int sCol, int lCol){
        int finalVal = lCol;
        if (Math.abs(sCol - lCol) < COL_DIF){
            if (lCol >= sCol){
                if (lCol + COL_DIF >= 0xFF){
                    finalVal = sCol - COL_DIF;
                } else
                    finalVal = lCol + COL_DIF;
            } else{
                if (lCol - COL_DIF <= 0){
                    finalVal = sCol + COL_DIF;
                } else{
                    finalVal = lCol - COL_DIF;
                }
            }
        }

        return finalVal;
    }

    public Color adjustedColor(Color sCol, Color lCol){
        int red = adjustValue(sCol.getRed(), lCol.getRed());
        int green = adjustValue(sCol.getGreen(), lCol.getGreen());
        int blue = adjustValue(sCol.getBlue(), lCol.getBlue());

        return new Color(red, green, blue);
    }

    public void setColors(){
        for(int row = 0; row < GRID_SIZE; row++){
            for (int col = 0; col < GRID_SIZE; col++){
                Color sCol = generateColor();
                Color lCol = generateColor();
                tilling[row][col].setSColor(sCol);
                tilling[row][col].setLColor(adjustedColor(sCol, lCol));
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
