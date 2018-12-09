package sample.View;

import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class PurchaseVaccationView extends View{

    public Text VaccationID;
    public TextField CreditNumber;
    public DatePicker Validation;
    public String userName;
    public Label ErrorCreditNum;

    public boolean isNumber(String str){
       for(int i=0;i<str.length();i++) {
           if(!Character.isDigit(str.charAt(i))){
             return false;
           }
       }
       return true;
    }
    public void Confirm(){
        if(!isNumber(CreditNumber.getText() )){
            ErrorCreditNum.setVisible(true);
            return;
        }

        controller.AddPayment(VaccationID.getText(), userName, CreditNumber.getText(), Validation.getValue());
        Stage stage= (Stage)CreditNumber.getScene().getWindow();
        stage.close();
    }

    public void setParameters(String id,String userName){
        VaccationID.setText(id);
        this.userName=userName;
    }
}
