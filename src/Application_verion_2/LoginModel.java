package Application_verion_2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {
    Connection connection;

    public LoginModel(){
        connection = SqliteConnection.Connector();
        if(connection == null) {
            System.out.println("Connection not successful");
            System.exit(1);
        }
    }

    public boolean isDbConnected(){
        try {
           return !connection.isClosed();
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean isLogin(String user, String pass) throws SQLException {
        PreparedStatement preparedStatement =null;
        ResultSet resultSet =null;
        String query = "select * from User where Username = ? and Password = ?";
        try {
            preparedStatement =  connection.prepareStatement(query);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2,pass);

            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }
            else {
                return false;
            }

        }catch (Exception e){
            return false;
        } finally {
            preparedStatement.close();
            resultSet.close();
        }
    }
}
