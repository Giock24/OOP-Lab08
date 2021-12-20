package experimentsongui;

public class Color {

    private final int r;
    private final int g;
    private final int b;

    public Color(final int r, final int g, final int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    @Override
    public final String toString() {
        return " " + this.r + " " + this.g + " " + this.b + " ";
    }


}
