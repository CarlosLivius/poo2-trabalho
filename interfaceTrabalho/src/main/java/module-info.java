module com.example.interfacetrabalho {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.interfacetrabalho to javafx.fxml;
    exports com.example.interfacetrabalho;
}