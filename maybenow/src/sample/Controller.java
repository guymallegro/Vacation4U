package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.util.HashMap;

class Controller {
    private static HashMap<String, Parent> screens = new HashMap<>();
    public Model model = new Model();

    void loadScreen(String source) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(source));
            Parent loadScreen = loader.load();
            screens.put(source, loadScreen);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void initScreen() {
        Scene scene = new Scene(screens.get(Main.MAIN_MENU_SCREEN));
        Main.theStage.setScene(scene);
        Main.theStage.show();
        Main.theStage.getScene().setRoot(screens.get(Main.MAIN_MENU_SCREEN));
    }

    void setScreen(String name) {
        Main.theStage.getScene().setRoot(screens.get(name));
    }
}