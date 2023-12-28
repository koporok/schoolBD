package com.example.school;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Authorization.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        stage.setTitle("٩(｡•́‿•̀｡)۶");
        stage.setScene(scene);
        stage.show();
        GroupDatabase.createGroupTable(); // Создание таблицы в базе данных
    }

    public static void main(String[] args) {
        launch();
    }
}