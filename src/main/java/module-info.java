module com.example.mandatorysql_imdb_system4 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires org.controlsfx.controls;

    opens com.example.mandatorysql_imdb_system4 to javafx.fxml;
    exports com.example.mandatorysql_imdb_system4;
    exports com.example.mandatorysql_imdb_system4.Object;
    opens com.example.mandatorysql_imdb_system4.Object to javafx.fxml;
}