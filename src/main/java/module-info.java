module com.example.calculatorgui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.calculatorgui to javafx.fxml;
    exports com.example.calculatorgui;
    exports com.example.calculatorgui.controllers;
    opens com.example.calculatorgui.controllers to javafx.fxml;
}