package Application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class generateReportsController implements Initializable{

   static private int InhouseCount=0;
    static private int DelieveryCount=0;
    static private int TakeoutCount=0;

    Connection connection;

    public generateReportsController(){
        connection = SqliteConnection.Connector();
        if(connection == null) {
            System.out.println("Connection not successful");
            System.exit(1);
        }
    }




    @FXML
    private Button btn_generate;
    @FXML
    private PieChart pieChart;

    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("In House", 0),
                new PieChart.Data("Take Out",0),
                new PieChart.Data("Delievery", 0));

        pieChart.setData(pieChartData);

    }

    public void back(ActionEvent event) throws Exception {
        ((Node)event.getSource()).getScene().getWindow().hide();  //hide current window

        Main main = new Main();
        main.createWindow("Main_2.fxml");

    }


        /* look in OrderInfo database, the field TypeID and see which order type: H,D,T */


        /* add that that to a type counter: countH,countD,countT*/



    public void generatePie() throws SQLException {
        PreparedStatement preparedStatement =null;
        ResultSet resultSet =null;
        String query = "select * from OrderInfo ";
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                System.out.println("Order: "+ resultSet.getString("TypeID"));
                getCount(resultSet.getString("TypeID"));
            }
            System.out.println("Deilver: "+ getDelieveryCount());
            System.out.println("InHouse: "+ getInHouseCount());
            System.out.println("take out: "+ getTakeoutCost());

            ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                    new PieChart.Data("In House", getInHouseCount()),
                    new PieChart.Data("Take Out",getTakeoutCost()),
                    new PieChart.Data("Delievery", getDelieveryCount()));
            pieChart.setData(pieChartData);



        }catch (SQLException e) {
            System.out.println(e);
        }finally {
            preparedStatement.execute();
            preparedStatement.close();
            resultSet.close();
        }

    }

    public static void getCount(String TypeID){
        String Type = TypeID.substring(0,1);
        System.out.println("Type: "+ Type);

        if(Type.equals("D")){
            DelieveryCount++;
        }
        else if(Type.equals("H")){
            InhouseCount++;
        }
        else if(Type.equals("T")){
            TakeoutCount++;
        }

    }
    public static int getInHouseCount(){
        return InhouseCount;
    }
    public static int getDelieveryCount(){
        return DelieveryCount;
    }
    public static int getTakeoutCost(){
        return TakeoutCount;
    }

    public static void setInHouseCount(int Count){
        InhouseCount = Count;
    }
    public static void settDelieveryCount(int Count){
        DelieveryCount = Count;
    }
    public void setTakeoutCount(int Count){
        TakeoutCount = Count;
    }


}
