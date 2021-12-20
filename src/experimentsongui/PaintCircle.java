package experimentsongui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PaintCircle implements GUIInterface {

    private static final String TITLE = "GUI With Circles ;)";
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private final MyFrame frame = new MyFrame(TITLE, new BorderLayout());
    private final JPanel panel = frame.getMainPane();

    public PaintCircle() {

        //frame part
        frame.setSize(new Dimension(WIDTH, HEIGHT));

        /* component of main panel */
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());

        final JPanel panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());

        panel.add(panel2, BorderLayout.EAST);
        panel.add(panel3, BorderLayout.CENTER);

        /* component of panel2 */
        panel2.setBorder(new TitledBorder("Yo"));

        final JButton draw = new JButton("Draw");

        panel2.add(draw, BorderLayout.NORTH);

        /* component of panel3 */
        panel3.setBorder(new TitledBorder("Circle here.."));

        /* Handlers */

    }

    /**
     *  {@inheritDoc}
     */
    public void display() {
        frame.setVisible(true);
    }

}
