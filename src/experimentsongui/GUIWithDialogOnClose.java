package experimentsongui;

import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class GUIWithDialogOnClose implements GUIInterface {

    private static final String TITLE = "Dialog Example";
    private static final int MUL = 2;
    private final MyFrame frame = new MyFrame(TITLE, new FlowLayout());
    private final JPanel panel = frame.getMainPane();

    public GUIWithDialogOnClose() {

        /* frame part */

        final JTextArea text = new JTextArea(1, 10);
        //text.setMaximumSize(1, 10);
        panel.add(text);

        final JLabel res = new JLabel("Result:");
        panel.add(res);

        final JLabel num = new JLabel("0");
        panel.add(num);

        final JButton multiply = new JButton("Multiply by 2");
        panel.add(multiply);

        /* Handlers */

        multiply.addActionListener(e -> {
            final int result = Integer.parseInt(text.getText());
            num.setText(Integer.toString(result * MUL));
            text.setText("");
        });

    }

    /**
     *  {@inheritDoc}
     */
    public void display() {

        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / 2, sh / 2);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        /* Dialogs */
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                final int n = JOptionPane.showConfirmDialog(frame,
                        "Do you really want to quit?",
                        "Quitting", JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

}
