package Application_verion_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ConfirmationController implements Initializable{

    @FXML
    private TextField name_txt;
    @FXML
    private TextField amountPaid_txt;
    @FXML
    private TextField pizzaOrder_txt;
    @FXML
    private TextField paymentType_txt;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        name_txt.setText("NONE");
        amountPaid_txt.setText("00000");
        pizzaOrder_txt.setText("NONE");
        paymentType_txt.setText("NONE");
    }


    public void gotoMain(ActionEvent event) throws Exception {
        ((Node)event.getSource()).getScene().getWindow().hide();  //hide current window

        Main main = new Main();
        main.createWindow("Main_2.fxml");
    }


}
