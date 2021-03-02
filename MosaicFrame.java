import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MosaicFrame extends JFrame {
    private MosaicPanel myMosaic;
    private Container mosaicContainer;

    MosaicFrame(){
        setTitle("Mosaic");
        setBounds(100, 100, 840, 840);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myMosaic = new MosaicPanel();

        mosaicContainer = getContentPane();

        mosaicContainer.add(myMosaic);


    }
}
