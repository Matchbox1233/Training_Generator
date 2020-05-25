package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class MyApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("/fxml/base.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Edzésterv generátor");
        stage.setWidth(620);
        stage.setHeight(550);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

    }
}
