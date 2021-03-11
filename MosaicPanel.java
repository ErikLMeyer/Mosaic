import javax.swing.JPanel;
import java.lang.Math;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MosaicPanel extends JPanel implements MouseListener, MouseMotionListener {
    // Constants. Define number of objects to draw, and the difference in each of
    // the rgb values.
    private final int GRID_SIZE = 12;
    private final int COL_DIF = 50;

    // Member variables
    private Tile tilling[][];
    private int height, width;
    private int rowNum, colNum;
    private ArrayList<Point> toSwap;

    // Fills tilling with a random assortment of Squares and Circles.
    public void tile() {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                int polygon = (int) (Math.random() * 2);
                if (polygon == 0) {
                    tilling[row][col] = new Square();
                } else {
                    tilling[row][col] = new Circle();
                }
            }
        }
    }

    // Determines size and position of Shape objects on screen
    public void setDimensions() {
        width = super.getWidth() / GRID_SIZE;
        height = super.getHeight() / GRID_SIZE;
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                tilling[row][col].setWidth(width);
                tilling[row][col].setHeight(height);
                tilling[row][col].setX(row * width);
                tilling[row][col].setY(col * height);
                tilling[row][col].setCenter();
                tilling[row][col].getFace().setDimensions(width, height);
                tilling[row][col].getFace().setPosition(row * width, col * height);
            }
        }
    }

    // Returns a random capitalized letter.
    public String generateLetters() {
        char letterC = (char) (Math.floor((Math.random() * (0x5a - 0x41 + 1)) + 0x41));
        return Character.toString(letterC);
    }

    // Assigns each Shape a random letter.
    public void setLetters() {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                tilling[row][col].setLetter(generateLetters());
            }
        }
    }

    // Returns a Color with randomized rgb values.
    public Color generateColor() {
        int red = (int) (Math.random() * 256);
        int green = (int) (Math.random() * 256);
        int blue = (int) (Math.random() * 256);

        return new Color(red, green, blue);
    }

    // Returns an int value such that lCol is outside of a range of 50 from sCol.
    public int adjustValue(int sCol, int lCol) {
        int finalVal = lCol;
        if (Math.abs(sCol - lCol) < COL_DIF) {
            if (lCol >= sCol) {
                if (lCol + COL_DIF >= 0xFF) {
                    finalVal = sCol - COL_DIF;
                } else
                    finalVal = lCol + COL_DIF;
            } else {
                if (lCol - COL_DIF <= 0) {
                    finalVal = sCol + COL_DIF;
                } else {
                    finalVal = lCol - COL_DIF;
                }
            }
        }

        return finalVal;
    }

    // Returns a Color whose rgb values are noticeably different from sCol.
    public Color adjustedColor(Color sCol, Color lCol) {
        int red = adjustValue(sCol.getRed(), lCol.getRed());
        int green = adjustValue(sCol.getGreen(), lCol.getGreen());
        int blue = adjustValue(sCol.getBlue(), lCol.getBlue());

        return new Color(red, green, blue);
    }

    // Assigns a randomized Color to each Shape and their letter.
    public void setColors() {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                Color sCol = generateColor();
                Color lCol = generateColor();
                tilling[row][col].setSColor(sCol);
                tilling[row][col].setLColor(adjustedColor(sCol, lCol));
            }
        }
    }

    // Creates a new MosaicPanel
    public MosaicPanel() {
        tilling = new Tile[GRID_SIZE][GRID_SIZE];

        tile();
        setDimensions();
        setLetters();
        setColors();

        addMouseListener(this);
        addMouseMotionListener(this);
        toSwap = new ArrayList<Point>();
    }

    // Rerandomizes the Shapes in tilling.
    public void retile() {
        tile();
        setDimensions();
        setLetters();
        setColors();
    }

    // Paints Shape objects to screen.
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        setDimensions();
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                tilling[row][col].paintShape(g);
            }
        }
    }

    public void swap(int row, int col){
        if (tilling[row][col].getDrawShape()){
            tilling[row][col].setDrawShape(false);
        } else{
            tilling[row][col].setDrawShape(true);
        }
    }
    public void mouseClicked(MouseEvent e) {
        int row = (int) ((e.getX() / (double) super.getWidth()) * GRID_SIZE);
        int col = (int) ((e.getY() / (double) super.getHeight()) * GRID_SIZE);

        swap(row, col);
        repaint();
    }

    public void setRowAndColumn(MouseEvent e){
        rowNum = (int) ((e.getX() / (double) super.getWidth()) * GRID_SIZE);
        colNum = (int) ((e.getY() / (double) super.getHeight()) * GRID_SIZE);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        setRowAndColumn(e);
        toSwap.add(new Point(rowNum, colNum));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int row, col;
        for (int i = 0; i < toSwap.size(); i++){
            row = (int) toSwap.get(i).getX();
            col = (int) toSwap.get(i).getY();

            swap(row, col);
        }
        repaint();
        toSwap.clear();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    

    public boolean inFrame(MouseEvent e){
        if (e.getX() >= 0 && e.getY() >= 0){
            if (e.getX() < super.getWidth() && e.getY() < super.getHeight()){
                return true;
            }
        }
        return false;
    }

    public boolean hasMoved(){
        if (toSwap.size() > 0){
            if (rowNum != (int) toSwap.get(toSwap.size()-1).getX() || 
                colNum != (int) toSwap.get(toSwap.size()-1).getY()){
                return true;
            }
        }

        return false;
    }

    public boolean inToSwap(){
        if (toSwap.size() > 0){
            for (int i = 0; i < toSwap.size(); i++){
                if (rowNum == (int) toSwap.get(i).getX() && colNum == (int) toSwap.get(i).getY()){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        setRowAndColumn(e);

        if (inFrame(e)){
            if (hasMoved()){
                if (!inToSwap())
                    toSwap.add(new Point(rowNum, colNum));
            }
        }
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
}
