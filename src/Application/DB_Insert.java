package Application;

import static_class.PizzaMenu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DB_Insert {
   static Connection connection;

    private static void connection( )
    {
        connection = SqliteConnection.Connector();
        if(connection == null)
        {
            System.out.println("Connection not successful");
            System.exit(1);
        }
    }

        public static void OrderInfo (String OrderID, String TypeID, String CustomerID, String MenuID, String PaymentAmount, String PaymentType) throws SQLException
        {

            System.out.println("insert into orderinfo database");
            connection();

            PreparedStatement preparedStatement = null;
            String query = "INSERT INTO OrderInfo" +
                    " (OrderID,TypeID,CustomerID,MenuID,PaymentAmount,PaymentType) " +
                    "VALUES (?,?,?,?,?,?) ";

            try
            {
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, OrderID);
                preparedStatement.setString(2, TypeID);
                preparedStatement.setString(3,CustomerID);
                preparedStatement.setString(4, MenuID);
                preparedStatement.setString(5,PaymentAmount);
                preparedStatement.setString(6,PaymentType);


            } catch (SQLException e)
            {
                System.out.println("e");
            } finally
            {
                preparedStatement.execute();

                preparedStatement.close();

            }
        }
        public static void Customer (String CustomerID, String Name, String Address, String Phone) throws SQLException {
            System.out.println("insert into customer database");
            connection();

            PreparedStatement preparedStatement = null;
            String query = "INSERT INTO Customer" +
                    " (CustomerID,Name,Address,Phone) " +
                    "VALUES (?,?,?,?) ";

            try
            {
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, String.valueOf(CustomerID));
                preparedStatement.setString(2, Name);
                preparedStatement.setString(3,Address);
                preparedStatement.setString(4, Phone);


            } catch (SQLException e)
            {
                System.out.println("e");
            } finally
            {
                preparedStatement.execute();

                preparedStatement.close();

            }
        }
}
