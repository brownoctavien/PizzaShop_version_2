package Application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class CreditCardController {

    @FXML
    private TextField name_txt;
    @FXML
    private TextField number_txt; // only accept number
    @FXML
    private TextField expiration_txt; // only accept number
    @FXML
    private ComboBox type_cbox;



    public void next(ActionEvent event) throws Exception {
        if (!name_txt.getText().isEmpty() && !number_txt.getText().isEmpty() && !expiration_txt.getText().isEmpty() && type_cbox.getValue() != null) {

            //add to database
            DB_Insert.CreditCard(number_txt.getText(),type_cbox.getValue().toString(),expiration_txt.getText(),name_txt.getText());

            ((Node) event.getSource()).getScene().getWindow().hide();  //hide current window

            Main main = new Main();
            main.createWindow("Confirmation_4.fxml");
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please enter values");
            alert.showAndWait();
        }
    }

    public void TextFieldCreditCardNumberType(KeyEvent event){
        String  c = event.getCharacter();
        char[] s= c.toCharArray();

        if(!Character.isDigit(s[0])){
            event.consume();
        }
        if(number_txt.getLength() >=16){
            event.consume();
        }
    }
}
