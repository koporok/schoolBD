package com.example.school;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class AdministratorCoach {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button CoachAdd;

    @FXML
    private TextField CoachFIO;

    @FXML
    private TableColumn<?, ?> CoachTableFIO;

    @FXML
    private TableColumn<?, ?> CoachTableLogin;

    @FXML
    private TableColumn<?, ?> CoachTableTelephone;

    @FXML
    private TextField CoachTelephone;

    @FXML
    private TextField login;

    @FXML
    private AnchorPane Student;

    @FXML
    private TableView<?> StudentTable;

    @FXML
    private Tab User;

    @FXML
    private AnchorPane addUser;

    @FXML
    private Button deleteCoach;

    @FXML
    private Button editCoach;

    @FXML
    private Button ob;

    @FXML
    private Button createLogin;

    @FXML
    void UpdateServiceCoach(MouseEvent event) {

    }

    @FXML
    void initialize() {
        createLogin.setOnAction(event -> {
            String randomCombination = generateRandomCombination(5);
            login.setText("CreatE"+randomCombination);
        });
    }

    private String generateRandomCombination(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }

}
