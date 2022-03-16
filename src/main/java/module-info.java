module com.example.calculatorgui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.calculatorgui to javafx.fxml;
    exports com.example.calculatorgui;
    exports com.example.calculatorgui.controlers;
    opens com.example.calculatorgui.controlers to javafx.fxml;
}