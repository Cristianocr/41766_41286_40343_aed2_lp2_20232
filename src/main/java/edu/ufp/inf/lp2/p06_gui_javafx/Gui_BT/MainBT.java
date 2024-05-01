package edu.ufp.inf.lp2.p06_gui_javafx.Gui_BT;

import edu.ufp.inf.lp2.p06_gui_javafx.helloword.HelloApplication;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainBT extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        //Parent root = FXMLLoader.load(getClass().getResource("bt.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(MainBT.class.getResource("bt.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        primaryStage.setTitle("Transit Police");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
