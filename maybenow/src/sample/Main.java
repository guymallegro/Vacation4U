package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    static Stage theStage;
    static Parent registration;

    @Override
    public void start(Stage primaryStage) throws Exception {
        theStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        registration = FXMLLoader.load(getClass().getResource("Registration.fxml"));
        primaryStage.setTitle("Vacation4U");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void switchScene(String scene) {
        switch (scene) {
            case "registration":
                theStage.setScene(new Scene(registration));
            case "mainMenu":
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}