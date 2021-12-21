package experimentsongui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUIWithDifComp implements GUIInterface {

    private static final String TITLE = "GUI con tanti Componets";
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private static final int LARGE = 15;
    private final JFrame frame = new JFrame();

    public GUIWithDifComp() {

        final String[] strings;
        strings = new String[] {"1", "2", "3", "4"};

        // Parte frame
        frame.setTitle(GUIWithDifComp.TITLE);
        frame.setSize(new Dimension(WIDTH, HEIGHT));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Parte panel con bottoni e componenti
        final JPanel p1 = new JPanel();
        frame.setContentPane(p1);

        p1.add(new JButton("Prova Bottone"));
        p1.add(new JTextField("Questo è un JTextField", LARGE));
        p1.add(new JList<String>(strings)); // Creazione lista selettiva
        p1.add(new JComboBox<String>(strings)); // selezione stringa a tendina
        p1.add(new JTextArea(LARGE, LARGE)); // note file .txt (editor di testo)

    }

    /**
     *  {@inheritDoc}
     */
    public void display() {

        frame.setVisible(true);

    }

}
