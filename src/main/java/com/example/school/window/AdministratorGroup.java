package com.example.school.window;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.school.DatabaseHandler;
import com.example.school.GroupDatabase;
import com.example.school.classes.Group;
import com.example.school.SceneLoader;
import com.example.school.table.TableCoach;
import com.example.school.table.TableGroup;
import com.example.school.table.TableUsers;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.ResultSet;



import javafx.scene.control.TableView;


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
    private static TextField CoachSchedule;

    @FXML
    private TableView<TableGroup> CoachTable;

    @FXML
    private TableView<TableUsers> TableStudent;

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
    private TableColumn<TableUsers, String> TableStudentName;

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
    private TextField GroupNameTextField;


    static int selectedGroupId;

    @FXML
    protected void MouseCliked(MouseEvent event) throws IOException {SceneLoader.loadNewScene("Selection.fxml",go);}

    @FXML
    void UpdateServiceCoach(MouseEvent event) throws IOException {
        SceneLoader.loadNewScene("Selection.fxml",go);}

    @FXML
    void TableOfCoaches(MouseEvent event) throws IOException {SceneLoader.UploadSecondScene("TableOfCoaches.fxml",AddTrainer);
    }

    @FXML
    void TableOfStudent(MouseEvent event) throws IOException {SceneLoader.UploadSecondScene("TableOfStudent.fxml",AddStudent);
    }

    @FXML
    void ChooseCoach(MouseEvent event) throws IOException {
        // Открытие всплывающего окна для выбора тренера
        SceneLoader.UploadSecondScene("TableOfCoaches_2.fxml", ChooseCoach);
    }


    @FXML
    protected void UpdatingTheTable(MouseEvent event){clickUpdateServiceGroup();}

    @FXML
    void initialize() {

        Coach15.setOnAction(event -> {
            // Предположим, у вас уже есть объект ResultSet с полученными данными из базы данных
            String groupNumber = GroupDatabase.selectAllGroups(); // Получение всех данных о группах;


// Далее вы можете использовать полученные данные по своему усмотрению, например, вывести их в консоль
            System.out.println("Group Number: " + groupNumber);

// Или сохранить их в переменные для дальнейшего использования в вашем приложении

        });


        clickUpdateServiceGroup();
        AddGroup.setOnAction(event -> {signUpNewUser();});



        CoachTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                TableGroup selectedUser = CoachTable.getSelectionModel().getSelectedItem(); // Получение выбранного пользователя

                CoachFIO.setText(selectedUser.getGroupName());
                GroupNumberStudents.setText(String.valueOf(selectedUser.getGroupMinAge()));
                GroupMinAge.setText(String.valueOf(selectedUser.getGroupMaxAge()));
                GroupMaxAge.setText(String.valueOf(selectedUser.getGroupNumberStudents()));
                coachTextField.setText(selectedUser.getCoachFIO());

            }
        });

        CoachTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                TableGroup selectedGroup = CoachTable.getSelectionModel().getSelectedItem(); // Получение выбранной группы
                setSelectedGroupId(selectedGroup.getGroupId()); // Установка ID группы в статическую переменную
            }
        });
        clickUpdateStudent();
    }

    private void signUpNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String FIO = CoachFIO.getText();
        int Number = Integer.parseInt(GroupNumberStudents.getText());
        int MinAge = Integer.parseInt(GroupMinAge.getText());
        int MaxAge = Integer.parseInt(GroupMaxAge.getText());
        int coach = 1;


        if (!FIO.equals("")&&!(Number <= 0)&&!(MinAge <= 0)&&!(MaxAge <= 0)){
            Group Group = new Group(FIO, Number, MinAge, MaxAge, coach);
            dbHandler.signGroup(Group);
            //прописать ошибку
        }

        // после подачи заявления выходит уведомление и автоматичести переходим

    }



    private void clickUpdateServiceGroup() {
        try {
            // Получение экземпляра DatabaseHandler
            DatabaseHandler dbHandler = new DatabaseHandler();

            ObservableList<TableGroup> listService = dbHandler.GetAllGroups();

            // Привязка полей TableView к свойствам объектов TableUsers
            TableGroupName.setCellValueFactory(new PropertyValueFactory<>("GroupName"));
            TableCoachFIO.setCellValueFactory(new PropertyValueFactory<>("CoachFIO"));

            // Установка данных в TableView
            CoachTable.setItems(listService);
        } catch (Exception e) {
            e.printStackTrace(); // Обработка исключений
        }
    }

    private void clickUpdateStudent() {
        try {
            // Получение экземпляра DatabaseHandler
            DatabaseHandler dbHandler = new DatabaseHandler();
            int grID = selectedGroupId;

            // Получение списка пользователей
            ObservableList<TableUsers> listService = dbHandler.GetAllStudentByGroup(grID);

            // Привязка полей TableView к свойствам объектов TableUsers
            TableGroupName.setCellValueFactory(new PropertyValueFactory<>("GroupName"));
            TableCoachFIO.setCellValueFactory(new PropertyValueFactory<>("CoachFIO"));

            // Установка данных в TableView
            TableStudent.setItems(listService);
        } catch (Exception e) {
            e.printStackTrace(); // Обработка исключений
        }
    }

    public static void setSelectedGroupId(int groupId) {
        selectedGroupId = groupId;
    }

}
