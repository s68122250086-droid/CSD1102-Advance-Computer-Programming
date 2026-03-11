package ssru.example1.workfx1;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

public class LoginController {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passField;

    @FXML
    private void handleLogin() {

        String email = emailField.getText();
        String pass = passField.getText();

        System.out.println("Email = " + email);
        System.out.println("Pass = " + pass);

    }
}
