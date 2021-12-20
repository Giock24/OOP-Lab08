package experimentsongui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

        final MyDrawPanel dPanel = new MyDrawPanel();
        dPanel.setLayout(new BorderLayout());

        panel.add(panel2, BorderLayout.EAST);
        panel.add(dPanel, BorderLayout.CENTER);

        /* component of panel2 */
        panel2.setBorder(new TitledBorder("Yo"));

        final JButton draw = new JButton("Draw");

        panel2.add(draw, BorderLayout.NORTH);

        /* component of panel3 */
        dPanel.setBorder(new TitledBorder("Circle here.."));

        /* Handlers */
        dPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent e) {
                dPanel.addPoint(e.getX(), e.getY());
                dPanel.repaint();
            }
        });

        draw.addActionListener(e -> {
            dPanel.addRandomPoint();
            dPanel.repaint();
        });

    }

    /**
     *  {@inheritDoc}
     */
    public void display() {
        frame.setVisible(true);
        frame.setResizable(false);
    }

}
