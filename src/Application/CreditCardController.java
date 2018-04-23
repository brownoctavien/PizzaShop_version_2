package Application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class CreditCardController
{

    @FXML
    private TextField name_txt;
    @FXML
    private TextField number_txt; // only accept number
    @FXML
    private TextField expiration_txt; // only accept number
    @FXML
    private ComboBox type_cbox;



    public void next(ActionEvent event) throws Exception
    {
        ((Node)event.getSource()).getScene().getWindow().hide();  //hide current window

        Main main = new Main();
        main.createWindow("Confirmation_4.fxml");
    }
}
