package it.unibo.oop.lab.mvcio;

import java.io.File;

public interface ControllerInterface {

    /**
     *  @param nameFile
     *          set a new File where you can write
     */
    void setFile(String nameFile);

    /**
     *  @return 
     *          the Name of currentFile
     */
    File getFile();

    /**
     *  @return String
     *          return PATH
     */
    String getPATH();


    /**
     *  @param word
     *          if you insert a word, it'll be written in the File
     */
    void writeOnFile(String word);

}
