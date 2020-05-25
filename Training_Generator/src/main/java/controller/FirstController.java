package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import jaxb.JAXBHelper;
import lombok.SneakyThrows;
import model.Exercise;
import model.Exercises;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FirstController implements Initializable {
    @FXML
    public ImageView image1;
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
    private TextField Exercise_Number;
    @FXML
    private ChoiceBox<String> Choice_Box;
    @FXML
    private Pane Alert_Pane;
    @FXML
    private Label Alert_Text;
    @FXML
    private Pane Base_Pane;
    @FXML
    public TextField Exercise_Add_TextField;

    private exerciseType Exercise_Type;
    private exerciseType Exercise_Generator_Type;


    @FXML
    private void handleAlertButton(ActionEvent event){
        Base_Pane.setOpacity(1);
        Base_Pane.setDisable(false);
        Alert_Pane.setVisible(false);
        Alert_Text.setText("");

    }

    public void choiceBoxClick() {
        if (Choice_Box.getValue() == "Mell"){
            Exercise_Generator_Type = exerciseType.Chest;
        }
        else if (Choice_Box.getValue() == "Hát"){
            Exercise_Generator_Type = exerciseType.Back;
        }
        else if (Choice_Box.getValue() == "Váll"){
            Exercise_Generator_Type = exerciseType.Shoulder;
        }
        else if (Choice_Box.getValue() == "Has"){
            Exercise_Generator_Type = exerciseType.Abs;
        }
        else if (Choice_Box.getValue() == "Láb"){
            Exercise_Generator_Type = exerciseType.Leg;
        }
        else if (Choice_Box.getValue() == "Bicepsz"){
            Exercise_Generator_Type = exerciseType.Biceps;
        }
        else if (Choice_Box.getValue() == "Tricepsz"){
            Exercise_Generator_Type = exerciseType.Triceps;
        }
    }

    private enum exerciseType {
        Chest,Back,Shoulder,Abs,Leg,Biceps,Triceps
    }

    @FXML
    protected void chestItem(ActionEvent event) {
        Table_Chest.setVisible(true);
        Table_Back.setVisible(false);
        Table_Shoulder.setVisible(false);
        Table_Abs.setVisible(false);
        Table_Leg.setVisible(false);
        Table_Biceps.setVisible(false);
        Table_Triceps.setVisible(false);
        Exercise_Type = exerciseType.Chest;


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
        Exercise_Type = exerciseType.Back;
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
        Exercise_Type = exerciseType.Shoulder;
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
        Exercise_Type = exerciseType.Abs;
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
        Exercise_Type = exerciseType.Leg;
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
        Exercise_Type = exerciseType.Biceps;
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
        Exercise_Type = exerciseType.Triceps;
    }

    /**
     * edittedCell This method will allow the user to double click on a cell and update the exercise
     */
    public void changeChestExerciseCellEvent(CellEditEvent edittedCell) {

        Exercise chestExerciseSelected = Table_Chest.getSelectionModel().getSelectedItem();
        chestExerciseSelected.setExercise(edittedCell.getNewValue().toString());
    }

    public void changeBackExerciseCellEvent(CellEditEvent edittedCell) {
        Exercise backExerciseSelected = Table_Back.getSelectionModel().getSelectedItem();
        backExerciseSelected.setExercise(edittedCell.getNewValue().toString());
    }

    public void changeShoulderExerciseCellEvent(CellEditEvent edittedCell) {
        Exercise shoulderExerciseSelected = Table_Shoulder.getSelectionModel().getSelectedItem();
        shoulderExerciseSelected.setExercise(edittedCell.getNewValue().toString());
    }

    public void changeAbsExerciseCellEvent(CellEditEvent edittedCell) {
        Exercise AbsExerciseSelected = Table_Abs.getSelectionModel().getSelectedItem();
        AbsExerciseSelected.setExercise(edittedCell.getNewValue().toString());
    }

    public void changeLegExerciseCellEvent(CellEditEvent edittedCell) {
        Exercise legExerciseSelected = Table_Leg.getSelectionModel().getSelectedItem();
        legExerciseSelected.setExercise(edittedCell.getNewValue().toString());
    }

    public void changeBicepsExerciseCellEvent(CellEditEvent edittedCell) {
        Exercise bicepsExerciseSelected = Table_Biceps.getSelectionModel().getSelectedItem();
        bicepsExerciseSelected.setExercise(edittedCell.getNewValue().toString());
    }

    public void changeTricepsExerciseCellEvent(CellEditEvent edittedCell) {
        Exercise tricepsExerciseSelected = Table_Triceps.getSelectionModel().getSelectedItem();
        tricepsExerciseSelected.setExercise(edittedCell.getNewValue().toString());
    }


    @SneakyThrows
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {





        /**
         * Set up the columns in the table
         */
        Chest_Column.setCellValueFactory(new PropertyValueFactory<Exercise, String>("exercise"));
        Back_Column.setCellValueFactory(new PropertyValueFactory<Exercise, String>("exercise"));
        Shoulder_Column.setCellValueFactory(new PropertyValueFactory<Exercise, String>("exercise"));
        Abs_Column.setCellValueFactory(new PropertyValueFactory<Exercise, String>("exercise"));
        Leg_Column.setCellValueFactory(new PropertyValueFactory<Exercise, String>("exercise"));
        Biceps_Column.setCellValueFactory(new PropertyValueFactory<Exercise, String>("exercise"));
        Triceps_Column.setCellValueFactory(new PropertyValueFactory<Exercise, String>("exercise"));

        /**
         *Load exercises in the table
         */
        Table_Chest.setItems(getExercise("Chest"));
        Table_Back.setItems(getExercise("Back"));
        Table_Shoulder.setItems(getExercise("Shoulder"));
        Table_Abs.setItems(getExercise("Abs"));
        Table_Leg.setItems(getExercise("Leg"));
        Table_Biceps.setItems(getExercise("Biceps"));
        Table_Triceps.setItems(getExercise("Triceps"));

        /**
         * Update all table to allow for the exercise fields to be editable
         */
        Table_Chest.setEditable(true);
        Chest_Column.setCellFactory(TextFieldTableCell.forTableColumn());
        Table_Back.setEditable(true);
        Back_Column.setCellFactory(TextFieldTableCell.forTableColumn());
        Table_Shoulder.setEditable(true);
        Shoulder_Column.setCellFactory(TextFieldTableCell.forTableColumn());
        Table_Leg.setEditable(true);
        Leg_Column.setCellFactory(TextFieldTableCell.forTableColumn());
        Table_Abs.setEditable(true);
        Abs_Column.setCellFactory(TextFieldTableCell.forTableColumn());
        Table_Biceps.setEditable(true);
        Biceps_Column.setCellFactory(TextFieldTableCell.forTableColumn());
        Table_Triceps.setEditable(true);
        Triceps_Column.setCellFactory(TextFieldTableCell.forTableColumn());

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

    /**
     * This method will create a new Exercise object and add it to the table
     */
    public void addExercise() throws IOException, JAXBException {
        Exercise newExercise = null;

        /**
         * Get all the items from the table as a list, then add the new exercise to the list
         */
        if (Exercise_Type == exerciseType.Chest) {
            newExercise = new Exercise(Exercise_Add_TextField.getText(),"Chest");
            Table_Chest.getItems().add(newExercise);
            Table_Chest.setVisible(false);
            Table_Chest.setVisible(true);

        }
        else if (Exercise_Type == exerciseType.Back) {
            newExercise = new Exercise(Exercise_Add_TextField.getText(),"Back");
            Table_Back.getItems().add(newExercise);
            Table_Back.setVisible(false);
            Table_Back.setVisible(true);

        }
        else if (Exercise_Type == exerciseType.Abs){
            newExercise = new Exercise(Exercise_Add_TextField.getText(),"Abs");
            Table_Abs.getItems().add(newExercise);
            Table_Abs.setVisible(false);
            Table_Abs.setVisible(true);
        }
        else if (Exercise_Type == exerciseType.Shoulder) {
            newExercise = new Exercise(Exercise_Add_TextField.getText(),"Shoulder");
            Table_Shoulder.getItems().add(newExercise);
            Table_Shoulder.setVisible(false);
            Table_Shoulder.setVisible(true);

        }
        else if (Exercise_Type == exerciseType.Leg) {
            newExercise = new Exercise(Exercise_Add_TextField.getText(),"Leg");
            Table_Leg.getItems().add(newExercise);
            Table_Leg.setVisible(false);
            Table_Leg.setVisible(true);
        }
        else if (Exercise_Type == exerciseType.Biceps) {
            newExercise = new Exercise(Exercise_Add_TextField.getText(),"Biceps");
            Table_Biceps.getItems().add(newExercise);
            Table_Biceps.setVisible(false);
            Table_Biceps.setVisible(true);

        }
        else if (Exercise_Type == exerciseType.Triceps){
            newExercise = new Exercise(Exercise_Add_TextField.getText(),"Triceps");
            Table_Triceps.getItems().add(newExercise);
            Table_Triceps.setVisible(false);
            Table_Triceps.setVisible(true);

        }

        FileHandler.saveExercisesInTheTable(newExercise);

    }





    public void switchToPlan(ActionEvent event) throws IOException {

        int Number = Integer.parseInt(Exercise_Number.getText());
        if (Number <= 8){
            choiceBoxClick();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/generate.fxml"));
            Parent root = fxmlLoader.load();
            SecondController controller = fxmlLoader.<SecondController>getController();
            if (Exercise_Generator_Type == exerciseType.Chest) {
                controller.data(Table_Chest.getItems(), Number);
            }
            else if (Exercise_Generator_Type == exerciseType.Back) {
                controller.data(Table_Back.getItems(), Number);
            }
            else if (Exercise_Generator_Type == exerciseType.Shoulder) {
                controller.data(Table_Shoulder.getItems(), Number);
            }
            else if (Exercise_Generator_Type == exerciseType.Abs) {
                controller.data(Table_Abs.getItems(), Number);
            }
            else if (Exercise_Generator_Type == exerciseType.Leg) {
                controller.data(Table_Leg.getItems(), Number);
            }
            else if (Exercise_Generator_Type == exerciseType.Biceps) {
                controller.data(Table_Biceps.getItems(), Number);
            }
            else if (Exercise_Generator_Type == exerciseType.Triceps) {
                controller.data(Table_Triceps.getItems(), Number);
            }

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        }
        else{
            Base_Pane.setOpacity(0.3);
            Base_Pane.setDisable(true);
            Alert_Pane.setVisible(true);
            Alert_Text.setText("Maximum 8 gyakorlat generálható!\n Többet úgyse bírsz!");

        }


    }




}
