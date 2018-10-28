package sample.View;


import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

import java.util.Optional;


public class OperationView extends View {

    public Button UpdateAccount;
    public Button Logout;
    public Button DeleteAccount;
    public Button SearchAccount;

    public void UpdateAccount(ActionEvent actionEvent) {
        controller.setScreen(Main.UPDATE_SCREEN);
    }

    public void SearchAccount(ActionEvent actionEvent) {
        controller.setScreen(Main.SEARCH_SCREEN);
    }

    public void Logout(ActionEvent actionEvent) {
        controller.setScreen(Main.MAIN_MENU_SCREEN);
    }

    public void DeleteAccount(ActionEvent actionEvent) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Warning!");
        alert.setHeaderText("");
        alert.setContentText("Are you sure you want to delete your account?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            // ...user delete his account..
            controller.DeleteUser();
            controller.setScreen(Main.MAIN_MENU_SCREEN);
        } else {
            // do nothing..
        }

    }

}
