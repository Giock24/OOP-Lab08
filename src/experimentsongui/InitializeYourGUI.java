package experimentsongui;

public final class InitializeYourGUI {

    private InitializeYourGUI() {
    }
    /**
     *  @param s
     *          various args...
     */
    public static void main(final String... s) {
        /*
        final FirstGUI g1 = new FirstGUI();
        g1.display();
        */

        final GUIWithDifComp g2 = new GUIWithDifComp();
        g2.display();

    }

}
