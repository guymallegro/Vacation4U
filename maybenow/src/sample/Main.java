package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    static Stage theStage;
    static final String MAIN_MENU_SCREEN = "MainMenu.fxml";
    static final String REGISTRATION_SCREEN = "Registration.fxml";
    static final String UPDATE_SCREEN = "Update.fxml";

    @Override
    public void start(Stage primaryStage){
        theStage = primaryStage;
        Controller controller = new Controller();
        controller.loadScreen(MAIN_MENU_SCREEN);
        controller.loadScreen(REGISTRATION_SCREEN);
        controller.loadScreen(UPDATE_SCREEN);
        controller.initScreen();
        theStage.setTitle("Vacation4U");
    }

    public static void main(String[] args) {
        launch(args);
    }
}