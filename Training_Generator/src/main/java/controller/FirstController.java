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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import jaxb.JAXBHelper;
import lombok.SneakyThrows;
import model.Exercise;
import model.Exercises;
import org.tinylog.Logger;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This class is control the base fxml.
 */
public class FirstController implements Initializable {
    /**
     * These are implementations from the base fxml.
     */
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
    private TextField Exercise_Add_TextField;

    private exerciseType Exercise_Type;
    private exerciseType Exercise_Generator_Type;

    /**
     *This method give back the base scene.
     * @param event The event for the back step
     */
    @FXML
    private void handleAlertButton(ActionEvent event){
        Base_Pane.setOpacity(1);
        Base_Pane.setDisable(false);
        Alert_Pane.setVisible(false);
        Alert_Text.setText("");
    }

    /**
     * Choice Box events.
     */
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

    /**
     This method can help to load Chest table.
     * @param event The event get the Item from menu items
     */
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

    /**
     This method can help to load Back table.
     * @param event The event get the Item from menu items
     */
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

    /**
     This method can help to load Shoulder table.
     * @param event The event get the Item from menu items
     */
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

    /**
     This method can help to load Abs table.
     * @param event The event get the Item from menu items
     */
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

    /**
     This method can help to load Leg table.
     * @param event The event get the Item from menu items
     */
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

    /**
     *This method can help to load Biceps table.
     * @param event The event get the Item from menu items
     */
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

    /**
     *This method can help to load Triceps table.
     * @param event The event get the Item from menu items
     */
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

    @SneakyThrows
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        if (!FileHandler.doesSaveFileExist()){
            Exercises exercises = JAXBHelper.fromXML(Exercises.class, getClass().getClassLoader().getResourceAsStream("xml/exercises.xml"));
            FileHandler.createSaveFile(exercises);
        }

        /**
         * Set up the columns in the table.
         */
        Chest_Column.setCellValueFactory(new PropertyValueFactory<Exercise, String>("exercise"));
        Back_Column.setCellValueFactory(new PropertyValueFactory<Exercise, String>("exercise"));
        Shoulder_Column.setCellValueFactory(new PropertyValueFactory<Exercise, String>("exercise"));
        Abs_Column.setCellValueFactory(new PropertyValueFactory<Exercise, String>("exercise"));
        Leg_Column.setCellValueFactory(new PropertyValueFactory<Exercise, String>("exercise"));
        Biceps_Column.setCellValueFactory(new PropertyValueFactory<Exercise, String>("exercise"));
        Triceps_Column.setCellValueFactory(new PropertyValueFactory<Exercise, String>("exercise"));

        /**
         *Load exercises in the table.
         */
        Table_Chest.setItems(getExercise("Chest"));
        Table_Back.setItems(getExercise("Back"));
        Table_Shoulder.setItems(getExercise("Shoulder"));
        Table_Abs.setItems(getExercise("Abs"));
        Table_Leg.setItems(getExercise("Leg"));
        Table_Biceps.setItems(getExercise("Biceps"));
        Table_Triceps.setItems(getExercise("Triceps"));

        /**
         * This items are for configuring the ChoiceBox.
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
     * This method will create a new Exercise object and add it to the table.
     * @throws IOException if any problem occurs adding a new exercise
     * @throws JAXBException if any problem occurs during addition
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

    /**
     * @param trainingExercises name of an exercise type
     * @return This method will return an ObservableList of Exercise objects
     * @throws JAXBException if any problem occurs during deserialization
     *@throws FileNotFoundException if any problem with the existence of the file
     */
    public static ObservableList<Exercise> getExercise(String trainingExercises) throws JAXBException, FileNotFoundException {
        Exercises workoutExercises = FileHandler.loadExercises();
        ObservableList<Exercise> exercises = FXCollections.observableArrayList();
        for (Exercise exercise:workoutExercises.getExercise()) {
            if (exercise != null && exercise.getExerciseType().equals(trainingExercises)){
                exercises.add(exercise);
            }
        }

        return exercises;
    }

    /**
     *
     * @param event Switch to the generate fxml
     * @throws IOException if any problem occurs generating a new workout plan
     */
    public void switchToPlan(ActionEvent event) throws IOException {
        Logger.info("Switch to the generate xml");

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
