package com.example.school;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
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
    private Button go;

    @FXML
    void UpdateServiceCoach(MouseEvent event) {clickUpdateServiceCoach();}
    @FXML
    protected void MouseCliked(MouseEvent event) throws IOException {SceneLoader.loadNewScene("Selection.fxml",go);}


    @FXML
    void initialize() {

        CoachAdd.setOnAction(event -> {signUpNewCoach();});

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

}
