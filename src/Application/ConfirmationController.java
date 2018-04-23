package Application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import static_class.Customer;
import static_class.OrderInfo;
import static_class.PizzaMenu;
import static_class.Transaction;



public class ConfirmationController implements Initializable
{

    @FXML
    private TextField name_txt;
    @FXML
    private TextField amountPaid_txt;
    @FXML
    private TextField pizzaOrder_txt;
    @FXML
    private TextField paymentType_txt;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        name_txt.setText(Customer.getName());
        amountPaid_txt.setText(String.valueOf("$"+ Transaction.getCustomerPaymentAmount()));
        pizzaOrder_txt.setText(PizzaMenu.getSize()+ " "+ PizzaMenu.getTopping() + " Pizza x" + PizzaMenu.getCount());
        paymentType_txt.setText(OrderInfo.getPaymentType());
    }


    public void gotoMain(ActionEvent event) throws Exception
    {
        ((Node)event.getSource()).getScene().getWindow().hide();  //hide current window

        Main main = new Main();
        main.createWindow("Main_2.fxml");
    }


}
