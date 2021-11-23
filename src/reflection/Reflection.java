package reflection;

public class Reflection {

    public static void m(final Object o) {
        if (o.getClass().getName().equals("java.lang.String")) {
            System.out.println("Questo oggetto è una stringa");
        } else {
            System.out.println("Questo oggetto non è una stringa!");
        }
    }

    public static void main(final String[] args) throws ClassNotFoundException {

        var v = String.class;
        System.out.println(v);

        String s = "Ciao sono una Stringa"; // a tempo d'esec. capisce che tipo di .class è, anche se è stato inizializzato
        System.out.println(s.getClass());

        var o = Class.forName("reflection.Initializers"); // se non la trova tira un'eccezione
        System.out.println(o);

        m("Xiao");
        //System.out.println("");
        m(new Object ());
    }

}
