package it.unibo.oop.lab.mvc;

import java.util.ArrayList;
import java.util.List;

public class ControllerImpl implements Controller {

    //private static final String SEP = System.getProperty("user.separator");
    //private static final String HOME = System.getProperty("user.home");
    //private static final String PATH = " " + HOME + " " + SEP + "output.txt";

    private int index;
    //private final File file = new File(PATH);
    private final List<String> list = new ArrayList<>();
    private String currentString;

    public ControllerImpl() {
        this.currentString = null;
    }

    /**
     *  {@inheritDoc}
     */
    public void setString(final String string) {
        try {
            this.list.add(string);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    /**
     *  {@inheritDoc}
     */
    public String getNextString() {
        if (this.index == this.list.size()) {
            this.index = 0;
            this.currentString = this.list.get(this.index);
            this.index++;
            return this.currentString;
        } else {
            //System.out.println(this.index);
            this.currentString = this.list.get(this.index);
            this.index++;
            //System.out.println(this.index);
            return this.currentString;
        }
    }

    /**
     *  {@inheritDoc}
     */
    public List<String> getHistory() {
        return this.list;
    }

    /**
     *  {@inheritDoc}
     */
    public String printString() {
        final int index = this.list.size() - 1;
        try {
            return this.list.get(index);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        return "the list doesn't exist";
    }

    /**
     * 
     * with this method you can reset the index of arraList.
     */
    public void resetIndex() {
        this.index = 0;
    }

}
