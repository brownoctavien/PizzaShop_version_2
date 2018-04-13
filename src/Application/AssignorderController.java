package Application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import static_class.Customer;
import static_class.OrderInfo;
import static_class.Transaction;
import  static_class.Delivery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AssignorderController {

    @FXML
    private ComboBox pizzaSize_cbox;
    @FXML
    private ComboBox topping_cbox;
    @FXML
    private ComboBox saleType_cbox ;
    @FXML
    private TextField quantity_txt; // only accept number
    @FXML
    private TextField name_txt;

    private String price;

    Connection connection;


    private int orderCount ;

    public AssignorderController (){
        connection = SqliteConnection.Connector();
        if(connection == null) {
            System.out.println("Connection not successful");
            System.exit(1);
        }
        orderCount=0;
    }



    public void AddCustomer(ActionEvent event) throws SQLException {
        if (saleType_cbox.getValue() != null && pizzaSize_cbox.getValue() != null && topping_cbox.getValue() != null && !quantity_txt.getText().isEmpty() && !name_txt.getText().isEmpty() && orderCount<=1 ) {
            orderCount =1;
            //assign name to customer
            Customer.setName(name_txt.getText());
            // make random orderId
            OrderInfo.makeID();
            String orderid = String.valueOf(OrderInfo.getID());
            //make random customerId
            Customer.makeID();
            String customerid = String.valueOf(Customer.getCustomerID());

            // assign  id to database: orderinfo: id, customerID; customer: customerID
            // assign name to database: customer: name;
            PreparedStatement preparedStatement = null;
            PreparedStatement preparedStatement1 = null;
            String query = "INSERT INTO OrderInfo (OrderID,CustomerID,PaymentAmount) VALUES (?,?,?) ";
            String  query1 = "INSERT INTO Customer (CustomerID,Name) VALUES (?, ?) ";

            try {
                System.out.println("Adding data to database");

                preparedStatement = connection.prepareStatement(query);
                preparedStatement1 = connection.prepareStatement(query1);
                preparedStatement.setString(1, orderid);
                preparedStatement.setString(2, customerid);
                preparedStatement.setString(3,"0");
                preparedStatement1.setString(1,customerid);
                preparedStatement1.setString(2, name_txt.getText());

            } catch (SQLException e) {
                System.out.println("e");
            } finally {
                preparedStatement.execute();
                preparedStatement1.execute();
                preparedStatement.close();
                preparedStatement1.close();

            }

            // look in database and get pizza size/pizza topping price and assign that to a value
            PreparedStatement preparedStatement2 =null;
            ResultSet resultSet =null;
            String query3 = "select * from PizzaMenu where Topping = ? and Size = ?";
            try {
                preparedStatement2 =  connection.prepareStatement(query3);
                preparedStatement2.setString(1, topping_cbox.getValue().toString());
                preparedStatement2.setString(2,pizzaSize_cbox.getValue().toString());
                resultSet = preparedStatement2.executeQuery();

                price =resultSet.getString("Price");

                //add price by quantity
                int q=  Integer.valueOf(quantity_txt.getText());
                double p = Double.valueOf(price);
                double amount = p*q;
                Transaction.setCustomerPaymentAmount(amount);
                System.out.println("price: "+ amount);


            }catch (Exception e){
                System.out.println(e);
            } finally {
                preparedStatement2.close();
                resultSet.close();
            }


            // determine saletype and store id accordingly to type in either datdabase: inhouse/takeout/delievery
            if(saleType_cbox.getValue().equals("Delievery")){
                //make random delieveryID
                Delivery delivery = new Delivery();
                delivery.makeTypeID();
                String delieveryid = String.valueOf(delivery.getTypeID());
                System.out.print("delivery ID: "+ delieveryid);
                //assign that to database
            }
            else if(saleType_cbox.getValue().equals("Take Out")){}
            else if(saleType_cbox.getValue().equals("In House")){}

            //pop up message: Customer is added
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Add Customer");
            alert.setContentText("Customer name: "+ Customer.getName() + " with an id of: "+ Customer.getCustomerID()+ " and order id of: "+ OrderInfo.getID()+ " was added");
            alert.showAndWait();

        }
        else if(orderCount>0){
            System.out.println("Only 1 order is allowed");
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please select and enter values");
            alert.showAndWait();
        }


    }

    public void back(ActionEvent event) throws Exception {
        ((Node)event.getSource()).getScene().getWindow().hide();  //hide current window

        Main main = new Main();
        main.createWindow("Main_2.fxml");

    }

    public void next(ActionEvent event) throws Exception {
        Main main = new Main();

        if (saleType_cbox.getValue() != null && pizzaSize_cbox.getValue() != null && topping_cbox.getValue() != null && !quantity_txt.getText().isEmpty() && !name_txt.getText().isEmpty() ) {
            ((Node) event.getSource()).getScene().getWindow().hide();  //hide current window

          if (saleType_cbox.getValue().equals("Delievery")) {
              main.createWindow("Delievery_2_2_1.fxml");
          }
         else if (saleType_cbox.getValue().equals("Take Out")) {
              main.createWindow("Takeout_2_2_2.fxml");
         }
        else if (saleType_cbox.getValue().equals("In House")) {
                main.createWindow("Payment_3.fxml");
          }
        }

     else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please select and enter values");
            alert.showAndWait();
        }
     }

    public void TextFieldKeyType(KeyEvent event){ //use this code to make textbox only accept numbers
     String  c = event.getCharacter();
        char[] s= c.toCharArray();

        if(!Character.isDigit(s[0])){
          event.consume();
        }
    }


}
