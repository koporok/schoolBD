package com.example.school;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableView<TableUsers> StudentTable;

    @FXML
    private TableColumn<TableUsers, String> StudentTableDate;

    @FXML
    private TableColumn<TableUsers, String> StudentTableFIO;

    @FXML
    private TableColumn<TableUsers, String> StudentTableGroup;

    @FXML
    private TableColumn<TableUsers, String> StudentTableLogin;

    @FXML
    private TableColumn<TableUsers, String> StudentTableTelephone;

    @FXML
    private TableColumn<TableUsers, Integer> StudentTableYear;

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
    private TableView<TableUsers> UserTable;

    @FXML
    private TableColumn<TableUsers, String> UserTableDate;

    @FXML
    private TableColumn<TableUsers, String> UserTableFIO;

    @FXML
    private TableColumn<TableUsers, String> UserTableTelephone;

    @FXML
    private TableColumn<TableUsers, Integer> UserTableYear;

    @FXML
    private TextField UserTelephone;

    @FXML
    private TextField UserYear;

    @FXML
    private AnchorPane addUser;

    @FXML
    private Button createLogin;

    @FXML
    private Button addStudent;

    @FXML
    private Button deleteStudent;

    @FXML
    private Button deleteUser;

    @FXML
    private Button editStudent;
    @FXML
    protected void UpdateServiceUser(MouseEvent event){clickUpdateServiceUser();}
    @FXML
    protected void UpdateServiceStudent(MouseEvent event){clickUpdateServiceStudent();}

    @FXML
    void initialize() {
        addStudent.setOnAction(event -> {
            try {
                addS();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        deleteUser.setOnAction(event -> {
            try {
                deleting();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        createLogin.setOnAction(event -> {
            String randomCombination = generateRandomCombination(10);
            UserLogin.setText(randomCombination);
        });
        // Добавление слушателя событий к таблице
        UserTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                TableUsers selectedUser = UserTable.getSelectionModel().getSelectedItem(); // Получение выбранного пользователя

                UserFIO.setText(selectedUser.getUsersFIO());
                UserDate.setText(selectedUser.getUsersDate());
                UserYear.setText(String.valueOf(selectedUser.getUsersYear()));
                UserTelephone.setText(selectedUser.getUsersTelephone());
            }
        });
        StudentTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                TableUsers selectedUser = StudentTable.getSelectionModel().getSelectedItem(); // Получение выбранного пользователя

                StudentFIO.setText(selectedUser.getUsersFIO());
                StudentDate.setText(selectedUser.getUsersDate());
                StudentYear.setText(String.valueOf(selectedUser.getUsersYear()));
                StudentTelephone.setText(selectedUser.getUsersTelephone());
            }
        });



    }

    private void deleting() throws SQLException, ClassNotFoundException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        TableUsers selectedUser = UserTable.getSelectionModel().getSelectedItem();

        if (selectedUser != null) {
            int id = selectedUser.getUserId();
            String login = UserLogin.getText();
            dbHandler.deletingLine(id);
        } else {
            System.out.println("значит что-то не так с id");
            // Обработка ситуации, когда selectedUser равен null
        }


    }

    private void addS() throws SQLException {
        DatabaseHandler dbHandler = new DatabaseHandler();

        TableUsers selectedUser = UserTable.getSelectionModel().getSelectedItem();

        if (selectedUser != null) {
            int id = selectedUser.getUserId();
            String login = UserLogin.getText();

            if (!login.equals("")) {
                dbHandler.addStudent(login, id);
            } else {
                // Обработка ситуации, когда login пустой
            }
        } else {
            System.out.println("значит что-то не так с id");
            // Обработка ситуации, когда selectedUser равен null
        }
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

    // Метод обновления информации о пользователях
    private void clickUpdateServiceUser() {
        try {
            // Получение экземпляра DatabaseHandler
            DatabaseHandler dbHandler = new DatabaseHandler();

            // Получение списка пользователей
            ObservableList<TableUsers> listService = dbHandler.GetAllUsers();

            // Привязка полей TableView к свойствам объектов TableUsers
            UserTableFIO.setCellValueFactory(new PropertyValueFactory<>("UsersFIO"));
            UserTableDate.setCellValueFactory(new PropertyValueFactory<>("UsersDate"));
            UserTableYear.setCellValueFactory(new PropertyValueFactory<>("UsersYear"));
            UserTableTelephone.setCellValueFactory(new PropertyValueFactory<>("UsersTelephone"));


            // Установка данных в TableView
            UserTable.setItems(listService);
        } catch (Exception e) {
            e.printStackTrace(); // Обработка исключений
        }
    }


    private void clickUpdateServiceStudent() {
        try {
            // Получение экземпляра DatabaseHandler
            DatabaseHandler dbHandler = new DatabaseHandler();

            // Получение списка пользователей
            ObservableList<TableUsers> listService = dbHandler.GetAllStudent();

            // Привязка полей TableView к свойствам объектов TableUsers
            StudentTableFIO.setCellValueFactory(new PropertyValueFactory<>("UsersFIO"));
            StudentTableDate.setCellValueFactory(new PropertyValueFactory<>("UsersDate"));
            StudentTableYear.setCellValueFactory(new PropertyValueFactory<>("UsersYear"));
            StudentTableTelephone.setCellValueFactory(new PropertyValueFactory<>("UsersTelephone"));
            StudentTableGroup.setCellValueFactory(new PropertyValueFactory<>("StudentsGroupNumber"));
            StudentTableLogin.setCellValueFactory(new PropertyValueFactory<>("StudentsLogin"));


            // Установка данных в TableView
            StudentTable.setItems(listService);
        } catch (Exception e) {
            e.printStackTrace(); // Обработка исключений
        }
    }


}
