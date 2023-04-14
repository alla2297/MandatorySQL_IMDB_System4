package com.example.mandatorysql_imdb_system4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class StartPageController {


    public Stage stage;
    public Scene scene;
    private Parent root;
    @FXML
    private Button Switch_scenes;

    @FXML
    private Button SearchMovie;

    @FXML
    private Button SearchName;


    @FXML
    private Button deleteMovie;

    @FXML
    private Button insertName;

    @FXML
    private Button insertTitle;



    @FXML
    void Switch_scenes(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ViewTitleTable.fxml"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void Switch_SearchMovie(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("SearchMovie.fxml"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void Switch_SearchName(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("SearchName.fxml"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void Switch_deleteMovie(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("DeleteMovie.fxml"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void Switch_insertName(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("InsertIName.fxml"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void Switch_insertTitle(MouseEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("InsertInputTitles.fxml"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}