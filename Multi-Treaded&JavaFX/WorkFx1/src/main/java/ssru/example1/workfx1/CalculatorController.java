package ssru.example1.workfx1;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CalculatorController {

    @FXML
    private TextField num1;

    @FXML
    private TextField num2;

    @FXML
    private TextField result;


    private double getA() {
        return Double.parseDouble(num1.getText());
    }

    private double getB() {
        return Double.parseDouble(num2.getText());
    }


    @FXML
    private void add() {
        result.setText("" + (getA() + getB()));
    }

    @FXML
    private void sub() {
        result.setText("" + (getA() - getB()));
    }

    @FXML
    private void mul() {
        result.setText("" + (getA() * getB()));
    }

    @FXML
    private void div() {
        result.setText("" + (getA() / getB()));
    }
}