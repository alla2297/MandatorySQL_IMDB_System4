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
import org.controlsfx.control.CheckComboBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.example.mandatorysql_imdb_system4.PreparedInsert.PreparedInsertInputTitles;

public class InsertInputTitlesController implements Initializable {

    ArrayList<Title_basics> Data = new ArrayList<>();
    public Stage stage;
    public Scene scene;
    private Parent root;

    @FXML
    private Button Back;


    @FXML
    private TableView<Title_basics> Table;

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
    private Button Insert_Movie;
    @FXML
    private TextField EndYear;

    @FXML
    private TextField OriginalTitle;

    @FXML
    private TextField PrimaryTitle;

    @FXML
    private TextField RuntimeMinutes;

    @FXML
    private TextField StartYear;
    @FXML
    private TextField tconst;
    @FXML
    private ComboBox<Boolean> isAdultDropdown;


    @FXML
    private ComboBox<String> titleTypedropdown;


    @FXML
    private CheckComboBox<String> Genres;

    @FXML
    void Insert_Movie(MouseEvent event) {
       String tc = tconst.getText();
        String tt = String.valueOf(titleTypedropdown.getValue());


        String pt =PrimaryTitle.getText();
        String ot =OriginalTitle.getText();
        ObservableList<Boolean> iAT =isAdultDropdown.getItems();
        String syt =StartYear.getText();
        String eyT =EndYear.getText();
        String rtmT =RuntimeMinutes.getText();
        String gT = String.valueOf(Genres.getCheckModel().getCheckedItems());
        String genre =gT.replace("[", "").replace(", ", ",").replace("]", "");
        System.out.println(gT);
        boolean d  =Boolean.parseBoolean(String.valueOf(iAT));
        Title_basics newTitle = new Title_basics(
                tc,tt,pt,ot,d,syt,eyT,rtmT,genre);
        System.out.println("Title_basics = "+newTitle.getTconst()+", "+newTitle.getTitleType()+", "+newTitle.getPrimaryTitle()+", "+newTitle.getOriginalTitle()+", "+
                newTitle.getIsAdult()+", "+newTitle.getStartYear()+", "+newTitle.getEndYear()+", "+newTitle.getRuntimeMinutes()+", "+newTitle.getGenres()
        );
        PreparedInsertInputTitles(newTitle);



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
        isAdultDropdown.setItems(FXCollections.observableArrayList(true,false));
        titleTypedropdown.setItems(FXCollections.observableArrayList("movie",
                        "short",
                        "tvEpisode",
                        "tvMiniSeries",
                        "tvMovie",
                        "tvPilot",
                        "tvSeries",
                        "tvShort",
                        "tvSpecial",
                        "video",
                        "videoGame")
        );

        genrelist.addAll("genreName",
                "Documentary",
                "Short",
                "Animation",
                "Comedy",
                "Romance",
                "Sport",
                "News",
                "Drama",
                "Fantasy",
                "Horror",
                "Biography",
                "Music",
                "War",
                "Crime",
                "Western",
                "Family",
                "Adventure",
                "Action",
                "History",
                "Mystery",
                "NULL",
                "Sci-Fi",
                "Musical",
                "Thriller",
                "Film-Noir",
                "Talk-Show",
                "Game-Show",
                "Reality-TV",
                "Adult",
                "Experimental");
        Genres.getItems().addAll(genrelist);


        Data = SQL.SQLConnectionTest2();

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