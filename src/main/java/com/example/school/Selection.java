package com.example.school;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Selection {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button coaches;

    @FXML
    private Button groups;

    @FXML
    private Button students;

    @FXML
    void initialize() {
        students.setOnAction(event -> {
            try {
                SceneLoader.loadNewScene("AdministratorStudents.fxml",students);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        coaches.setOnAction(event -> {
            try {
                SceneLoader.loadNewScene("AdministratorCoach.fxml",coaches);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        groups.setOnAction(event -> {
            try {
                SceneLoader.loadNewScene("AdministratorGroup.fxml",groups);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
