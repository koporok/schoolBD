package com.example.school.window;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

import com.example.school.DatabaseHandler;
import com.example.school.table.TableCoach;
import com.example.school.table.TableStudentSchedule;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class StudentAndSchedule {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker Date;

    @FXML
    private TableColumn<TableStudentSchedule, java.util.Date> FIO;

    @FXML
    private TableView<TableStudentSchedule> Table;

    @FXML
    private TableColumn<TableStudentSchedule, String> time;

    @FXML
    void initialize() {
        DatabaseHandler dbHandler = new DatabaseHandler();
        System.out.println("1");
        String name = "groups.groupid";
        int id = AdministratorStudents.getId_StudentAndSchedule();
        System.out.println("id "+ id);
        ObservableList<TableStudentSchedule> listService = dbHandler.GetStudentSchedule(name, id);
        System.out.println("запрос кинут");
        FIO.setCellValueFactory(new PropertyValueFactory<>("LessonDate"));
        time.setCellValueFactory(new PropertyValueFactory<>("LessonTime"));
        Table.setItems(listService);

    }


}
