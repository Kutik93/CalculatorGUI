package com.example.calculatorgui.controlers;

import com.example.calculatorgui.utils.EvaluateString;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class Controller {

    @FXML
    private Label expression;

    @FXML
    private Label result;

    public void insertNumber(String number) {
        expression.setText(expression.getText() + number);
    }

    public void insertOperator(String operator){
        expression.setText(expression.getText() + " " + operator + " ");
    }

    public void clearButtom(){
        expression.setText("");
    }

    public Label getExpression(){
        return expression;
    }

    public void setResult(String newResult){
        this.result.setText("= " + newResult);
    }

    public void onMouseClick(MouseEvent mouseEvent) {
        Button button = (Button) mouseEvent.getSource();
        String buttomText = button.getText();

        switch (buttomText) {
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "0":
                insertNumber(buttomText);
                break;
            case "+":
            case "-":
            case "/":
            case "*":
                insertOperator(buttomText);
                break;
            case "CLEAR" :
                clearButtom();
                break;
            case "=" :
                double result = EvaluateString.evaluate(this.getExpression().getText());
                setResult(String.valueOf(result));
                break;

        }
    }
}