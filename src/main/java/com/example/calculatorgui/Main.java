package com.example.calculatorgui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static Stage historyStage = null;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("calculator.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), -1, -1, true, SceneAntialiasing.BALANCED);
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();

        createHistoryStage();
    }

    public void createHistoryStage() {
        historyStage = new Stage();
        historyStage.setTitle("Calculation History");
        historyStage.setAlwaysOnTop(true);
        historyStage.setResizable(false);
        historyStage.initModality(Modality.APPLICATION_MODAL);
    }

    public static Stage getHistoryStage() {
        return historyStage;
    }

    public static void main(String[] args) {
        launch();
    }
}