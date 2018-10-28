package sample.View;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.time.LocalDate;

public class RegistrationView extends View {
    public TextField userName;
    public TextField password;
    public DatePicker birth;
    public TextField firstName;
    public TextField lastName;
    public TextField city;
    public javafx.scene.text.Text userNameTaken;
    public javafx.scene.text.Text badage;

    public void RegisterUser() throws SQLException {

        LocalDate date = birth.getValue();
        int year=date.getYear();
        if(2018-year<18){
            badage.setVisible(true);
            return;
        }
        if (controller.registerUser(userName.getText(),password.getText(),date,firstName.getText(),lastName.getText(),city.getText())) {
            System.out.println("Register User successful!!");
            badage.setVisible(false);
            userNameTaken.setVisible(false);
            controller.setScreen(Main.MAIN_MENU_SCREEN);
        }
        else
            userNameTaken.setVisible(true);
        badage.setVisible(false);
    }
    public void back(ActionEvent actionEvent){
        controller.setScreen(Main.MAIN_MENU_SCREEN);
    }
}