package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class RegistrationView extends Controller{
    public TextField userName;
    public TextField password;
    public TextField birth;
    public TextField firstName;
    public TextField lastName;
    public TextField city;


    public void RegisterUser() throws SQLException {
        if (model.RegisterUser(userName.getText(),password.getText(),birth.getText(),firstName.getText(),lastName.getText(),city.getText()));
            System.out.println("Register User successful!!");
    }

    public void back(ActionEvent actionEvent){
        setScreen(Main.MAIN_MENU_SCREEN);
    }
}


