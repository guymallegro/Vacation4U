package sample.View;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class UpdateView extends View implements Initializable {

    public TextField userName;
    public TextField password;
    public TextField birth;
    public TextField firstName;
    public TextField lastName;
    public TextField city;

    public void back(ActionEvent actionEvent) {
        controller.setScreen(Main.MAIN_MENU_SCREEN);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userName.focusedProperty().addListener((ov, oldV, newV) -> {
            if (newV) {
                userName.setText(controller.getModel().getUserInfo().get("username"));
                password.setText(controller.getModel().getUserInfo().get("password"));
                birth.setText(controller.getModel().getUserInfo().get("birth"));
                firstName.setText(controller.getModel().getUserInfo().get("firstName"));
                lastName.setText(controller.getModel().getUserInfo().get("lastName"));
                city.setText(controller.getModel().getUserInfo().get("city"));
            }
        });
    }

    public void updateInfo(ActionEvent actionEvent) {
        controller.updateUser(userName.getText(), password.getText(), birth.getText(), firstName.getText(), lastName.getText(), city.getText());
    }
}