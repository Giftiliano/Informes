module org.example.informes {
    requires javafx.controls;
    requires javafx.fxml;
    requires jasperreports;
    requires java.desktop;
    requires org.mariadb.jdbc;


    opens org.example.informes to javafx.fxml;
    exports org.example.informes;
}