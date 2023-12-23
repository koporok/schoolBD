package com.example.school.window;

import com.example.school.DatabaseHandler;
import com.example.school.table.TableCoach;
import com.example.school.table.TableStudents;
import com.example.school.table.TableUsers;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TableOfStudent {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<TableUsers, String> FIO;

    @FXML
    private TableView<TableUsers> Table;

    @FXML
    private Button choose;

    @FXML
    void initialize() {
        DatabaseHandler dbHandler = new DatabaseHandler();
        int grID=1;
        ObservableList<TableUsers> listService = dbHandler.GetAllStudentByGroup(grID);
        FIO.setCellValueFactory(new PropertyValueFactory<>("UsersFIO"));
        Table.setItems(listService);

        choose.setOnAction(event -> {
            TableUsers selectedUser = Table.getSelectionModel().getSelectedItem();

            if (selectedUser != null) {
                int id = selectedUser.getUserId();
                int groupId = AdministratorGroup.selectedGroupId;
                try {
                    dbHandler.UpdatingTheDataStudents(groupId, id);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            } else {
                System.out.println("значит что-то не так с id");
                // Обработка ситуации, когда selectedUser равен null
            }

        });
    }

}
