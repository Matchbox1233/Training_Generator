package controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Exercise;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SecondController {
    @FXML
    public ImageView image2;
    @FXML
    private Label Training_Plan;

    public void data(ObservableList<Exercise> exercises, int number){
        List<Exercise> generatedExercises = new ArrayList<>();
        Random random = new Random();
        for (int i=0; i<number; i++){
            Exercise exercise = null;
            do {
                int id;
                id = random.nextInt(exercises.size());
                exercise = exercises.get(id);
            }while (generatedExercises.contains(exercise));
            generatedExercises.add(exercise);

        }
        String plan = "";
        for (Exercise e : generatedExercises) {
            plan+=e.getExercise()+"\n";
        }
        Training_Plan.setText(plan);
    }

    public void switchToBase(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/base.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();

    }
}
