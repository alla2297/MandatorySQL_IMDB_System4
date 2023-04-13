package com.example.mandatorysql_imdb_system4;

import com.example.mandatorysql_imdb_system4.Object.Title_basics;
import com.example.mandatorysql_imdb_system4.Object.name_basics;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.example.mandatorysql_imdb_system4.searchSQL.searchName;
import static com.example.mandatorysql_imdb_system4.searchSQL.searchTitle;

public class SearchNameController implements Initializable {

    ArrayList<name_basics> Data = new ArrayList<>();
    public Stage stage;
    public Scene scene;
    private Parent root;
    @FXML
    private Button Search;

    @FXML
    private Button Back;

    @FXML
    private TableView<name_basics> Table;

    @FXML
    private TableColumn<name_basics, String> birthYear;

    @FXML
    private TableColumn<name_basics, String> deathYear;

    @FXML
    private TableColumn<name_basics, String> knownForTitles;

    @FXML
    private TableColumn<name_basics, String> primaryName;

    @FXML
    private TableColumn<name_basics, String> primaryProfession;

    @FXML
    void Back(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private TextField textFiel;
    ObservableList<name_basics> list = FXCollections.observableArrayList();

    @FXML
    void SearchName(MouseEvent event) {
        ArrayList<name_basics> Data = new ArrayList<>();
        Table.getItems().clear();
        String input = textFiel.getText();
        Data.clear();
        Data= searchName(input);


        
        primaryName.setCellValueFactory(new PropertyValueFactory<>("primaryName"));
        birthYear.setCellValueFactory(new PropertyValueFactory<>("birthYear"));
        deathYear.setCellValueFactory(new PropertyValueFactory<>("deathYear"));
        primaryProfession.setCellValueFactory(cellData -> {
            String[] professions = cellData.getValue().getPrimaryProfession();
            return new SimpleStringProperty(String.join(", ", professions));
        });
        knownForTitles.setCellValueFactory(cellData -> {
            String[] titles = cellData.getValue().getKnownForTitles();
            return new SimpleStringProperty(String.join(", ", titles));
        });
        for (int i = 0; i <Data.size() ; i++) {
            list.add(new name_basics(Data.get(i).getNconst(),
                    Data.get(i).getPrimaryName(),
                    Data.get(i).getBirthYear(),
                    Data.get(i).getDeathYear(),
                    Data.get(i).getPrimaryProfession(),
                    Data.get(i).getKnownForTitles())
            );
        }
        Table.setItems(list);

    }

/*
knownForTitles.setCellValueFactory(cellData -> {
        String[] titles = cellData.getValue().getKnownForTitles();
        return new SimpleStringProperty(String.join(", ", titles));
    });
*/
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}