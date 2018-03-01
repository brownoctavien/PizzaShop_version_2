package Application_verion_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;

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
        ((Node)event.getSource()).getScene().getWindow().hide();  //hide current window

        Main main = new Main();
        main.createWindow("Payment_3.fxml");
    }

    public void back(ActionEvent event) throws Exception {
        ((Node)event.getSource()).getScene().getWindow().hide();  //hide current window

        Main main = new Main();
        main.createWindow("AssignOrder_2_2.fxml");
    }
}
