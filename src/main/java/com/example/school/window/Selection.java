package com.example.school.window;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.school.SceneLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import javax.swing.text.html.ImageView;

public class Selection {
    @FXML
    private Button coaches;

    @FXML
    private Button groups;

    @FXML
    private Button students;
    @FXML
    protected void MouseCliked(MouseEvent event) throws IOException {SceneLoader.loadNewScene("AdministratorGroup.fxml",groups);}


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
    }

}
