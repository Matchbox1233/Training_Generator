package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Exercise;

import java.net.URL;
import java.util.ResourceBundle;

public class FirstController implements Initializable {

    @FXML
    private TableView<Exercise> Table_Chest;
    @FXML
    private TableView<Exercise> Table_Back;
    @FXML
    private TableView<Exercise> Table_Shoulder;
    @FXML
    private TableView<Exercise> Table_Abs;
    @FXML
    private TableView<Exercise> Table_Leg;
    @FXML
    private TableView<Exercise> Table_Biceps;
    @FXML
    private TableView<Exercise> Table_Triceps;
    @FXML
    private TableColumn<Exercise, String> Chest_Column;
    @FXML
    private TableColumn<Exercise, String> Back_Column;
    @FXML
    private TableColumn<Exercise, String> Abs_Column;
    @FXML
    private TableColumn<Exercise, String> Leg_Column;
    @FXML
    private TableColumn<Exercise, String> Shoulder_Column;
    @FXML
    private TableColumn<Exercise, String> Biceps_Column;
    @FXML
    private TableColumn<Exercise, String> Triceps_Column;
    @FXML
    private ChoiceBox<String> Choice_Box;


    @FXML
    protected void chestItem(ActionEvent event) {
        Table_Chest.setVisible(true);
        Table_Back.setVisible(false);
        Table_Shoulder.setVisible(false);
        Table_Abs.setVisible(false);
        Table_Leg.setVisible(false);
        Table_Biceps.setVisible(false);
        Table_Triceps.setVisible(false);



    }

    @FXML
    public void backItem(ActionEvent event) {
        Table_Chest.setVisible(false);
        Table_Back.setVisible(true);
        Table_Shoulder.setVisible(false);
        Table_Abs.setVisible(false);
        Table_Leg.setVisible(false);
        Table_Biceps.setVisible(false);
        Table_Triceps.setVisible(false);

    }

    @FXML
    public void shoulderItem(ActionEvent event) {
        Table_Chest.setVisible(false);
        Table_Back.setVisible(false);
        Table_Shoulder.setVisible(true);
        Table_Abs.setVisible(false);
        Table_Leg.setVisible(false);
        Table_Biceps.setVisible(false);
        Table_Triceps.setVisible(false);

    }

    @FXML
    public void absItem(ActionEvent event) {
        Table_Chest.setVisible(false);
        Table_Back.setVisible(false);
        Table_Shoulder.setVisible(false);
        Table_Abs.setVisible(true);
        Table_Leg.setVisible(false);
        Table_Biceps.setVisible(false);
        Table_Triceps.setVisible(false);
    }

    @FXML
    public void legItem(ActionEvent event) {
        Table_Chest.setVisible(false);
        Table_Back.setVisible(false);
        Table_Shoulder.setVisible(false);
        Table_Abs.setVisible(false);
        Table_Leg.setVisible(true);
        Table_Biceps.setVisible(false);
        Table_Triceps.setVisible(false);
    }

    @FXML
    public void bicepsItem(ActionEvent event) {
        Table_Chest.setVisible(false);
        Table_Back.setVisible(false);
        Table_Shoulder.setVisible(false);
        Table_Abs.setVisible(false);
        Table_Leg.setVisible(false);
        Table_Biceps.setVisible(true);
        Table_Triceps.setVisible(false);
    }

    @FXML
    public void tricepsItem(ActionEvent event) {
        Table_Chest.setVisible(false);
        Table_Back.setVisible(false);
        Table_Shoulder.setVisible(false);
        Table_Abs.setVisible(false);
        Table_Leg.setVisible(false);
        Table_Biceps.setVisible(false);
        Table_Triceps.setVisible(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        /**
         * This items are for configuring the ChoiceBox
         */
        Choice_Box.getItems().add("Mell");
        Choice_Box.getItems().add("Hát");
        Choice_Box.getItems().add("Váll");
        Choice_Box.getItems().add("Has");
        Choice_Box.getItems().add("Láb");
        Choice_Box.getItems().add("Biceps");
        Choice_Box.getItems().add("Triceps");

    }



}
