package Application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import static_class.Transaction;
import static_class.OrderInfo;

import java.net.URL;
import java.util.ResourceBundle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaymentController implements Initializable
{

    @FXML
    private TextField amountPaid_txt;
    @FXML
    private ComboBox paymentType_cbox;


    Connection connection;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
            amountPaid_txt.setText(String.valueOf("$" +Transaction.getCustomerPaymentAmount())); //get amount from Transaction class
            paymentType_cbox.setValue("Cash"); //defult cash payment type
    }

    public PaymentController()
    {
        connection = SqliteConnection.Connector();
        if(connection == null)
        {
            System.out.println("Connection not successful");
            System.exit(1);
        }

    }

    public void next(ActionEvent event) throws Exception
    {
        ((Node)event.getSource()).getScene().getWindow().hide();  //hide current window

        //assign payment type to database: orderinfo: Payment type
        if (paymentType_cbox.getValue() != null)
        {
            //assign payment type to OrderInfo
            OrderInfo.setPaymentType(paymentType_cbox.getValue().toString());

            String orderid = String.valueOf( OrderInfo.getID());
            PreparedStatement preparedStatement = null;
            String query = "UPDATE OrderInfo SET PaymentAmount = ?,"
                    +   "PaymentType = ?"
                    +   " WHERE  OrderID= ?";

            try
            {
                System.out.println("Adding data to database Payment ");
                System.out.println("orderid: "+ orderid+ " and paymentAmount: "+ Transaction.getCustomerPaymentAmount() );

                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, String.valueOf(Transaction.getCustomerPaymentAmount()));
                preparedStatement.setString(2, paymentType_cbox.getValue().toString());
                preparedStatement.setString(3, orderid);
            }
            catch (SQLException e)
            {
                System.out.println("e");
            }
            finally
            {
                preparedStatement.execute();
                preparedStatement.close();
            }

        }


        Main main = new Main();

        if (paymentType_cbox.getValue().equals("Debit Card"))
        {
            main.createWindow("DebitCard.fxml");
        }
        else if(paymentType_cbox.getValue().equals("Credit Card"))
        {
            main.createWindow("CreditCard.fxml");
        }
        else
        {
            main.createWindow("Confirmation_4.fxml");
        }



    }

    public void back(ActionEvent event) throws Exception
    {
        ((Node)event.getSource()).getScene().getWindow().hide();  //hide current window

        Main main = new Main();
        main.createWindow("AssignOrder_2_2.fxml");

    }



}
