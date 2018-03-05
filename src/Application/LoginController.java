package Application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    public LoginModel loginModel= new LoginModel();

    @FXML
    private Label isConnected;
    @Override
    public void initialize(URL location, ResourceBundle resources){
        if(loginModel.isDbConnected()){
            isConnected.setText("Connected");
        }
        else {
            isConnected.setText("Not Connected");
        }
    }


    @FXML
    private TextField name_txt;
    @FXML
    private PasswordField password_txt;
    @FXML
    private Label status_lbl;
    @FXML


    public void Login(ActionEvent event) throws Exception{
        if(loginModel.isLogin(name_txt.getText(),password_txt.getText() )){
            ((Node)event.getSource()).getScene().getWindow().hide();  //hide current window
            //open MainMenu Window
            Main main = new Main();
            main.createWindow("Main_2.fxml");
        }
        else {

            //login fail
            status_lbl.setText("Username or Password is incorrect");
        }
    }

    public void Signup(ActionEvent event)throws Exception{
        ((Node)event.getSource()).getScene().getWindow().hide(); //hide current window
        //open Signup Window
        Main main = new Main();
        main.createWindow("Signup_1_1.fxml");
    }
}


