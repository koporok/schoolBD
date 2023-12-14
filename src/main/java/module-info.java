module com.example.school {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.school to javafx.fxml;
    exports com.example.school;
}