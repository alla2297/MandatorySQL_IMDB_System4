package com.example.mandatorysql_imdb_system4;

import com.example.mandatorysql_imdb_system4.Object.Title_basics;


import java.sql.*;
import java.util.ArrayList;

public class PreparedInsert {



    static void  PreparedInsertTitles (ArrayList<Title_basics> Data) {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;Database=MandatoryAssDB;user=<username>;password=<password>;encrypt=true;trustServerCertificate=true");

            String insertSQL = "INSERT INTO [dbo].[Title] (tconst, primaryTitle, originalTitle, isAdult, startYear, endYear, runTimeMinutes) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(insertSQL);

            for (int j = 0; j < Data.size(); j++) {

                String value1 = Data.get(j).getTconst();
                String value2 = Data.get(j).getPrimaryTitle();
                String value3 = Data.get(j).getOriginalTitle();
                boolean value4 = Data.get(j).getIsAdult();
                String value5 = Data.get(j).getStartYear();
                String value6 = Data.get(j).getEndYear();
                String value7 = Data.get(j).getRuntimeMinutes();


                stmt.setString(1, value1);
                stmt.setString(2,value2);
                stmt.setString(3,value3);
                stmt.setBoolean(4,value4);
                System.out.println("test "+value5+" , "+value6+" , "+value7);

                if (value5 == null || value5.equals("\\N")) {
                    stmt.setNull(5, Types.INTEGER);
                } else {
                    stmt.setString(5, value5);
                }

                if (value6 == null || value6.equals("\\N")) {
                    stmt.setNull(6, Types.INTEGER);
                } else {
                    stmt.setString(6, value6);
                }

                if (value7 == null || value7.equals("\\N")) {
                    stmt.setNull(7, Types.INTEGER);
                } else {
                    stmt.setString(7, value7);
                }

                stmt.executeUpdate();
            }

            stmt.close();


        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
//------------------------------------- title tables _____________________________
    static void  PreparedInsertAllDataFromTitle_basics (ArrayList<Title_basics> Data) {
        Connection conn;
        try {
            //connection string
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;Database=MandatoryAssDB;user=<username>;password=<password>;encrypt=true;trustServerCertificate=true");
//----------Insert data into Title using a prepared statement
            String insertIntoTableTitle = "INSERT INTO [dbo].[Title] (tconst, primaryTitle, originalTitle, isAdult, startYear, endYear, runTimeMinutes) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement Titlestmt = conn.prepareStatement(insertIntoTableTitle);

//---------- Insert data into TitleTypes using a prepared statement
            String insertIntoTableTitleTypes = "INSERT INTO [dbo].[TitleTypes]([FK_titleID],[FK_genreID])VALUES (?,?)";
            PreparedStatement TitleTypesstmt = conn.prepareStatement(insertIntoTableTitleTypes);

//---------- Insert data into TitleGenre using a prepared statement
            String insertIntoTableTitleGenre = "INSERT INTO [dbo].[TitleGenre]([FK_titleID],[FK_genreID])VALUES(?,?)";
            PreparedStatement TitleGenrestmt = conn.prepareStatement(insertIntoTableTitleGenre);

//---------- Insert data into Genre using a prepared statement
            String insertIntoTableGenre = "INSERT INTO [dbo].[Genre]([genreID],[genreType])VALUES(?,?)";
            PreparedStatement Genrestmt = conn.prepareStatement(insertIntoTableGenre);


            for (int j = 0; j < Data.size(); j++) {

                String value1 = Data.get(j).getTconst();
                String value2 = Data.get(j).getTitleType();
                String value3 = Data.get(j).getPrimaryTitle();
                String value4 = Data.get(j).getOriginalTitle();
                boolean value5 = Data.get(j).getIsAdult();
                String value6 = Data.get(j).getStartYear();// can be null
                String value7 = Data.get(j).getEndYear();// can be null
                String value8 = Data.get(j).getRuntimeMinutes(); // can be null
                String[] value9 = Data.get(j).getGenres().split(",");


//-----------------------set data in column for Title table
                Titlestmt.setString(1,value1);

//-----------------------set data in column for TitleType table
//-----------------------set data in column for TitleGenre table
//-----------------------set data in column for Genre table



            }


        }catch (SQLException e) {
        e.printStackTrace();
        }


    }

}
