package Application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
       createWindow("LoginMain_1.fxml");
    }


    public void createWindow(String name ) throws Exception {
        Stage primaryStage = new Stage();
        FXMLLoader loader= new FXMLLoader();
        Pane root = loader.load(getClass().getResource(name).openStream());
        Scene scene = new Scene(root, 300, 275);
        scene.getStylesheets().add("style.css");
        primaryStage.setTitle("Pizza Shop");
       primaryStage.setScene(scene);


       primaryStage.setMaximized(true);
       // primaryStage.setFullScreen(true);//this crash on mac
        primaryStage.show();



    }

    public static void main(String[] args) {
        launch(args);
    }
}
