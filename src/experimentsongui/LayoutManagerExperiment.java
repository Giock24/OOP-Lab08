package experimentsongui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LayoutManagerExperiment implements GUIInterface {

    private static final String TITLE = "Prove Layout";
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    //private static final int LARGE = 15;
    private final JFrame frame = new JFrame();

    public LayoutManagerExperiment() {

        // Parte frame
        frame.setTitle(LayoutManagerExperiment.TITLE);
        frame.setSize(new Dimension(WIDTH, HEIGHT));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Parte panel con bottoni e componenti
        final JPanel p1 = new JPanel(new BorderLayout());
        //p1.setLayout(null); // Nessun Layout
        frame.setContentPane(p1);

        //final JButton b1 = new JButton("Prova Bottone");

        //imposto dimensione e posizione
        /*
        Dimension size = b1.getPreferredSize(); // otteniamo le dimensioni preferite del bottone
        b1.setBounds(30, 60, size.width, size.height);
        p1.add(b1);
        */
        p1.add(new JButton("NORTH"), BorderLayout.NORTH);
        p1.add(new JButton("SOUTH"), BorderLayout.SOUTH);
        p1.add(new JButton("CENTER"), BorderLayout.CENTER);
        p1.add(new JButton("EAST"), BorderLayout.EAST);
        p1.add(new JButton("WEST"), BorderLayout.WEST);

    }

    /**
     *  {@inheritDoc}
     */
    public void display() {

        frame.setVisible(true);

    }

}
