package it.unibo.oop.lab.mvcio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 */
public class Controller implements ControllerInterface {

    /*
     * This class must implement a simple controller responsible of I/O access. It
     * considers a single file at a time, and it is able to serialize objects in it.
     * 
     * Implement this class with:
     * 
     * 1) A method for setting a File as current file
     * 
     * 2) A method for getting the current File
     * 
     * 3) A method for getting the path (in form of String) of the current File
     * 
     * 4) A method that gets a String as input and saves its content on the current
     * file. This method may throw an IOException.
     * 
     * 5) By default, the current file is "output.txt" inside the user home folder.
     * A String representing the local user home folder can be accessed using
     * System.getProperty("user.home"). The separator symbol (/ on *nix, \ on
     * Windows) can be obtained as String through the method
     * System.getProperty("file.separator"). The combined use of those methods leads
     * to a software that runs correctly on every platform.
     */

    private static final String PATH = System.getProperty("user.home")
            + System.getProperty("file.separator")
            + "output.txt";

    //private static final String FILE = "output.txt";

    private File currentFile = new File(PATH);
    private String percorso = PATH;

    /**
     *  {@inheritDoc}
     */
    public void setFile(final String nameFile) {
        this.currentFile = new File(System.getProperty("user.home")
                + System.getProperty("file.separator")
                + nameFile + ".txt");
        this.percorso = this.currentFile.getAbsolutePath();
    }

    /**
     *  {@inheritDoc}
     */
    public String getFile() {
       return this.currentFile.getName();
    }

    /**
     *  {@inheritDoc}
     */
    public String getPATH() {
        return this.percorso;
    }

    /**
     *  {@inheritDoc}
     */
    public void writeOnFile(final String word) {
        try (FileWriter file = new FileWriter(this.currentFile);
              BufferedWriter w = new BufferedWriter(file)) {
            w.write(word);
            w.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
