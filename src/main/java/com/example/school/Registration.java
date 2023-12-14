package com.example.school;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Registration {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button Exit;
    @FXML
    private TextField FIO;
    @FXML
    private TextField date;
    @FXML
    private Button give;
    @FXML
    private TextField telephone;
    @FXML
    private TextField year;
    @FXML
    protected void MouseCliked(MouseEvent event) throws IOException {SceneLoader.loadNewScene("Authorization.fxml",Exit);}
    @FXML
    void initialize(){give.setOnAction(event -> {signUpNewUser();});}

    private void signUpNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String StudentsFIO = FIO.getText();
        String StudentsDate = date.getText();
        int StudentsYear = Integer.parseInt(year.getText());
        String StudentsTelephone = telephone.getText();
        String StudentsGroupNumber = "";
        String StudentsLogin = "";

        if (!FIO.equals("")&&!date.equals("")&&!year.equals("")&&!telephone.equals("")){
            Student student = new Student(StudentsFIO,StudentsDate,StudentsYear,StudentsTelephone,StudentsGroupNumber,StudentsLogin);
            dbHandler.signUser(student);


            //прописать ошибку
        }
        // после подачи заявления выходит уведомление и автоматичести переходим

    }

}
