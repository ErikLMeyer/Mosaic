import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MosaicFrame extends JFrame {
    private MosaicPanel myMosaic;
    private JButton randomize;
    private Container mosaicContainer;

    MosaicFrame(){
        setTitle("Mosaic");
        setLayout(new BorderLayout());
        setBounds(0, 0, 840, 840);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myMosaic = new MosaicPanel();
        randomize = new JButton("Randomize");

        mosaicContainer = getContentPane();

        mosaicContainer.add(myMosaic);
        mosaicContainer.add(randomize, BorderLayout.SOUTH);


    }
}
