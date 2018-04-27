package Application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class DebitCardController {

    @FXML
    private TextField name_txt;
    @FXML
    private TextField number_txt; // only accept number
    @FXML
    private TextField expiration_txt; // only accept number
    @FXML
    private TextField PIN_txt; // only accept number




    public void next(ActionEvent event) throws Exception {
        if (!name_txt.getText().isEmpty() && !number_txt.getText().isEmpty() && !expiration_txt.getText().isEmpty() && !PIN_txt.getText().isEmpty()) {

            //add to database
            DB_Insert.DebitCard(number_txt.getText(),name_txt.getText(),expiration_txt.getText(),PIN_txt.getText());
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
    public void TextFieldCarDebitdNumberType(KeyEvent event){
        String  c = event.getCharacter();
        char[] s= c.toCharArray();

        if(!Character.isDigit(s[0])){
            event.consume();
        }
        if(number_txt.getLength() >=16){
            event.consume();
        }
    }
    public void TextFieldPINType(KeyEvent event){
        String  c = event.getCharacter();
        char[] s= c.toCharArray();

        if(!Character.isDigit(s[0])){
            event.consume();
        }
        if(PIN_txt.getLength() >=4){
            event.consume();
        }
    }
}
