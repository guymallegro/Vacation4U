package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import javax.xml.soap.Text;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class RegistrationView extends Controller{
    public TextField userName;
    public TextField password;
    public DatePicker birth;
    public TextField firstName;
    public TextField lastName;
    public TextField city;
    public javafx.scene.text.Text incorrect;
    public javafx.scene.text.Text badage;

    public void RegisterUser() throws SQLException {

        LocalDate date = birth.getValue();
        int year=date.getYear();
        if(2018-year<18){
        badage.setVisible(true);
        return;
        }
        if (model.RegisterUser(userName.getText(),password.getText(),date,firstName.getText(),lastName.getText(),city.getText())) {
            System.out.println("Register User successful!!");
            badage.setVisible(false);
            incorrect.setVisible(false);
            setScreen(Main.MAIN_MENU_SCREEN);
        }
        else
            incorrect.setVisible(true);
            badage.setVisible(false);


    }

    public void back(ActionEvent actionEvent){
        setScreen(Main.MAIN_MENU_SCREEN);
    }
}