package com.example.school;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Authorization {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button entrance;
    @FXML
    private TextField login;
    @FXML
    private Button supply;
    @FXML
    protected void MouseCliked(MouseEvent event) throws IOException {SceneLoader.loadNewScene("Registration.fxml",supply);}
    @FXML
    void initialize() {
        entrance.setOnAction(event ->{
            String logenText = login.getText().trim();
            if(!logenText.equals("")){
                try {
                    loginUser(logenText);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            else{
                 //рописать ошибку
            }

        });

    }

    private void loginUser(String logenText) throws IOException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        Student student = new Student();
        student.setStudentsLogin(logenText);
        ResultSet result = dbHandler.getUser(student);

        int counter = 0;

        while(true){
            try {if (!result.next()) break;}
            catch (SQLException e) {throw new RuntimeException(e);}
            counter++;
        }
        if (counter>=1){
            if (logenText.equals("admin")) {SceneLoader.loadNewScene("AdministratorStudents.fxml",entrance);}
            else {
                //тут другие виды
            }
        }
        else {
            //шибку прописать надо
        }
    }

}
