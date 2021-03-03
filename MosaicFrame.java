import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MosaicFrame extends JFrame implements ActionListener {
    private MosaicPanel myMosaic;
    private JButton randomize;
    private Container mosaicContainer;

    MosaicFrame(){
        setTitle("Mosaic");
        setLayout(new BorderLayout());
        setBounds(0, 0, 792, 792);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myMosaic = new MosaicPanel();
        randomize = new JButton("Randomize");
        randomize.addActionListener(this);

        mosaicContainer = getContentPane();

        mosaicContainer.add(myMosaic);
        mosaicContainer.add(randomize, BorderLayout.SOUTH);


    }

    public void actionPerformed(ActionEvent e){
        myMosaic.retile();
        update(this.getGraphics());
    }
}
