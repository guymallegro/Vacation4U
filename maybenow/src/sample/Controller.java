package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import sample.View.Main;
import sample.Model.Model;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;

public class Controller {
    private HashMap<String, Parent> screens = new HashMap<>();
    private Model model;

    public Controller(Model model) {
        this.model = model;
    }

    public void loadScreen(String source) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(source));
            Parent loadScreen = loader.load();
            screens.put(source, loadScreen);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void initScreen() {
        Scene scene = new Scene(screens.get(Main.MAIN_MENU_SCREEN));
        Main.theStage.setScene(scene);
        Main.theStage.show();
        Main.theStage.getScene().setRoot(screens.get(Main.MAIN_MENU_SCREEN));
    }

    public void setScreen(String name) {
        Main.theStage.getScene().setRoot(screens.get(name));
    }

    public boolean login(String userName, String password) {
        return model.login(userName, password);
    }

    public boolean registerUser(String userName, String password, LocalDate date, String firstName, String lastName, String city) {
        return model.RegisterUser(userName, password, date, firstName, lastName, city);
    }

    public void updateUser(String userName, String password, LocalDate birth, String firstName, String lastName, String city) {
        model.updateUser(userName, password, birth, firstName, lastName, city);
    }

    public void setCurrentUser(String userName) {
        model.setCurrentUser(userName);
    }

    public HashMap<String,String> searchUser(String userName) {
        return model.searchUser(userName);
    }

    public void getInfo(String userName) {
        model.getInfo(userName);
    }

    public HashMap<String, String> getUserInfo(){
        return model.getUserInfo();
    }
}