package reflection;

public class Initializers {

    static {
        System.out.println("This is a static Initializer...");
    }

    {
        System.out.println("This is a non-static Initializer...");
    }

    private static int i = 4;

    public Initializers() {
        System.out.println("Instance Done!");
        this.i = 5;
    }

    /**
     * 
     * @return
     *      value of int i
     */
    public int getI() {
        return this.i;
    }

    public static void main(final String... s) {
        System.out.println("Creation of class...");
        final Initializers init = new Initializers();
        System.out.println(init.getI());

    }

}
