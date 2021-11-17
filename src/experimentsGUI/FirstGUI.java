package experimentsGUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;

/*
 *  My Expertiments on GUI
 * 
 */
public class FirstGUI {

    private static final String TITLE = "Titolo del Frame";
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    public static void main(final String... args) {

        // Parte frame
        final JFrame frame = new JFrame();
        frame.setTitle(FirstGUI.TITLE);
        frame.setSize(new Dimension(WIDTH, HEIGHT));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

        // Parte panel con bottoni
        final JPanel p1 = new JPanel();
        frame.setContentPane(p1);

        p1.add(new JButton("Prova Bottone"));

    }

}
