package com.example.school.window;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.school.DatabaseHandler;
import com.example.school.table.TableCoach;
import com.example.school.table.TableStudentCoachClasses;
import com.example.school.table.TableUsers;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;

public class TableOfCoaches {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<TableCoach, String> FIO;

    @FXML
    private TableView<TableCoach> Table;

    @FXML
    private Button choose;

    @FXML
    void initialize() {
        DatabaseHandler dbHandler = new DatabaseHandler();
        ObservableList<TableCoach> listService = dbHandler.GetAllCoach();
        FIO.setCellValueFactory(new PropertyValueFactory<>("coachFIO"));
        Table.setItems(listService);
    }
}
