package ssru.example1.workfx1;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuController {

    private void open(String file, String title) {

        try {

            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource("/" + file)
                    );

            Stage stage = new Stage();

            stage.setScene(
                    new Scene(loader.load(), 400, 250)
            );

            stage.setTitle(title);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void openHello() {
        open("hello.fxml", "Hello");
    }

    public void openLogin() {
        open("login.fxml", "Login");
    }

    public void openCalc() {
        open("calculator.fxml", "Calculator");
    }

}
