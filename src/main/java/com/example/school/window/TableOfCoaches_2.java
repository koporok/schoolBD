package com.example.school.window;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.school.DatabaseHandler;
import com.example.school.table.TableCoach;
import com.example.school.table.TableStudentCoachClasses;
import com.example.school.table.TableUsers;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

public class TableOfCoaches_2 {
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

    private static String selectedCoachFIO;

    @FXML
    void initialize() {
        DatabaseHandler dbHandler = new DatabaseHandler();
        ObservableList<TableCoach> listService = dbHandler.GetAllCoach();
        FIO.setCellValueFactory(new PropertyValueFactory<>("coachFIO"));
        Table.setItems(listService);

        choose.setOnAction(event -> {
            TableCoach selectedCoach = Table.getSelectionModel().getSelectedItem();

            if (selectedCoach != null) {
                selectedCoachFIO = selectedCoach.getCoachFIO();

                Stage stage = (Stage) choose.getScene().getWindow();
                stage.close();

                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("AdministratorGroup.fxml"));
                    Parent root = loader.load();
                    AdministratorGroup controller = loader.getController();
                    //controller.updateCoachFIO(selectedCoachFIO);

                    Stage adminStage = new Stage();
                    adminStage.setScene(new Scene(root));
                    adminStage.show();
                } catch (IOException e) {
                    e.printStackTrace(); // Обработка ошибки загрузки файла FXML
                }
            } else {
                System.out.println("Что-то не так с id");
                // Обработка ситуации, когда selectedCoach равен null
            }
        });


    }
}
