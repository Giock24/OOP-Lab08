package it.unibo.oop.lab.mvcio;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final String TITLE = "MY NOTEPAD :)";
    private final JFrame frame = new JFrame(TITLE);
    private final Controller c = new Controller();

    /*
     * Once the Controller is done, implement this class in such a way that:
     * 
     * 1) It has a main method that starts the graphical application
     * 
     * 2) In its constructor, sets up the whole view
     * 
     * 3) The graphical interface consists of a JTextArea with a button "Save" right
     * below (see "ex02.png" for the expected result). SUGGESTION: Use a JPanel with
     * BorderLayout
     * 
     * 4) By default, if the graphical interface is closed the program must exit
     * (call setDefaultCloseOperation)
     * 
     * 5) The program asks the controller to save the file if the button "Save" gets
     * pressed.
     * 
     * Use "ex02.png" (in the res directory) to verify the expected aspect.
     */

    /**
     * builds a new {@link SimpleGUI}.
     */
    public SimpleGUI() {
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(new TitledBorder("Prova"));

        /* Buttons */
        final JTextArea area = new JTextArea();
        panel.add(area, BorderLayout.CENTER);
        //area.setLineWrap(true);
        this.showVerticalBar(area, panel);

        /* new panel2 with FlowsLayout */
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panel2.setBorder(new TitledBorder("FlowLayout"));
        panel.add(panel2, BorderLayout.SOUTH);

        /* Buttons for panel2 */
        final JButton load = new JButton("Load");
        panel2.add(load);

        final JButton saveB = new JButton("Save");
        panel2.add(saveB);

        c.loadFile(area);

        /*
         * Handlers
         */
        saveB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (area.getText() != null) {
                    //creiamo il controller, otteniemo il testo e boom il gioco è fatto
                    //c.setFile("newf");

                    c.writeOnFile(area.getText());
                    //System.out.println(c.getPATH());
                    //System.out.println(c.getFile());
                }
            }

        });

        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                //Pulisco ...
                area.setText("");

                // e Ricarico
                c.loadFile(area);
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
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
    
    public void showVerticalBar(JTextArea area, JPanel panel) {
    	final JScrollPane scroll = new JScrollPane(area);
    	scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
    	panel.add(scroll);
    	
    	final JScrollPane scroll2 = new JScrollPane(area);
    	scroll2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    	panel.add(scroll2);
    }

    public static void main(final String... s) {

        new SimpleGUI();

    }

}
