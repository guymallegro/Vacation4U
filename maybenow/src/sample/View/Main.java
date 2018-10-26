package sample.View;

import javafx.application.Application;
import javafx.stage.Stage;
import sample.Controller;
import sample.Model.Model;

public class Main extends Application {
    public static Stage theStage;
    public static final String MAIN_MENU_SCREEN = "View/MainMenu.fxml";
    public static final String REGISTRATION_SCREEN = "View/Registration.fxml";
    public static final String UPDATE_SCREEN = "View/Update.fxml";

    @Override
    public void start(Stage primaryStage) {
        Model model = new Model();
        theStage = primaryStage;
        Controller controller = new Controller(model);
        View view = new View();
        view.setController(controller);
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