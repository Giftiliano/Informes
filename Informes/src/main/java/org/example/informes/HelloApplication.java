package org.example.informes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("main-view.fxml"));
        primaryStage.setTitle("Gestión de Informes");
        primaryStage.setScene(new Scene(root, 450, 350));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
