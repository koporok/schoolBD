package com.example.school;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
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

    public static void UploadSecondScene(String fxml, Button sene) throws IOException {
        Stage currentStage = (Stage) sene.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(SceneLoader.class.getResource(fxml));
        Parent root = loader.load();

        Stage newStage = new Stage();
        newStage.initModality(Modality.WINDOW_MODAL);
        newStage.initOwner(currentStage); //становить родителя для нового окна (текущееено как родитель)

        newStage.setScene(new Scene(root));
        newStage.show();
    }


}
