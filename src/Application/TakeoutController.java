package Application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class TakeoutController {


    @FXML
    private TextField numOfBox_txt; // only accept number
    @FXML
    private TextField phoneNumb_txt;// only accept number



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



    public void TextFieldKeyType(KeyEvent event){
        String  c = event.getCharacter();
        char[] s= c.toCharArray();

        if(!Character.isDigit(s[0])){
            event.consume();
        }
    }

    public void TextFieldPhoneType(KeyEvent event){
        String  c = event.getCharacter();
        char[] s= c.toCharArray();

        int count =0;
        String phone = null;

        if(!Character.isDigit(s[0])){
            event.consume();
            count++;
        }
        else{
            phone += c;
        }


        phoneNumb_txt.setText(phone);
    }
}
