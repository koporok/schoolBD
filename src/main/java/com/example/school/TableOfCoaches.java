package com.example.school;

import java.beans.EventHandler;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class TableOfCoaches {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<TableStudentCoachClasses, String> FIO;

    @FXML
    private TableView<TableStudentCoachClasses> Table;

    @FXML
    private Button choose;

    @FXML
    void initialize() {
        DatabaseHandler dbHandler = new DatabaseHandler();
        ObservableList<TableStudentCoachClasses> listService = dbHandler.GetAllStudent();
        FIO.setCellValueFactory(new PropertyValueFactory<>("CoachFIO"));
        Table.setItems(listService);
    }


}
