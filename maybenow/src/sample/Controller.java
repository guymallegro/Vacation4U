package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public Model model = new Model();


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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void signUp(ActionEvent actionEvent) {
        Main.switchScene("registration");
    }

    public void back(ActionEvent actionEvent) {
        Main.switchScene("mainMenu");
    }
}
