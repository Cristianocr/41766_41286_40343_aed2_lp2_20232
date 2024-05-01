package edu.ufp.inf.lp2.p06_gui_javafx.login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginFX extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Carregar o arquivo FXML
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/edu/ufp/inf/lp2/p06_gui_javafx/login/LoginFXMLController.fxml"));
        Parent root = loader.load();

        // Carregar o arquivo CSS
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/edu/ufp/inf/lp2/p06_gui_javafx/login/loginfxml.css").toExternalForm());

        // Configurar o palco
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);

        // Exibir o palco
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
