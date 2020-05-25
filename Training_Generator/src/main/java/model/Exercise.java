package model;

import javafx.beans.property.SimpleStringProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Data class that represents {@code Exercise} objects stored in the save file.
 * */
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exercise {

    /**
     * Getter and Setter for the Exercises.
     */
    @XmlJavaTypeAdapter(SimpleStringAdapter.class)
    private SimpleStringProperty exercise;
    private String exerciseType;

    /**
     *
     * @param exercise The exercise's name
     * @param exerciseType The name of the exercise type
     */
    public Exercise(String exercise, String exerciseType){
        this.exercise = new SimpleStringProperty(exercise);
        this.exerciseType = exerciseType;
    }

    /**
     *
     * @return exercise name
     */
    public String getExercise() {
        return exercise.get();
    }

    /**
     *
     * @return exercise Property
     */
    public SimpleStringProperty exerciseProperty() {
        return exercise;
    }

    /**
     *
     * @param exercise The name of the new SimpleStringProperty exercise
     */
    public void setExercise(String exercise) {
        this.exercise = new SimpleStringProperty(exercise);
    }
}

