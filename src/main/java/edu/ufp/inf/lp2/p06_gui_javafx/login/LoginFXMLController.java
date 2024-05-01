package edu.ufp.inf.lp2.p06_gui_javafx.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginFXMLController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Text textActionTarget;

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Aqui você pode adicionar a lógica para autenticar o usuário
        // Por exemplo:
        if ("admin".equals(username) && "admin".equals(password)) {
            textActionTarget.setText("Login successful");
        } else {
            textActionTarget.setText("Login failed");
        }
    }
}
