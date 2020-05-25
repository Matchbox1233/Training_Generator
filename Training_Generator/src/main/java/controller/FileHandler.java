package controller;

import jaxb.JAXBHelper;
import model.Exercise;
import model.Exercises;
import org.tinylog.Logger;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.ArrayList;


/**
 * Class for handling file operations.
 * */
public class FileHandler {
    /**
     * Loads exercises of the programe.
     *
     * */
    public static Exercises loadExercises() throws JAXBException, FileNotFoundException {
        String userHome = System.getProperty("user.home");
        String separator = File.separator;
        String saveFilePath = userHome + separator + ".TrainingGenerator" + separator + "savefile.xml";
        Logger.info("Loading exercises from " + saveFilePath);
        File saveFile = new File(saveFilePath);
        InputStream is = new FileInputStream(saveFile);
        return JAXBHelper.fromXML(Exercises.class, is);

    }

    /**
     * Saves the player's stats.
     * @param exercise The exercise's name
     * * @throws IOException if any problem occurs opening the save file
     * @throws JAXBException if any problem occurs during serialization or deserialization
     * */
    public static void saveExercisesInTheTable(Exercise exercise) throws IOException, JAXBException {
        String userHome = System.getProperty("user.home");
        String separator = File.separator;
        String saveFilePath = userHome + separator + ".TrainingGenerator" + separator + "savefile.xml";
        Logger.info("Loading save file from " + saveFilePath);

        File saveFile = new File(saveFilePath);
        InputStream is = new FileInputStream(saveFile);
        Exercises exercises = JAXBHelper.fromXML(Exercises.class, is);
        is.close();
        if(exercises.getExercise() == null)
        {
            exercises.setExercise(new ArrayList<>());
        }
        exercises.getExercise().add(exercise);
        OutputStream os = new FileOutputStream(saveFile);
        JAXBHelper.toXML(exercises, os);
        os.close();
    }

    /**
     * Checks for existing save file in the file system.
     * @return Whether the save file exists
     * */
    public static boolean doesSaveFileExist()
    {
        Logger.info("Checking for save file");

        String userHome = System.getProperty("user.home");
        String separator = File.separator;
        String saveFilePath = userHome + separator + ".TrainingGenerator" + separator + "savefile.xml";
        Logger.debug("Save file location: " + saveFilePath);

        File saveFile = new File(saveFilePath);
        return saveFile.exists();
    }

    /**
     * Creates save file.
     * */
    public static void createSaveFile(Exercises exercises) throws IOException, JAXBException {
        Logger.info("Save file not found. Creating save file.");

        String userHome = System.getProperty("user.home");
        String separator = File.separator;
        String saveFilePath = userHome + separator + ".TrainingGenerator" + separator + "savefile.xml";
        String saveFileDir = userHome + separator + ".TrainingGenerator";
        new File(saveFileDir).mkdirs();
        OutputStream os = new FileOutputStream(saveFilePath);
        JAXBHelper.toXML(exercises, os);
        os.close();
    }
}
