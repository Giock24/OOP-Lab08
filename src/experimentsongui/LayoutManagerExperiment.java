package experimentsongui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;

public class LayoutManagerExperiment implements GUIInterface {

    private static final String TITLE = "Prove Layout";
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    //private static final int LARGE = 15;
    private final MyFrame frame = new MyFrame(TITLE, new BorderLayout());

    public LayoutManagerExperiment() {

        // Parte frame
        frame.setSize(new Dimension(WIDTH, HEIGHT));

        // Parte panel con bottoni e componenti
        //final JPanel p1 = new JPanel(new BorderLayout());
        //p1.setLayout(null); // Nessun Layout
        //frame.setContentPane(p1);

        frame.getMainPane().add(new JButton("NORTH"), BorderLayout.NORTH);
        frame.getMainPane().add(new JButton("SOUTH"), BorderLayout.SOUTH);
        frame.getMainPane().add(new JButton("CENTER"), BorderLayout.CENTER);
        frame.getMainPane().add(new JButton("EAST"), BorderLayout.EAST);
        frame.getMainPane().add(new JButton("WEST"), BorderLayout.WEST);

    }

    /**
     *  {@inheritDoc}
     */
    public void display() {

        frame.setVisible(true);

    }

}
