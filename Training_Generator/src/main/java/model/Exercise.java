package model;

import javafx.beans.property.SimpleStringProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * This class is a getter and setter to the exercises.
 * */
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exercise {

    @XmlJavaTypeAdapter(SimpleStringAdapter.class)
    private SimpleStringProperty exercise;
    private String exerciseType;

    public Exercise(String exercise, String exerciseType){
        this.exercise = new SimpleStringProperty(exercise);
        this.exerciseType = exerciseType;
    }

    public String getExercise() {
        return exercise.get();
    }

    public SimpleStringProperty exerciseProperty() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = new SimpleStringProperty(exercise);
    }
}

