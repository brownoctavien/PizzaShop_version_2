package Application;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqliteConnection {
    public static Connection Connector(){
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/ZachHarrington/Desktop/Database_/Test.sqlite");
            return conn;

        }catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
    }
}
