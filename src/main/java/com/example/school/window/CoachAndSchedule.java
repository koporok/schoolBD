package com.example.school.window;

import com.example.school.DatabaseHandler;
import com.example.school.table.TableStudentSchedule;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class CoachAndSchedule {

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
        String name = "groups.coachid";
        int id = AdministratorCoach.getId_StudentAndSchedule();
        System.out.println("id "+ id);
        ObservableList<TableStudentSchedule> listService = dbHandler.GetStudentSchedule(name, id);
        System.out.println("запрос кинут");
        FIO.setCellValueFactory(new PropertyValueFactory<>("LessonDate"));
        time.setCellValueFactory(new PropertyValueFactory<>("LessonTime"));
        Table.setItems(listService);

    }
}
