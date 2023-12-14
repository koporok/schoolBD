package com.example.school;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javafx.application.Application;
import java.util.Random;

public class AdministratorStudents {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane Student;

    @FXML
    private TextField StudentDate;

    @FXML
    private TextField StudentFIO;

    @FXML
    private TableView<?> StudentTable;

    @FXML
    private TableColumn<?, ?> StudentTableDate;

    @FXML
    private TableColumn<?, ?> StudentTableFIO;

    @FXML
    private TableColumn<?, ?> StudentTableGroup;

    @FXML
    private TableColumn<?, ?> StudentTableId;

    @FXML
    private TableColumn<?, ?> StudentTableLogin;

    @FXML
    private TableColumn<?, ?> StudentTableTelephone;

    @FXML
    private TableColumn<?, ?> StudentTableYear;

    @FXML
    private TextField StudentTelephone;

    @FXML
    private TextField StudentYear;

    @FXML
    private Tab User;

    @FXML
    private TextField UserDate;

    @FXML
    private TextField UserFIO;

    @FXML
    private TextField UserLogin;

    @FXML
    private TableView<?> UserTable;

    @FXML
    private TableColumn<?, ?> UserTableDate;

    @FXML
    private TableColumn<?, ?> UserTableFIO;

    @FXML
    private TableColumn<?, ?> UserTableId;

    @FXML
    private TableColumn<?, ?> UserTableTelephone;

    @FXML
    private TableColumn<?, ?> UserTableYear;

    @FXML
    private TextField UserTelephone;

    @FXML
    private TextField UserYear;

    @FXML
    private AnchorPane addUser;

    @FXML
    private Button createLogin;

    @FXML
    private Button deleteStudent;

    @FXML
    private Button deleteUser;

    @FXML
    private Button editStudent;
    @FXML
    protected void Random(MouseEvent event){}

    @FXML
    void initialize() {
        createLogin.setOnAction(event -> {
            String randomCombination = generateRandomCombination(10);
            UserLogin.setText(randomCombination);
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
