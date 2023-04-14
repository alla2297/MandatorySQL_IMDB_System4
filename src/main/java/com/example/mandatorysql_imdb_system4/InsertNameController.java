package com.example.mandatorysql_imdb_system4;

import com.example.mandatorysql_imdb_system4.Object.Title_basics;
import com.example.mandatorysql_imdb_system4.Object.name_basics;
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
import org.controlsfx.control.CheckComboBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.example.mandatorysql_imdb_system4.PreparedInsert.PreparedInsertInputName;
import static com.example.mandatorysql_imdb_system4.PreparedInsert.PreparedInsertInputTitles;

public class InsertNameController implements Initializable {

    ArrayList<Title_basics> Data = new ArrayList<>();
    public Stage stage;
    public Scene scene;
    private Parent root;

    @FXML
    private Button Back;
    @FXML
    private TableView<?> Table;
    @FXML
    private TableColumn<?, ?> primaryTitle;

    @FXML
    private TableColumn<?, ?> startYear;

    @FXML
    private TableColumn<?, ?> titleType;

    @FXML
    private TableColumn<?, ?> originalTitle;
    @FXML
    private TableColumn<?, ?> isAdult;

    @FXML
    private Button Insert_Movie;


    @FXML
    private TextField nconst;

    @FXML
    private TextField primaryName;

    @FXML
    private TextField birthYear;

    @FXML
    private TextField deathYear;

    @FXML
    private TextField primaryProfession;

    @FXML
    private TextField knownForTitles;

    @FXML
    void Insert_Movie(MouseEvent event) {
        String nconst1 = nconst.getText();
        String primaryName1 = primaryName.getText();
        String birthYear1 = birthYear.getText();
        String deathYear1 = deathYear.getText();
        String[] primaryProfession1 = primaryProfession.getText().split(", ");
        String[] knownForTitles1 = knownForTitles.getText().split(", ");
        name_basics newName = new name_basics(
            nconst1,primaryName1,birthYear1,deathYear1,
                primaryProfession1, knownForTitles1
        );
         String d = String.join(",",newName.getPrimaryProfession());
        String d2 = String.join(",",newName.getKnownForTitles());
        System.out.println(
            newName.getNconst()+", "+newName.getPrimaryName()+", "+newName.getBirthYear()+", "+
            newName.getDeathYear()+", "+ d+", "+d2
        );
        PreparedInsertInputName(newName);
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
    ObservableList<String> genrelist = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}