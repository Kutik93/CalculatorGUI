package com.example.calculatorgui.controlers;

import com.example.calculatorgui.Main;
import com.example.calculatorgui.utils.EvaluateString;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class Controler {

    @FXML
    private Label expression;

    @FXML
    private Label result;

    public void insertNumber(String number) {
        expression.setText(expression.getText() + number);
    }

    public void insertOperator(String operator) {
        expression.setText(expression.getText() + " " + operator + " ");
    }

    public void clearButtom() {
        expression.setText("");
    }

    public Label getExpression() {
        return expression;
    }

    public void setResult(String newResult) {
        this.result.setText("= " + newResult);
    }

    public Label getResult() {
        return result;
    }

    public void insertAnswer(String answer) {
        expression.setText(expression.getText() + answer);
    }

    public void deleteLast() {
        if (!getExpression().getText().isEmpty()) {
            StringBuilder text = new StringBuilder(getExpression().getText());
            text.deleteCharAt(text.length() - 1);
            getExpression().setText(text.toString());
        }
    }

    public void openHistoryWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("history.fxml"));
            Parent root = loader.load();

            Main.getHistoryStage().setScene(new Scene(root));

            Main.getHistoryStage().show();

        } catch (IOException ex) {
            System.out.println(ex);
        }
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
            case "CLEAR":
                clearButtom();
                break;
            case "=":
                int result = EvaluateString.evaluate(this.getExpression().getText());
                setResult(String.valueOf(result));
                break;
            case "ANS":
                insertAnswer(getResult().getText().substring(2));
                break;
            case "DELETE":
                deleteLast();
                break;
            case "History":
                openHistoryWindow();
                break;

        }
    }
}