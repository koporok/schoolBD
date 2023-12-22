package com.example.school.window;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.school.DatabaseHandler;
import com.example.school.classes.Group;
import com.example.school.SceneLoader;
import com.example.school.table.TableGroup;
import com.example.school.table.TableUsers;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableView<TableGroup> CoachTable;

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
    private TextField coachTextField;

    @FXML
    private TextField GroupMinAge;

    @FXML
    private TextField GroupNumberStudents;

    @FXML
    private DatePicker LessonDate;

    @FXML
    private AnchorPane Student;

    @FXML
    private TableColumn<TableGroup, String> TableCoachFIO;

    @FXML
    private TableColumn<TableGroup, String> TableGroupName;

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
    protected void MouseCliked(MouseEvent event) throws IOException {SceneLoader.loadNewScene("Selection.fxml",go);}

    @FXML
    void UpdateServiceCoach(MouseEvent event) throws IOException {
        SceneLoader.loadNewScene("Selection.fxml",go);}

    @FXML
    void TableOfCoaches(MouseEvent event) throws IOException {SceneLoader.UploadSecondScene("TableOfCoaches.fxml",AddTrainer);
    }

    @FXML
    protected void UpdatingTheTable(MouseEvent event) throws IOException {SceneLoader.loadNewScene("Selection.fxml",go);}

    @FXML
    void initialize() {
        clickUpdateServiceGroup();
        AddGroup.setOnAction(event -> {signUpNewUser();});
    }

    private void signUpNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String FIO = CoachFIO.getText();
        int Number = Integer.parseInt(GroupNumberStudents.getText());
        int MinAge = Integer.parseInt(GroupMinAge.getText());
        int MaxAge = Integer.parseInt(GroupMaxAge.getText());
        String coach = "1";


        if (!FIO.equals("")&&!(Number <= 0)&&!(MinAge <= 0)&&!(MaxAge <= 0)&&!coach.equals("")){
            Group Group = new Group(FIO,Number,MinAge,MaxAge,coach);
            dbHandler.signGroup(Group);

            //прописать ошибку
        }
        // после подачи заявления выходит уведомление и автоматичести переходим

    }

    private void clickUpdateServiceGroup() {
        try {
            // Получение экземпляра DatabaseHandler
            DatabaseHandler dbHandler = new DatabaseHandler();

            // Получение списка пользователей
            ObservableList<TableGroup> listService = dbHandler.GetAllGroups();

            // Привязка полей TableView к свойствам объектов TableUsers
            TableCoachFIO.setCellValueFactory(new PropertyValueFactory<>("GroupName"));
            TableGroupName.setCellValueFactory(new PropertyValueFactory<>("UsersDate"));

            // Установка данных в TableView
            CoachTable.setItems(listService);
        } catch (Exception e) {
            e.printStackTrace(); // Обработка исключений
        }
    }
}
