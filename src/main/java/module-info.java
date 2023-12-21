module com.example.school {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;

    opens com.example.school to javafx.fxml;
    exports com.example.school;
    exports com.example.school.table;
    opens com.example.school.table to javafx.fxml;
    exports com.example.school.window;
    opens com.example.school.window to javafx.fxml;
    exports com.example.school.classes;
    opens com.example.school.classes to javafx.fxml;
}