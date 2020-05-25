package main;

import javafx.application.Application;
import org.tinylog.Logger;

import java.io.IOException;

/**
 * This is a main class in the program.
 */
public class Main {
    /**
     *This method launch the MyApplication class.
     * @param args The number of arguments
     * @throws IOException if any problem occurs running the program
     */
    public static void main(String[] args) throws IOException {
        Logger.info("Program is running");
        Application.launch(MyApplication.class, args);
    }
}
