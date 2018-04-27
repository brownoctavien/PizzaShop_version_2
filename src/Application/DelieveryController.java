package Application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import static_class.Customer;
import static_class.Delivery;
import static_class.OrderInfo;
import static_class.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DelieveryController {

    @FXML
    private TextField address1_txt;
    @FXML
    private TextField city_txt;
    @FXML
    private ComboBox state_cbox;
    @FXML
    private TextField zipCode_txt; // only accept number
    @FXML
    private TextField phoneNum_txt;

    Connection connection;

    public DelieveryController(){
        connection = SqliteConnection.Connector();
        if(connection == null) {
            System.out.println("Connection not successful");
            System.exit(1);
        }
    }



    public void next(ActionEvent event) throws Exception {

        if(!address1_txt.getText().isEmpty() && !city_txt.getText().isEmpty()&& state_cbox.getValue() != null&&
                !zipCode_txt.getText().isEmpty() && !phoneNum_txt.getText().isEmpty()){

            //add to delievery database
            DB_Insert.Delievery(OrderInfo.getID(), Delivery.getID(),address1_txt.getText(),city_txt.getText(),state_cbox.getValue().toString(),zipCode_txt.getText());

            //update customer database and add address and phone number
            PreparedStatement preparedStatement = null;
            String query = "UPDATE Customer SET Address = ?,"
                    +   "Phone = ?"
                    +   " WHERE  CustomerID= ?";

            try{
                System.out.println("Updating data to database Customer ");

                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, address1_txt.getText());
                preparedStatement.setString(2,phoneNum_txt.getText());
                preparedStatement.setString(3, String.valueOf(Customer.getID()));
            }catch (SQLException e) {
                System.out.println("e");
            } finally {
                preparedStatement.execute();
                preparedStatement.close();
            }


            ((Node)event.getSource()).getScene().getWindow().hide();  //hide current window

            Main main = new Main();
            main.createWindow("Payment_3.fxml");
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please enter values");
            alert.showAndWait();
        }

    }

    public void back(ActionEvent event) throws Exception {
        ((Node)event.getSource()).getScene().getWindow().hide();  //hide current window

        Main main = new Main();
        main.createWindow("AssignOrder_2_2.fxml");
    }

    public void TextFieldZipCodeType(KeyEvent event){
        String  c = event.getCharacter();
        char[] s= c.toCharArray();

        if(!Character.isDigit(s[0])){
            event.consume();
        }
        if(zipCode_txt.getLength() >=5){
            event.consume();
        }
    }

    public void TextFieldPhoneType(KeyEvent event){
        String  c = event.getCharacter();
        char[] s= c.toCharArray();
        int count =0;

        if(!Character.isDigit(s[0])){
            event.consume();
        }

        if(phoneNum_txt.getLength() == 3 || phoneNum_txt.getLength() == 7 ){
            phoneNum_txt.appendText("-");
        }

        if(phoneNum_txt.getLength() >11){
            event.consume();
        }
    }

}
