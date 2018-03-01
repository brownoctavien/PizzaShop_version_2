package Application_verion_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignupController {
    Connection connection;

    public SignupController(){
        connection = SqliteConnection.Connector();
        if(connection == null) {
            System.out.println("Connection not successful");
            System.exit(1);
        }
    }
    @FXML
    private TextField name_txt;
    @FXML
    private TextField password_txt;
    @FXML
    private Label status_lbl;

    public void AddNewUser(ActionEvent event) throws SQLException {

        String user= name_txt.getText();
        String pass= password_txt.getText();

        if(user.isEmpty()){
            status_lbl.setText("Values are empty");
        }
        else {
            //add to database
            PreparedStatement preparedStatement = null;
            String query = "INSERT INTO User (Username, Password) VALUES (?, ?)";
            try {
                System.out.println("Adding data to database");

                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, user);
                preparedStatement.setString(2, pass);

            } catch (SQLException e) {
                System.out.println("e");
            } finally {
                preparedStatement.execute();
                preparedStatement.close();
            }

            //go back to login
            Main main= new Main();
            try {
                ((Node)event.getSource()).getScene().getWindow().hide(); //hide current window

                main.createWindow("LoginMain_1.fxml");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void cancel(ActionEvent event) throws Exception {
        ((Node)event.getSource()).getScene().getWindow().hide(); //hide current window

        //open login  window
        Main main = new Main();
        main.createWindow("LoginMain_1.fxml");
    }


}
