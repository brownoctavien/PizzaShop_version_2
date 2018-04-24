package Application;

import javafx.event.ActionEvent;
import javafx.scene.Node;

public class MainController {




    public void goToGenerateReports(ActionEvent event) throws Exception
    {
        ((Node)event.getSource()).getScene().getWindow().hide();  //hide current window

        Main main = new Main();
        main.createWindow("generateReports_2_1.fxml");
    }

    public void goToAssignOrder(ActionEvent event) throws Exception
    {
        ((Node)event.getSource()).getScene().getWindow().hide();  //hide current window

        Main main = new Main();
        main.createWindow("AssignOrder_2_2.fxml");
    }
}
