package Application;

import static_class.PizzaMenu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DB_Insert {
   static Connection connection;

    private static void connection( ){
        connection = SqliteConnection.Connector();
        if(connection == null) {
            System.out.println("Connection not successful");
            System.exit(1);
        }
    }

        public static void Takeout(String OrderID, String TypeID, String Box) throws SQLException {
            System.out.println("insert into Takeout database");
            connection();

            PreparedStatement preparedStatement = null;
            String query = "INSERT INTO TakeOut" +
                    " (OrderID,TypeID,Box) " +
                    "VALUES (?,?,?) ";

            try {
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, String.valueOf(OrderID));
                preparedStatement.setString(2, TypeID);
                preparedStatement.setString(3, Box);


            } catch (SQLException e) {
                System.out.println("e");
            } finally {
                preparedStatement.execute();
                preparedStatement.close();
            }
        }
        public static void Delievery(String OrderID, String TypeID, String Address, String City, String State, String ZipCode) throws SQLException {
            System.out.println("insert into Delivery database");
            connection();

            PreparedStatement preparedStatement = null;
            String query = "INSERT INTO Delivery" +
                    " (OrderID,TypeID,Address,City,State,ZipCode) " +
                    "VALUES (?,?,?,?,?,?) ";

            try {
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, String.valueOf(OrderID));
                preparedStatement.setString(2, TypeID);
                preparedStatement.setString(3, Address);
                preparedStatement.setString(4, City);
                preparedStatement.setString(5,State);
                preparedStatement.setString(6,ZipCode);


            } catch (SQLException e) {
                System.out.println("e");
            } finally {
                preparedStatement.execute();
                preparedStatement.close();
            }
        }
        public static void Inhouse(String OrderID, String TypeID) throws SQLException {
            System.out.println("insert into Inhouse database");
            connection();

            PreparedStatement preparedStatement = null;
            String query = "INSERT INTO InHouse" +
                    " (OrderID,TypeID) " +
                    "VALUES (?,?) ";

            try {
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, String.valueOf(OrderID));
                preparedStatement.setString(2, TypeID);

            } catch (SQLException e) {
                System.out.println("e");
            } finally {
                preparedStatement.execute();
                preparedStatement.close();
            }
        }
        public static  void DebitCard(String CardNumber, String NameOnCard, String ExpirationDate,String PIN) throws SQLException {
            System.out.println("insert into DebitCard database");
            connection();

            PreparedStatement preparedStatement = null;
            String query = "INSERT INTO DebitCard" +
                    " (CardNumber,NameOnCard,ExpirationDate,PINNumber) " +
                    "VALUES (?,?,?,?) ";

            try {
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, String.valueOf(CardNumber));
                preparedStatement.setString(2, NameOnCard);
                preparedStatement.setString(3,String.valueOf(ExpirationDate));
                preparedStatement.setString(4, String.valueOf(PIN));


            } catch (SQLException e) {
                System.out.println("e");
            } finally {
                preparedStatement.execute();
                preparedStatement.close();
            }
        }
        public static  void CreditCard(String CardNumber, String CardType, String ExpirationDate,String NameOnCard) throws SQLException {
            System.out.println("insert into CreditCard database");
            connection();

            PreparedStatement preparedStatement = null;
            String query = "INSERT INTO CreditCard" +
                    " (CardNumber,CardType,ExpirationDate,NameOnCard) " +
                    "VALUES (?,?,?,?) ";

            try {
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, String.valueOf(CardNumber));
                preparedStatement.setString(2, CardType);
                preparedStatement.setString(3,String.valueOf(ExpirationDate));
                preparedStatement.setString(4, NameOnCard);


            } catch (SQLException e) {
                System.out.println("e");
            } finally {
                preparedStatement.execute();
                preparedStatement.close();
            }
        }
        public static void OrderInfo (String OrderID, String TypeID, String CustomerID, String MenuID, String PaymentAmount, String PaymentType) throws SQLException {

            System.out.println("insert into orderinfo database");
            connection();

            PreparedStatement preparedStatement = null;
            String query = "INSERT INTO OrderInfo" +
                    " (OrderID,TypeID,CustomerID,MenuID,PaymentAmount,PaymentType) " +
                    "VALUES (?,?,?,?,?,?) ";

            try {
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, OrderID);
                preparedStatement.setString(2, TypeID);
                preparedStatement.setString(3,CustomerID);
                preparedStatement.setString(4, MenuID);
                preparedStatement.setString(5,PaymentAmount);
                preparedStatement.setString(6,PaymentType);


            } catch (SQLException e) {
                System.out.println("e");
            } finally {
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

            try {
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, String.valueOf(CustomerID));
                preparedStatement.setString(2, Name);
                preparedStatement.setString(3,Address);
                preparedStatement.setString(4, Phone);


            } catch (SQLException e) {
                System.out.println("e");
            } finally {
                preparedStatement.execute();
                preparedStatement.close();

            }
        }
}
