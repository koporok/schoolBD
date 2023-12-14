package com.example.school;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneLoader {
    public static void loadNewScene(String fxml, Button sene) throws IOException{
        sene.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader(SceneLoader.class.getResource(fxml));

        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }

}
