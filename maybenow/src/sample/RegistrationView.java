package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;

public class RegistrationView extends Controller{
    public TextField userName;
    public TextField password;
    public TextField birth;
    public TextField firstName;
    public TextField lastName;
    public TextField city;

    public void back(ActionEvent actionEvent){
        setScreen(Main.MAIN_MENU_SCREEN);
    }
}
