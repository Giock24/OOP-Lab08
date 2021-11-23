package experimentsongui;

import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * This class set a personal JFrame, with JPanel and setting Layout. 
 */
public class MyFrame extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private final JPanel jp;

    /**
     * 
     * @param nameFrame
     *      JFrame's TITLE
     * @param lay
     *      Layout to set on new JPanel
     */
    public MyFrame(final String nameFrame, final LayoutManager lay) {
        super(nameFrame);
        this.jp = new JPanel(lay);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(this.jp);
    }

    /**
     * 
     * @return new JPanel
     */
    public JPanel getMainPane() {
        return this.jp;
    }

}
