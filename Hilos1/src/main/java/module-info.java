module com.angeldz.hilos1 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.angeldz.hilos1 to javafx.fxml;
    exports com.angeldz.hilos1;
}
