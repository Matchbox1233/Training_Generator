package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExerciseTest {

    @Test
    void getExercise() {
        Exercise exercise = new Exercise("Fekvenyomás","Chest");
        assertEquals("Fekvenyomás", exercise.getExercise());
        assertEquals("Chest", exercise.getExerciseType());

        exercise = new Exercise("Tárogatás","Chest");
        assertEquals("Tárogatás", exercise.getExercise());
        assertEquals("Chest", exercise.getExerciseType());

        exercise = new Exercise("Áthúzás","Chest");
        assertEquals("Áthúzás", exercise.getExercise());
        assertEquals("Chest", exercise.getExerciseType());


        exercise = new Exercise("Tárcsa előre emelés","Shoulder");
        assertEquals("Tárcsa előre emelés", exercise.getExercise());
        assertEquals("Shoulder", exercise.getExerciseType());

        exercise = new Exercise("Tárogató gép hátsó vállra","Shoulder");
        assertEquals("Tárogató gép hátsó vállra", exercise.getExercise());
        assertEquals("Shoulder", exercise.getExerciseType());

        exercise = new Exercise("Fejfölé nyomás állva","Shoulder");
        assertEquals("Fejfölé nyomás állva", exercise.getExercise());
        assertEquals("Shoulder", exercise.getExerciseType());


        exercise = new Exercise("Guggolás","Leg");
        assertEquals("Guggolás", exercise.getExercise());
        assertEquals("Leg", exercise.getExerciseType());

        exercise = new Exercise("Kitörés","Leg");
        assertEquals("Kitörés", exercise.getExercise());
        assertEquals("Leg", exercise.getExerciseType());

        exercise = new Exercise("Támadójárás","Leg");
        assertEquals("Támadójárás", exercise.getExercise());
        assertEquals("Leg", exercise.getExerciseType());

    }
}