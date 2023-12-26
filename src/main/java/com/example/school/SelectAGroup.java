package com.example.school;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.school.table.TableGroup;
import com.example.school.window.AdministratorGroup;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SelectAGroup {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<TableGroup, String> FIO;

    @FXML
    private TableView<TableGroup> Table;

    @FXML
    private Button choose;
    public static String nameGroup;
    public static int groupId;

    @FXML
    void initialize() {
        DatabaseHandler dbHandler = new DatabaseHandler();
        ObservableList<TableGroup> listService = dbHandler.GetAllGroups();
        // Привязка полей TableView к свойствам объектов TableUsers
        FIO.setCellValueFactory(new PropertyValueFactory<>("GroupName"));
        Table.setItems(listService);

        choose.setOnAction(event -> {
            TableGroup selectedGroup = Table.getSelectionModel().getSelectedItem();

            if (selectedGroup != null) {
                nameGroup  = selectedGroup.getCoachFIO();
                 groupId = selectedGroup.getGroupId(); // Предположим, что у TableGroup есть метод getId() для получения ID группы
                GroupDatabase.insertGroup(groupId,nameGroup); // Вставка данных о группе
            } else {
                System.out.println("Не выбрана ни одна группа");
                // Обработка ситуации, когда группа не выбрана
            }
        });
    }
}

