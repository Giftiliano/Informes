package org.example.informes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    private Stage stage;
    private Scene scene;

    // Método para ir a la pantalla de "Generar Citas"
    @FXML
    public void goToCitas(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("citas-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Generar Citas");
        stage.show();
    }

    // Método para ir a la pantalla de "Historial Médico"
    @FXML
    public void goToHistorial(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("historial-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Historial Médico");
        stage.show();
    }
}
