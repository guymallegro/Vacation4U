package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.sql.SQLException;

public class MainMenuView extends Controller {
    public TextField userName;
    public PasswordField password;
    public Text incorrect;
    public Button signup;

    public void login() throws SQLException {
        incorrect.setVisible(false);
        if (model.login(userName.getText(), password.getText())) {
            setScreen(Main.UPDATE_SCREEN);
            model.currentUser = userName.getText();
            model.getInfo(model.currentUser);
        } else
            incorrect.setVisible(true);
    }

    public void signUp(ActionEvent actionEvent) {
        setScreen(Main.REGISTRATION_SCREEN);
    }

}