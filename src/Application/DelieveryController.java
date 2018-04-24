package Application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import static_class.Delivery;
import static_class.OrderInfo;

public class DelieveryController {

    @FXML
    private TextField address1_txt;
    @FXML
    private TextField city_txt;
    @FXML
    private TextField state_txt;
    @FXML
    private TextField zipCode_txt; // only accept number
    @FXML
    private TextField phoneNum_txt;



    public void next(ActionEvent event) throws Exception {

        if(!address1_txt.getText().isEmpty() && !city_txt.getText().isEmpty()&& ! state_txt.getText().isEmpty()&&
                !zipCode_txt.getText().isEmpty() && !phoneNum_txt.getText().isEmpty()){

            DB_Insert.Delievery(OrderInfo.getID(), Delivery.getID(),address1_txt.getText(),city_txt.getText(),state_txt.getText(),zipCode_txt.getText());

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
}
