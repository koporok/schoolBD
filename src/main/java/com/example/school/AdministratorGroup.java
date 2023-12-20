package com.example.school;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.example.school.DatabaseHandler;
import com.example.school.TableUsers;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javafx.scene.control.MenuItem;

public class AdministratorGroup {

    @FXML
    private MenuButton trainersMenuButton;

    @FXML
    void MouseCliked(MouseEvent event) {

    }

    @FXML
    void UpdateServiceCoach(MouseEvent event) {

    }

    @FXML
    void initialize() {
        /* DatabaseHandler dbHandler = new DatabaseHandler();

        MenuButton trainersMenuButton = new MenuButton("Выберите тренера");
        List<TableStudentCoachClasses> trainersList = dbHandler.GetAllStudent(); // Предположим, что метод getAllTrainers() возвращает список тренеров
        for (TableStudentCoachClasses trainer : trainersList) {
            MenuItem trainerItem = new MenuItem(trainer.getName());
            trainerItem.setOnAction(e -> {
                TableStudentCoachClasses selectedCoach = CoachFIOe.getSelectionModel().getSelectedItem();
                System.out.println("Выбран тренер: " + selectedCoach.getName());
                // Добавьте здесь логику для работы с выбранным тренером, если необходимо
            });
            trainersMenuButton.getItems().add(trainerItem);
        }*/

    }

}