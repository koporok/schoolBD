package com.example.school.window;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.school.DatabaseHandler;
import com.example.school.SceneLoader;
import com.example.school.classes.Student;
import javafx.fxml.FXML;
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
    protected void MouseCliked(MouseEvent event) throws IOException {
        SceneLoader.loadNewScene("Authorization.fxml",Exit);}
    @FXML
    void initialize(){give.setOnAction(event -> {signUpNewUser();});}

    private void signUpNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String StudentsFIO = FIO.getText();
        String StudentsDate = date.getText();
        int StudentsYear = Integer.parseInt(year.getText());
        String StudentsTelephone = telephone.getText();
        int IDgroups = 1;
        String StudentsLogin = "null";

        if (!FIO.equals("") && !date.equals("") && !year.equals("") && !telephone.equals("")) {
            Student student = new Student(StudentsFIO, StudentsDate, StudentsYear, StudentsTelephone, IDgroups, StudentsLogin);
            dbHandler.signUser(student);

            // После ввода информации очистить текстовые поля
            FIO.clear();
            date.clear();
            year.clear();
            telephone.clear();

            // Прописать дополнительную логику или уведомление здесь
        }
        // после подачи заявления выходит уведомление и автоматичести переходим
    }

}
