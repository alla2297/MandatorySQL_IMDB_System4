package com.example.mandatorysql_imdb_system4;

import com.example.mandatorysql_imdb_system4.Object.Title_basics;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.example.mandatorysql_imdb_system4.DeleteSQL.PreparedDeleteTitle;


public class deleteTitlesController implements Initializable {

    ArrayList<Title_basics> Data = new ArrayList<>();
    public Stage stage;
    public Scene scene;
    private Parent root;

    @FXML
    private Button Back;


    @FXML
    private TableView<Title_basics> Table;
    @FXML
    private TableColumn<?, ?> tconst_column;

    @FXML
    private TableColumn<Title_basics, String> endYear;

    @FXML
    private TableColumn<Title_basics, String> genres;

    @FXML
    private TableColumn<Title_basics, Boolean> isAdult;

    @FXML
    private TableColumn<Title_basics, String> originalTitle;

    @FXML
    private TableColumn<Title_basics, String> primaryTitle;

    @FXML
    private TableColumn<Title_basics, String> runtimeMinutes;

    @FXML
    private TableColumn<Title_basics, String> startYear;


    @FXML
    private TableColumn<Title_basics, String> titleType;



    @FXML
    private Button delete_title;

    @FXML
    private TextField tconst;


    @FXML
    void delete_title(MouseEvent event)throws IOException {
        String tconst1 = tconst.getText();

        PreparedDeleteTitle(tconst1);
        root = FXMLLoader.load(getClass().getResource("DeleteMovie.fxml"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void Back(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    ObservableList<Title_basics> list = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        Data = SQL.SQLConnectionTest2();
        tconst_column.setCellValueFactory(new PropertyValueFactory<>("tconst"));
        titleType.setCellValueFactory(new PropertyValueFactory<>("titleType"));
        primaryTitle.setCellValueFactory(new PropertyValueFactory<>("primaryTitle"));
        originalTitle.setCellValueFactory(new PropertyValueFactory<>("originalTitle"));
        isAdult.setCellValueFactory(new PropertyValueFactory<>("isAdult"));
        startYear.setCellValueFactory(new PropertyValueFactory<>("startYear"));
        endYear.setCellValueFactory(new PropertyValueFactory<>("endYear"));
        runtimeMinutes.setCellValueFactory(new PropertyValueFactory<>("runtimeMinutes"));
        genres.setCellValueFactory(new PropertyValueFactory<>("genres"));
        for (int i = 0; i <Data.size() ; i++) {
            list.add(new Title_basics(Data.get(i).getTconst(),
                    Data.get(i).getTitleType(),
                    Data.get(i).getPrimaryTitle(),
                    Data.get(i).getOriginalTitle(),
                    Data.get(i).getIsAdult(),
                    Data.get(i).getStartYear(),
                    Data.get(i).getEndYear(),
                    Data.get(i).getRuntimeMinutes(),
                    Data.get(i).getGenres())
            );
        }


        Table.setItems(list);
    }
}