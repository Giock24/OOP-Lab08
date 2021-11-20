package it.unibo.oop.lab.mvcio2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final String TITLE = "My Second Java graphical interface";
    private final JFrame frame = new JFrame(TITLE);
    private final Controller c = new Controller();

    /*
     * TODO: Starting from the application in mvcio:
     * 
     * 1) Add a JTextField and a button "Browse..." on the upper part of the
     * graphical interface.
     * Suggestion: use a second JPanel with a second BorderLayout, put the panel
     * in the North of the main panel, put the text field in the center of the
     * new panel and put the button in the line_end of the new panel.
     * 
     * 2) The JTextField should be non modifiable. And, should display the
     * current selected file.
     * 
     * 3) On press, the button should open a JFileChooser. The program should
     * use the method showSaveDialog() to display the file chooser, and if the
     * result is equal to JFileChooser.APPROVE_OPTION the program should set as
     * new file in the Controller the file chosen. If CANCEL_OPTION is returned,
     * then the program should do nothing. Otherwise, a message dialog should be
     * shown telling the user that an error has occurred (use
     * JOptionPane.showMessageDialog()).
     * 
     * 4) When in the controller a new File is set, also the graphical interface
     * must reflect such change. Suggestion: do not force the controller to
     * update the UI: in this example the UI knows when should be updated, so
     * try to keep things separated.
     */

    /**
     * builds a new {@link SimpleGUIWithFileChooser}.
     */
    public SimpleGUIWithFileChooser() {

        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        //Setting panel on JFrame
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Buttons panel*/
        final JButton saveB = new JButton("Save");
        panel.add(saveB, BorderLayout.SOUTH);

        final JTextArea area = new JTextArea();
        panel.add(area, BorderLayout.CENTER);
        area.setLineWrap(true);

        /* new panel2 inside panel */
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());

        panel.add(panel2, BorderLayout.NORTH);

        /* Buttons panel2 */
        final JButton browse = new JButton("Browse...");
        panel2.add(browse, BorderLayout.LINE_END);

        final JTextField choisingPath = new JTextField(c.getPATH());
        choisingPath.setEditable(false);
        panel2.add(choisingPath);


        /*
         * Handlers
         */
        saveB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (area.getText() != null) {
                    //creiamo il controller, otteniemo il testo e boom il gioco è fatto
                    //final Controller c1 = new Controller();
                    //c.setFile("newf");

                    c.writeOnFile(area.getText());
                    System.out.println(c.getPATH());
                    System.out.println(c.getFile());
                }
            }

        });

        browse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {

                //final JButton apply = new JButton();
                final JFileChooser chooser = new JFileChooser(c.getFile());
                //chooser.showDialog(apply, "Apply");

                final FileNameExtensionFilter filter = new FileNameExtensionFilter(
                       "File .txt", "txt");
                chooser.setFileFilter(filter);

                final int returnVal = chooser.showSaveDialog(frame);
                switch (returnVal) {
                    case JFileChooser.APPROVE_OPTION :
                        System.out.println("You chose to open this file: " 
                    + chooser.getSelectedFile().getName());

                        // setting the new File on Controller
                        c.setFile(chooser.getSelectedFile());

                        // setting the new Path on View
                        choisingPath.setText(chooser.getSelectedFile().getAbsolutePath());
                        break;
                    case JFileChooser.CANCEL_OPTION :
                        break;
                    default :
                        JOptionPane.showMessageDialog(frame, returnVal, "MA CHE FAI AO!", JOptionPane.ERROR_MESSAGE);
                        break;
                } 
            }

        });

    }

    void display() {
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

        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(final String... s) {

        new SimpleGUIWithFileChooser().display();

    }

}
