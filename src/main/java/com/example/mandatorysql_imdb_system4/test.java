package com.example.mandatorysql_imdb_system4;

import simonstentoft_alla2297.mandatorysql_imdb_system.Object.Title_basics;
import simonstentoft_alla2297.mandatorysql_imdb_system.Object.name_basics;
import simonstentoft_alla2297.mandatorysql_imdb_system.Object.title_crew;

import java.io.File;
import java.util.ArrayList;

public class test  {

    public static void main(String[] args) {
        long Start = System.currentTimeMillis();
        File fTitle = new File("src/main/resources/simonstentoft_alla2297/mandatorysql_imdb_system/test_title_basics.tsv");
        File fName = new File("src/main/resources/simonstentoft_alla2297/mandatorysql_imdb_system/test_name_basics.tsv");
        File fCrew = new File("src/main/resources/simonstentoft_alla2297/mandatorysql_imdb_system/title_crew.tsv");
        /*ArrayList<String[]> Data = new ArrayList<>();
        Data = tsvReader.tsvreader(f);*/
        ArrayList<Title_basics> DataTitle = new ArrayList<>();
        DataTitle = tsvReader.tsvreaderTitles(fTitle);
        ArrayList<name_basics> DataName = new ArrayList<>();
        DataName = tsvReader.tsvreaderNames(fName);
        ArrayList<title_crew> DataCrew = new ArrayList<>();
        DataCrew = tsvReader.tsvreaderCrew(fCrew);

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

        long StartSQL = System.currentTimeMillis();
        SQL.SQLConnectionTest();
        long EndSQL = System.currentTimeMillis();

        System.out.println((EndSQL-StartSQL) + " Miliseconds");
        System.out.println((EndSQL-StartSQL)/1000 + " Seconds");
        //PreparedInsert.PreparedInsertTitles(DataTitle);



    }
}
