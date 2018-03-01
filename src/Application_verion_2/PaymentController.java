package Application_verion_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import static_class.Transaction;

import java.net.URL;
import java.util.ResourceBundle;

public class PaymentController implements Initializable{

    @FXML
    private TextField amountPaid_txt;
    @FXML
    private ComboBox paymentType_cbox;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
            amountPaid_txt.setText(String.valueOf("$" +Transaction.getCustomerPaymentAmount())); //get amount from Transaction class
            paymentType_cbox.setValue("Cash"); //defult cash payment type
    }

    public void next(ActionEvent event) throws Exception  {
        ((Node)event.getSource()).getScene().getWindow().hide();  //hide current window

        Main main = new Main();

        if(paymentType_cbox.getValue().equals("Debit Card")){
            main.createWindow("DebitCard.fxml");
        }
        else if(paymentType_cbox.getValue().equals("Credit Card")){
            main.createWindow("CreditCard.fxml");
        }
        else{

            main.createWindow("Confirmation_4.fxml");
        }
    }

    public void back(ActionEvent event) throws Exception {
        ((Node)event.getSource()).getScene().getWindow().hide();  //hide current window

        Main main = new Main();
        main.createWindow("AssignOrder_2_2.fxml");

    }


}
