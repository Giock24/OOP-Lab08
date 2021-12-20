package experimentsongui;

public class Point {

    private final int x;
    private final int y;

    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public final String toString() {
        return " Coordinates: " + this.x + " " + this.y + " ";
    }

}
