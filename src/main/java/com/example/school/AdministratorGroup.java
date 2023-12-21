package com.example.school;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class AdministratorGroup {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AddGroup;

    @FXML
    private Button AddStudent;

    @FXML
    private Button AddTrainer;

    @FXML
    private Button ChooseCoach;

    @FXML
    private Button Coach15;

    @FXML
    private Button Coach16;

    @FXML
    private Button Coach17;

    @FXML
    private Button Coach18;

    @FXML
    private Button Coach19;

    @FXML
    private TextField CoachFIO;

    @FXML
    private TextField CoachSchedule;

    @FXML
    private TableView<?> CoachTable;

    @FXML
    private TableView<?> CoachTable1;

    @FXML
    private Button DeleteGroup;

    @FXML
    private Button EditCoach;

    @FXML
    private TextField Group15;

    @FXML
    private TextField Group16;

    @FXML
    private TextField Group17;

    @FXML
    private TextField Group18;

    @FXML
    private TextField Group19;

    @FXML
    private TextField Сoach;

    @FXML
    private TextField GroupMinAge;

    @FXML
    private TextField GroupNumberStudents;

    @FXML
    private DatePicker LessonDate;

    @FXML
    private AnchorPane Student;

    @FXML
    private TableColumn<?, ?> TableCoachFIO;

    @FXML
    private TableColumn<?, ?> TableGroupName;

    @FXML
    private TableColumn<?, ?> TableStudentName;

    @FXML
    private Tab User;

    @FXML
    private AnchorPane addUser;

    @FXML
    private Button go;

    @FXML
    private TextField GroupMaxAge;

    @FXML
    private Button ob;

    @FXML
    void MouseCliked(MouseEvent event) {

    }

    @FXML
    void UpdateServiceCoach(MouseEvent event) throws IOException {SceneLoader.loadNewScene("Selection.fxml",go);}

    @FXML
    void TableOfCoaches(MouseEvent event) throws IOException {SceneLoader.UploadSecondScene("TableOfCoaches.fxml",AddTrainer);
    }

    @FXML
    void initialize() {AddGroup.setOnAction(event -> {signUpNewUser();});}

    private void signUpNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String FIO = CoachFIO.getText();
        int Number = Integer.parseInt(GroupNumberStudents.getText());
        int MinAge = Integer.parseInt(GroupMinAge.getText());
        int MaxAge = Integer.parseInt(GroupMaxAge.getText());
        String coach = Сoach.getText();


        if (!FIO.equals("")&&!(Number <= 0)&&!(MinAge <= 0)&&!(MaxAge <= 0)&&!coach.equals("")){
            Group group = new Group(FIO,Number,MinAge,MaxAge,coach);
            //dbHandler.signUser(group);


            //прописать ошибку
        }
        // после подачи заявления выходит уведомление и автоматичести переходим

    }


}
