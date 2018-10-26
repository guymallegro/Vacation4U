package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class UpdateView extends Controller implements Initializable {

    public TextField userName;
    public TextField password;
    public TextField birth;
    public TextField firstName;
    public TextField lastName;
    public TextField city;

    public void back(ActionEvent actionEvent) {
        setScreen(Main.MAIN_MENU_SCREEN);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userName.focusedProperty().addListener((ov, oldV, newV) -> {
            if (newV) {
                userName.setText(Model.userInfo.get("username"));
                password.setText(Model.userInfo.get("password"));
                birth.setText(Model.userInfo.get("birth"));
                firstName.setText(Model.userInfo.get("firstName"));
                lastName.setText(Model.userInfo.get("lastName"));
                city.setText(Model.userInfo.get("city"));

            }
        });
    }

    public void updateInfo(ActionEvent actionEvent) {
        model.updateUser(userName.getText(),password.getText(),birth.getText(),firstName.getText(),lastName.getText(),city.getText());
    }
}
