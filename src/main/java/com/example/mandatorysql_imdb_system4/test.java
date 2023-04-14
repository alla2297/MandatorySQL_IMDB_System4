package com.example.mandatorysql_imdb_system4;

import com.example.mandatorysql_imdb_system4.Object.Title_basics;
import com.example.mandatorysql_imdb_system4.Object.name_basics;
import com.example.mandatorysql_imdb_system4.Object.title_crew;

import java.io.File;
import java.util.ArrayList;

import static com.example.mandatorysql_imdb_system4.DeleteSQL.PreparedDeleteTitle;
import static com.example.mandatorysql_imdb_system4.PreparedInsert.PreparedInsertInputName;
import static com.example.mandatorysql_imdb_system4.PreparedInsert.PreparedInsertInputTitles;
import static com.example.mandatorysql_imdb_system4.searchSQL.searchName;

public class test  {

    public static void main(String[] args) {
        long Start = System.currentTimeMillis();
        File fTitle = new File("src/main/resources/com/example/mandatorysql_imdb_system4/New Tekstdokument.tsv");
        File fName = new File("src/main/resources/com/example/mandatorysql_imdb_system4/name.tsv");
        File fCrew = new File("src/main/resources/com/example/mandatorysql_imdb_system4/title_crew.tsv");
        //ArrayList<String[]> Data = new ArrayList<>();
        //Data = tsvReader.tsvreader(f);
        ArrayList<Title_basics> DataTitle = new ArrayList<>();
        DataTitle = tsvReader.tsvreaderTitles(fTitle);

        ArrayList<name_basics> DataName = new ArrayList<>();
        DataName = tsvReader.tsvreaderNames(fName);

        ArrayList<title_crew> DataCrew = new ArrayList<>();
        DataCrew = tsvReader.tsvreaderCrew(fCrew);
        System.out.println("hentede data from crew");
        //Data.forEach(array -> System.out.println(Arrays.toString(array)));
        /*for (int i = 0; i <DataTitle.size()&& i< 10 ; i++) {
            System.out.println(i+" "+ Arrays.toString(DataTitle.get(i).getTconst())+"\n");
        }*/
        /*for (int i = 0; i <DataTitle.size()&& i <10; i++){
            System.out.println(i +" "+ DataTitle.get(i).getTconst());
        }*/
        /*for (int i = 0; i <DataName.size()&& i <10; i++){
            System.out.println(i +" "+ DataName.get(i).getNconst());
        }*/
        /*for (int i = 0; i <DataCrew.size()&& i <10; i++){
            System.out.println(i +" "+ DataCrew.get(i).getTconst());
        }*/

        long End = System.currentTimeMillis();
        System.out.println((End-Start) + " Miliseconds");
        System.out.println((End-Start)/1000 + " Seconds");
        System.out.println("SQL insert");
        long StartSQL = System.currentTimeMillis();
        //SQL.SQLConnectionTest();

        //PreparedInsert.PreparedInsertTitles(DataTitle);

        // 81 Seconds{
        //PreparedInsert.PreparedInsertName(DataName);
        //PreparedInsert.PreparedInsertNamePrimaryProfession(DataName);
        //PreparedInsert.PreparedInsertNameKnownForTitles(DataName);
        //}
        // 52 Seconds{
        //PreparedInsert.PreparedInsertCrewDirectors(DataCrew);
        //PreparedInsert.PreparedInsertCrewWriters(DataCrew);
        //}
        //---------searchTitle-----------------------------
        //searchSQL.searchTitle("Carmen");
//        ArrayList<Title_basics> titleSearch = new ArrayList<>();
//        titleSearch= searchSQL.searchTitle("Carmen");
//        //---------searchName-----------------------------
//        ArrayList<name_basics> nameSearch = new ArrayList<>();
//        nameSearch= searchName("Máximo Astray");
//        long EndSQL = System.currentTimeMillis();


        // -----------------------insert one Title----------------------
//        Title_basics test = new Title_basics("2","tvEpisode", "Simon", "Simon", true, "1995", "\\N", "60", "Documentary,Comedy");
//        PreparedInsertInputTitles(test);
        // -----------------------insert one Name--------------------------------------
        /*String[] test3 = {"Programer","WebProgramer"};
        String[] test4 = {"tt0000002","tt0000112","1"};
        name_basics test2 = new name_basics("2", "Monkey",
                "2023","\\N",test3,test4);
        PreparedInsertInputName(test2);
*/
        //-----------------------------------Delete-----------------------------------
    /*    PreparedDeleteTitle("1");
        System.out.println((EndSQL-StartSQL) + " Miliseconds");
        System.out.println((EndSQL-StartSQL)/1000 + " Seconds");
        */
    }
}
