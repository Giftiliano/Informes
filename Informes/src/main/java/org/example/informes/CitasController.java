package org.example.informes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class CitasController {

    @FXML
    private TextField dateField;

    @FXML
    private TextField patientIdField;

    // Método para generar el informe de citas
    @FXML
    public void generateReport() {
        try {
            String date = dateField.getText();
            String idMedico = patientIdField.getText();

            if (date.isEmpty() || idMedico.isEmpty()) {
                System.out.println("Por favor, completa todos los campos.");
                return;
            }

            // Conexión con la base de datos
            Class.forName("org.mariadb.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/hospital", "giftiliano", "giftilian");

            // Parámetros para JasperReports
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("fecha", date);
            parametros.put("idMedico", idMedico);

            // Cargar el archivo del informe desde el classpath
            String reportPath = getClass().getResource("/informes/Citas.jasper").getPath();
            if (reportPath == null) {
                throw new IOException("No se encontró el archivo Citas.jasper");
            }

            // Generar el informe con la conexión a la base de datos
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, parametros, con);

            // Guardar el informe en un archivo PDF
            JasperExportManager.exportReportToPdfFile(jasperPrint, "citas_informe.pdf");

            // Mensaje de confirmación
            System.out.println("¡Informe de citas generado exitosamente!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al generar el informe de citas.");
        }
    }

    @FXML
    public void goBack(ActionEvent event) {
        try {
            // Cargar el archivo FXML de la pantalla principal
            FXMLLoader loader = new FXMLLoader(getClass().getResource("main-view.fxml"));
            Parent root = loader.load();

            // Obtener la ventana actual a través del evento
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Cambiar la escena actual por la nueva
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            System.out.println("Volviendo a la pantalla principal...");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al cargar la pantalla principal.");
        }
    }
}
