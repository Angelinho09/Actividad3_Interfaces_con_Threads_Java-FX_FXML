module com.angeldz.hilo2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.angeldz.hilo2 to javafx.fxml;
    exports com.angeldz.hilo2;
}
