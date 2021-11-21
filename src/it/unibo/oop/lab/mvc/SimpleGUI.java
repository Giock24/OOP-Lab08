package it.unibo.oop.lab.mvc;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final String TITLE = "My Frame";

    private final JFrame frame = new JFrame(TITLE);
    private final Controller ctrl = new ControllerImpl();

    /*
     * Once the Controller is done, implement this class in such a way that:
     * 
     * 1) I has a main method that starts the graphical application
     * 
     * 2) In its constructor, sets up the whole view
     * 
     * 3) The graphical interface consists of a JTextField in the upper part of the frame, 
     * a JTextArea in the center and two buttons below it: "Print", and "Show history". 
     * SUGGESTION: Use a JPanel with BorderLayout
     * 
     * 4) By default, if the graphical interface is closed the program must exit
     * (call setDefaultCloseOperation)
     * 
     * 5) The behavior of the program is that, if "Print" is pressed, the
     * controller is asked to show the string contained in the text field on standard output. 
     * If "show history" is pressed instead, the GUI must show all the prints that
     * have been done to this moment in the text area.
     * 
     */

    /**
     * builds a new {@link SimpleGUI}.
     */
    public SimpleGUI() {

        /* panels */
        final JPanel p1 = new JPanel();
        p1.setLayout(new BorderLayout());

        /* component p1 */
        final JTextArea area = new JTextArea();
        p1.add(area, BorderLayout.CENTER);
        area.setEditable(false);

        final JPanel p2 = new JPanel(new GridBagLayout());
        final GridBagConstraints g = new GridBagConstraints();

        g.gridy = 0; // 1-a riga
        g.insets = new Insets(3, 3, 3, 3); // spazio attorno al comp 
        g.fill = GridBagConstraints.HORIZONTAL; // estensione in orizzont 
        p1.add(p2, BorderLayout.EAST);

        final JPanel p3 = new JPanel();
        p3.setLayout(new BorderLayout());
        p1.add(p3, BorderLayout.NORTH);

        /* component p2 */
        final JButton print = new JButton("Print");
        final JButton history = new JButton("Show History");

        p2.add(print, g);
        g.gridy++;
        p2.add(history, g);

        /* component p3 */
        final JTextField insert = new JTextField();

        p3.add(insert);

        /*
         * Handlers
         */
        print.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                final String line = insert.getText();
                ctrl.setString(line);

                final String curString = ctrl.printString();
                area.setText(curString);
                insert.setText("");
            }

        });

        history.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {

                // Clear...
                area.setText("");

                // Reloading...
                final List<String> listString = ctrl.getHistory();
                final int maxRead = listString.size() - 1;
                int count = 0;
                try {
                    while (count <= maxRead) {
                        count++;
                        area.append(" " + ctrl.getNextString() + "\n");
                    }
                } catch (IllegalStateException e1) {
                    e1.printStackTrace();
                }
            }

        });

        /*
         * Make the frame half the resolution of the screen. This very method is
         * enough for a single screen setup. In case of multiple monitors, the
         * primary is selected.
         * 
         * In order to deal coherently with multimonitor setups, other
         * facilities exist (see the Java documentation about this issue). It is
         * MUCH better than manually specify the size of a window in pixel: it
         * takes into account the current resolution.
         */
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / 2, sh / 2);

        /*
         * Instead of appearing at (0,0), upper left corner of the screen, this
         * flag makes the OS window manager take care of the default positioning
         * on screen. Results may vary, but it is generally the best choice.
         */
        frame.setContentPane(p1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(final String... s) {

        new SimpleGUI();

    }

}
