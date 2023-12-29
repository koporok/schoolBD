package com.example.school.window;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.example.school.DatabaseHandler;
import com.example.school.GroupDatabase;
import com.example.school.classes.Group;
import com.example.school.SceneLoader;
import com.example.school.table.TableCoach;
import com.example.school.table.TableGroup;
import com.example.school.table.TableStudents;
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
    private Button AddGroup;

    @FXML
    private Button AddStudent;

    @FXML
    private Button AddTrainer;
    @FXML
    private TextField CoachFIO;

    @FXML
    private TableView<TableGroup> CoachTable;

    @FXML
    private TableView<TableUsers> TableStudent;


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
    private TableColumn<TableGroup, String> TableCoachFIO;

    @FXML
    private TableColumn<TableGroup, String> TableGroupName;

    @FXML
    private Button go;

    @FXML
    private Button CreateSchedule;

    @FXML
    private TextField GroupMaxAge;

    @FXML
    private TableColumn<TableGroup, String> NameGroup;

    @FXML
    private TableView<TableGroup> Grou;

    static int selectedGroupId;

    @FXML
    protected void MouseCliked(MouseEvent event) throws IOException {SceneLoader.loadNewScene("Selection.fxml",go);}

    @FXML
    void UpdateServiceCoach(MouseEvent event) throws IOException {SceneLoader.loadNewScene("Selection.fxml",go);}

    @FXML
    void TableOfCoaches(MouseEvent event) throws IOException {SceneLoader.UploadSecondScene("TableOfCoaches.fxml",AddTrainer);}

    @FXML
    void TableOfStudent(MouseEvent event) throws IOException {SceneLoader.UploadSecondScene("TableOfStudent.fxml",AddStudent);}

    @FXML
    protected void UpdatingTheTable(MouseEvent event){clickUpdateServiceGroup();}


    @FXML
    void initialize() throws SQLException {
        clickUpdateService();
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

        CreateSchedule.setOnAction(event -> {
            // Установите обработчик события для элемента DatePicker
            LessonDate.valueProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue != null) {
                    // Продолжайте выполнение кода с выбранной датой newValue
                    System.out.println("Выбранная дата: " + newValue);
                } else {
                    // Обработайте ситуацию, когда выбранная дата равна null
                    System.out.println("Ошибка: Дата не выбрана");
                }
            });


            LocalDate selectedDate = LessonDate.getValue();

            String group15 = Group15.getText();
            String group16 = Group16.getText();
            String group17 = Group17.getText();
            String group18 = Group18.getText();
            String group19 = Group19.getText();

            String group15Id = Check(group15);
            String group16Id = Check(group16);
            String group17Id = Check(group17);
            String group18Id = Check(group18);
            String group19Id = Check(group19);

            System.out.println("1");


            try {
                addSchedule(group15Id, selectedDate, "15.00-15.45");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                addSchedule(group16Id, selectedDate, "16.00-16.45");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                addSchedule(group17Id, selectedDate, "17.00-17.45");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                addSchedule(group18Id, selectedDate, "18.00-18.45");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                addSchedule(group19Id, selectedDate, "19.00-19.45");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Работает ");

        });

    }

    private void addSchedule(String nameGroup, LocalDate date, String time) throws SQLException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        if (nameGroup.equals("Нет группы")) { // Сравниваем строки с помощью метода equals()
            int groupId = 1;
            int coachId = 1;
            System.out.println("2");
            dbHandler.FillingOutTheSchedule(groupId, Date.valueOf(date), time, coachId);
        } else {
            Group group = new Group();
            group.setFIO(nameGroup); // Предполагая, что у вас есть метод setGroupName для установки названия группы

            ResultSet result = dbHandler.getGroup(group);

            if (result.next()) { // Перемещаем указатель на следующую строку, чтобы получить данные из результата
                int groupId = result.getInt("groupid");
                int coachId = result.getInt("coachid");

                System.out.println("3");

                dbHandler.FillingOutTheSchedule(groupId, Date.valueOf(date), time, coachId);
            }
        }
    }

    private String Check(String nameGroup) {
        if (!nameGroup.equals("")) {
            DatabaseHandler dbHandler = new DatabaseHandler();
            Group group = new Group();
            group.setFIO(nameGroup);

            ResultSet result = dbHandler.getGroup(group);

            int counter = 0;

            try {
                while (result.next()) {
                    counter++;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            if (counter >= 1) {
                return nameGroup;
            } else {
                return "Нет группы";
            }
        } else {
            return "Нет группы";
        }
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



    private void clickUpdateService(){
        try {
            // Получение экземпляра DatabaseHandler
            DatabaseHandler dbHandler = new DatabaseHandler();

            ObservableList<TableGroup> listService = dbHandler.GetAllGroups();

            // Привязка полей TableView к свойствам объектов TableUsers
            NameGroup.setCellValueFactory(new PropertyValueFactory<>("GroupName"));

            // Установка данных в TableView
            Grou.setItems(listService);
        } catch (Exception e) {
            e.printStackTrace(); // Обработка исключений
        }
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
    public static void setSelectedGroupId(int groupId) {
        selectedGroupId = groupId;
    }

}
