package sample.View;

import javafx.scene.control.*;
import javafx.event.ActionEvent;

public class AddVactionView extends View {

    public TextField AirLineCompany;
    public DatePicker StartDate;
    public DatePicker EndDate;
    public TextField TicketNumbers;
    public TextField CountryName;
    public CheckBox IsIncludeReturnFlight;
    public ComboBox TicketType;
    public CheckBox IsIncludeAccommodation;
    public TextField AccommodationName;
    public TextField Price;
    public javafx.scene.text.Text badTicNum;
    public javafx.scene.text.Text badRank;
    public void CreateVacation(){

        if(!CheckNumber(TicketNumbers.getText()) && !CheckNumber(Price.getText())){
            badTicNum.setVisible(true);
            badRank.setVisible(true);
            return;
        }

        if(!CheckNumber(TicketNumbers.getText())){
            badTicNum.setVisible(true);
            return;
        }
        else
            badTicNum.setVisible(false);

        if(!CheckNumber(Price.getText())){
            badRank.setVisible(true);
            return;
        }
        else
            badRank.setVisible(false);

        controller.AddVacation(controller.getCurrentUser(),AirLineCompany.getText(),StartDate.getValue(),EndDate.getValue(),TicketNumbers.getText(),
                CountryName.getText(),IsIncludeReturnFlight.isSelected(),TicketType.getSelectionModel().getSelectedItem().toString(),IsIncludeAccommodation.isSelected(),
                AccommodationName.getText(),Price.getText());

        Alert Sucess = new Alert(Alert.AlertType.INFORMATION);
        Sucess.setTitle("Vaccation Added Succesfully!");
        Sucess.setHeaderText("Vaccation Added Succesfully");
        Sucess.show();
        Init();
        back();

    }

    private void Init() {
        AirLineCompany.setText("");
        TicketNumbers.setText("");
        CountryName.setText("");
        AccommodationName.setText("");
        Price.setText("");

        badTicNum.setVisible(false);
        badRank.setVisible(false);

    }


    public void back(){
        controller.setScreen(Main.OPERATION_SCREEN);
    }



    /*Checking if a string is a number */
    public boolean CheckNumber(String num){

        for(int i=0;i<num.length();i++){
            if(!Character.isDigit(num.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public void initialize() {
        TicketType.getItems().removeAll(TicketType.getItems());
        TicketType.getItems().addAll("Adult", "Kid", "Baby");
    }

}
