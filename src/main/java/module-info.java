module com.example.mandatorysql_imdb_system4 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.mandatorysql_imdb_system4 to javafx.fxml;
    exports com.example.mandatorysql_imdb_system4;
}