package com.example.school.window;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;

import com.example.school.classes.Coach;
import com.example.school.DatabaseHandler;
import com.example.school.SceneLoader;
import com.example.school.table.TableCoach;
import com.example.school.table.TableStudents;
import com.example.school.table.TableUsers;
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


import javafx.scene.control.DatePicker;

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
    private TableView<TableCoach> CoachTable;

    @FXML
    private TableColumn<TableCoach, String> CoachTableFIO;

    @FXML
    private TableColumn<TableCoach, String> CoachTableLogin;

    @FXML
    private TableColumn<TableCoach, String> CoachTableTelephone;

    @FXML
    private TextField CoachTelephone;

    @FXML
    private AnchorPane Student;

    @FXML
    private Tab User;

    @FXML
    private Button addGroup;

    @FXML
    private AnchorPane addUser;

    @FXML
    private Button createLogin;

    @FXML
    private DatePicker date;

    @FXML
    private Button deleteCoach;

    @FXML
    private Button editCoach;

    @FXML
    private Button go;

    @FXML
    private TextField group;

    @FXML
    private TextField group15;

    @FXML
    private TextField group16;

    @FXML
    private TextField group17;

    @FXML
    private TextField group18;

    @FXML
    private TextField group19;

    @FXML
    private TextField login;

    @FXML
    private Button ob;
    @FXML
    void UpdateServiceCoach(MouseEvent event) {clickUpdateServiceCoach();}


    @FXML
    protected void MouseCliked(MouseEvent event) throws IOException {
        SceneLoader.loadNewScene("Selection.fxml",go);}


    @FXML
    void initialize() {
        clickUpdateServiceCoach();
        deleteCoach.setOnAction(event -> {
            try {
                deleting();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            CoachFIO.clear();
            CoachTelephone.clear();
            login.clear();

        });
        CoachAdd.setOnAction(event -> {signUpNewCoach();});

        createLogin.setOnAction(event -> {
            String randomCombination = generateRandomCombination(5);
            login.setText("CreatE"+randomCombination);
        });
        CoachTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                TableCoach selectedUser = CoachTable.getSelectionModel().getSelectedItem(); // Получение выбранного пользователя

                CoachFIO.setText(selectedUser.getCoachFIO());
                CoachTelephone.setText(selectedUser.getCoachTelephone());
                login.setText(String.valueOf(selectedUser.getCoachLogin()));
                }
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

    private void signUpNewCoach() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String FIO = CoachFIO.getText();
        String Telephone = CoachTelephone.getText();
        String Login = login.getText();

        if (!FIO.equals("")&&!Telephone.equals("")&&!Login.equals("")){
            Coach coach = new Coach(FIO,Telephone,Login);
            dbHandler.signCoach(coach);


            //прописать ошибку
        }

        // после подачи заявления выходит уведомление и автоматичести переходим

    }
    private void clickUpdateServiceCoach() {
        try {
            DatabaseHandler dbHandler = new DatabaseHandler();

            ObservableList<TableCoach> listCoach = dbHandler.GetAllCoach();

            CoachTableFIO.setCellValueFactory(new PropertyValueFactory<>("CoachFIO"));
            CoachTableTelephone.setCellValueFactory(new PropertyValueFactory<>("CoachTelephone"));
            CoachTableLogin.setCellValueFactory(new PropertyValueFactory<>("CoachLogin"));

            CoachTable.setItems(listCoach);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void deleting() throws SQLException, ClassNotFoundException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        TableCoach selectedStudent = CoachTable.getSelectionModel().getSelectedItem();

        if (selectedStudent != null) {
            String nameTable = "coaches";
            String column ="coachid";
            int id = selectedStudent.getCoachId();
            dbHandler.deletingLine(nameTable,column, id);
        } else {
            System.out.println("значит что-то не так с id");
            // Обработка ситуации, когда selectedUser равен null
        }


    }

}
