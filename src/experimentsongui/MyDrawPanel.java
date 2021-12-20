package experimentsongui;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;

public class MyDrawPanel extends JPanel {

    private static final long serialVersionUID = -3728785126836461762L;
    private static final int RADIUS = 30;
    private static final Random RNG = new Random();
    private static Map<Point, Color> circles = new HashMap<>();

    // override of draw method
    /*
     *  Graphics = sarebbe una tavolozza
     *  All'interno viene fatta la super per poter
     *  ridisegnare le cose che ci sono di base
     */
    @Override
    protected final void paintComponent(final Graphics g) {
       super.paintComponent(g); 
       for (final Map.Entry<Point, Color> e : this.circles.entrySet()) {
           g.setColor(e.getValue());
           g.fillOval(e.getKey().x, e.getKey().y, RADIUS, RADIUS);
       }
    }

    public final void addRandomPoint() {
        int x = RNG.nextInt(this.getWidth());
        int y = RNG.nextInt(this.getHeight());
        this.addPoint(x, y);
    }

    public final void addPoint(final int x, final int y) {
        final Color c = new Color(RNG.nextInt(256), RNG.nextInt(256), RNG.nextInt(256));
        this.circles.put(new Point(x - RADIUS / 2, y - RADIUS / 2), c);
    }

}
