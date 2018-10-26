package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.sql.SQLException;

public class MainMenuView extends Controller {
    private Model model = new Model();
    public TextField userName;
    public PasswordField password;
    public Text incorrect;
    public Button signup;

    public void login() throws SQLException {
        incorrect.setVisible(false);
        if (model.login(userName.getText(), password.getText()))
            System.out.println("Login successful!!");
        else
            incorrect.setVisible(true);
    }

    public void signUp(ActionEvent actionEvent){
        setScreen(Main.REGISTRATION_SCREEN);
    }
}