package Application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import static_class.OrderInfo;
import static_class.TakeOut;
import static_class.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TakeoutController
{


    @FXML
    private TextField numOfBox_txt; // only accept number
    @FXML
    private TextField phoneNumb_txt;// only accept number
    Connection connection;

    public TakeoutController()
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

        DB_Insert.Takeout(OrderInfo.getID(), TakeOut.getID(),numOfBox_txt.getText());
        ((Node)event.getSource()).getScene().getWindow().hide();  //hide current window

        Main main = new Main();
        main.createWindow("Payment_3.fxml");
    }

    public void back(ActionEvent event) throws Exception
    {
        ((Node)event.getSource()).getScene().getWindow().hide();  //hide current window

        Main main = new Main();
        main.createWindow("AssignOrder_2_2.fxml");
    }



    public void TextFieldKeyType(KeyEvent event)
    {
        String  c = event.getCharacter();
        char[] s= c.toCharArray();

        if(!Character.isDigit(s[0])){
            event.consume();
        }
    }

    public void TextFieldPhoneType(KeyEvent event)
    {
        String  c = event.getCharacter();
        char[] s= c.toCharArray();

        int count =0;
        String phone = "";

        if(!Character.isDigit(s[0]))
        {
            event.consume();
        }

        if(phoneNumb_txt.getLength() == 3 || phoneNumb_txt.getLength() == 7 ){
            phoneNumb_txt.appendText("-");
        }

        if(phoneNumb_txt.getLength() >11)
        {
            event.consume();
        }

    }
}
