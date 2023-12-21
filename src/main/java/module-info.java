module com.example.school {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;

    opens com.example.school to javafx.fxml;
    exports com.example.school;
}