package com.example.mandatorysql_imdb_system4;


import com.example.mandatorysql_imdb_system4.Object.Title_basics;
import com.example.mandatorysql_imdb_system4.Object.name_basics;
import com.example.mandatorysql_imdb_system4.Object.title_crew;

import java.sql.*;
import java.util.ArrayList;

public class PreparedInsert {




    static void PreparedInsertTitles(ArrayList<Title_basics> Data) {// ARRAY
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;Database=MandatoryAssDB;user=IMDB;password=1234;encrypt=true;trustServerCertificate=true");

            String insertSQL = "INSERT INTO [dbo].[Title] (tconst, primaryTitle, originalTitle, isAdult, startYear, endYear, runTimeMinutes,FK_titleTypeID) VALUES (?, ?, ?, ?, ?, ?, ?,?)";
            PreparedStatement stmt = conn.prepareStatement(insertSQL);


            for (int j = 0; j < Data.size(); j++) {

                String value1 = Data.get(j).getTconst();


                int value8 = Integer.parseInt(searchTitleType(Data.get(j).getTitleType(), conn));


                String value2 = Data.get(j).getPrimaryTitle();
                String value3 = Data.get(j).getOriginalTitle();
                boolean value4 = Data.get(j).getIsAdult();
                String value5 = Data.get(j).getStartYear();
                String value6 = Data.get(j).getEndYear();
                String value7 = Data.get(j).getRuntimeMinutes();

                stmt.setString(1, value1);
                stmt.setString(2, value2);
                stmt.setString(3, value3);
                stmt.setBoolean(4, value4);
                //System.out.println("test "+value5+" , "+value6+" , "+value7);

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
                stmt.setInt(8, value8);

                stmt.executeUpdate();
            }

            stmt.close();
//__________________      TitleGenre ---------------------------------------------------------------
            insertSQL ="INSERT INTO [dbo].[TitleGenre]([FK_titleID],[FK_genreID])VALUES(?,?)";
            PreparedStatement stmtTitleGenre = conn.prepareStatement(insertSQL);
            for (int j = 0; j < Data.size(); j++) {
                String[] genre = Data.get(j).getGenres().split(",");


                String value1 =Data.get(j).getTconst();
                for (int i = 0; i <genre.length ; i++) {
                    int value2 = Integer.parseInt(searchGenre(genre[i], conn));

                    stmtTitleGenre.setString(1, value1);
                    stmtTitleGenre.setInt(2, value2);

                    stmtTitleGenre.executeUpdate();
                }


            }
            stmtTitleGenre.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String searchGenre(String a, Connection conn) {// ARRAY
        String x = null;
        String SearchGenre = "SELECT [genreID] FROM [MandatoryAssDB].[dbo].[Genre] WHERE [genreType] = ?";
        System.out.println("searchGenre string = "+a);
        try {
            PreparedStatement searchstmt = conn.prepareStatement(SearchGenre);
            if (a.equals("\\N")){
                searchstmt.setString(1, "NULL");
            }else {
                searchstmt.setString(1, a);
            }
            ResultSet rs = searchstmt.executeQuery();
            if (rs.next()) {
                x = Integer.toString(rs.getInt("genreID"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("searchGenre done returner = " + x);
        return x;
    }

    private static String searchTitleType(String a, Connection conn) {// ARRAY
        //System.out.println("searchTitleType for " + a);
        String x = null;
        String SearchTitleType = "SELECT [titleID] FROM [MandatoryAssDB].[dbo].[TitleTypes] WHERE [titleType] = ?";
        try {
            PreparedStatement searchstmt = conn.prepareStatement(SearchTitleType);
            searchstmt.setString(1, a);
            ResultSet rs = searchstmt.executeQuery();
            if (rs.next()) {
                x = Integer.toString(rs.getInt("titleID"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //System.out.println("searchTitleType giv " + x);
        return x;
    }


    static void PreparedInsertName(ArrayList<name_basics> Data) { //Insert name.basics dataset // ARRAY
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;Database=MandatoryAssDB;user=IMDB;password=1234;encrypt=true;trustServerCertificate=true");

            String insertSQL = "INSERT INTO [dbo].[Name] (nconst, primaryName, birthYear, deathYear) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(insertSQL);

            for (int j = 0; j < Data.size(); j++) {
                System.out.println(Data.get(j).getPrimaryName());
                String value1 = Data.get(j).getNconst();
                String value2 = Data.get(j).getPrimaryName();
                String value3 = Data.get(j).getBirthYear();
                String value4 = Data.get(j).getDeathYear();

                stmt.setString(1, value1);
                stmt.setString(2, value2);

                if (value3 == null || value3.equals("\\N")) {
                    stmt.setNull(3, Types.INTEGER);
                } else {
                    stmt.setString(3, value3);
                }

                if (value4 == null || value4.equals("\\N")) {
                    stmt.setNull(4, Types.INTEGER);
                } else {
                    stmt.setString(4, value4);
                }

                stmt.executeUpdate();
            }

            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void PreparedInsertNamePrimaryProfession(ArrayList<name_basics> Data) { //Insert name.basics primaryProfession
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;Database=MandatoryAssDB;user=IMDB;password=1234;encrypt=true;trustServerCertificate=true");

            String insertSQL = "INSERT INTO [dbo].[NamePrimaryProfession] (FK_nconst, primaryProfession) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(insertSQL);

                for (int j = 0; j < Data.size(); j++) {
                    String value1 = Data.get(j).getNconst();
                    String[] value2 = Data.get(j).getPrimaryProfession();

                    for (String profession : value2) {
                        stmt.setString(1, value1);
                        stmt.setString(2, profession);
                        stmt.executeUpdate();
                    }
                }

            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void PreparedInsertNameKnownForTitles(ArrayList<name_basics> Data) { //Insert name.basics KnownForTitles
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;Database=MandatoryAssDB;user=IMDB;password=1234;encrypt=true;trustServerCertificate=true");

            String insertSQL = "INSERT INTO [dbo].[NameKnownForTitles] (FK_nconst, knownForTitles) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(insertSQL);

            for (int j = 0; j < Data.size(); j++) {
                String value1 = Data.get(j).getNconst();
                String[] value2 = Data.get(j).getKnownForTitles();

                for (String knownForTitles : value2) {
                    stmt.setString(1, value1);
                    stmt.setString(2, knownForTitles);
                    stmt.executeUpdate();
                }
            }

            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void PreparedInsertCrewWriters(ArrayList<title_crew> Data) {  //Insert crew writers
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;Database=MandatoryAssDB;user=IMDB;password=1234;encrypt=true;trustServerCertificate=true");

            String insertSQL = "INSERT INTO [dbo].[CrewWriters] (FK_tconst, writers) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(insertSQL);

            for (int j = 0; j < Data.size(); j++) {
                String value1 = Data.get(j).getTconst();
                String[] value2 = Data.get(j).getWriters();

                for (String writers : value2) {
                    stmt.setString(1, value1);
                    stmt.setString(2, writers);
                    stmt.executeUpdate();
                }
            }

            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void PreparedInsertCrewDirectors(ArrayList<title_crew> Data) { //Insert crew directors
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;Database=MandatoryAssDB;user=IMDB;password=1234;encrypt=true;trustServerCertificate=true");

            String insertSQL = "INSERT INTO [dbo].[CrewDirectors] (FK_tconst, directors) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(insertSQL);

            for (int j = 0; j < Data.size(); j++) {
                String value1 = Data.get(j).getTconst();
                String[] value2 = Data.get(j).getDirectors();

                for (String directors : value2) {
                    stmt.setString(1, value1);
                    stmt.setString(2, directors);
                    stmt.executeUpdate();
                }
            }

            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//_------------------------------------add one movie----------------------------------
    static void PreparedInsertInputTitles(Title_basics Data) {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;Database=MandatoryAssDB;user=IMDB;password=1234;encrypt=true;trustServerCertificate=true");

            String insertSQL = "INSERT INTO [dbo].[Title] (tconst, primaryTitle, originalTitle, isAdult, startYear, endYear, runTimeMinutes,FK_titleTypeID) VALUES (?, ?, ?, ?, ?, ?, ?,?)";
            PreparedStatement stmt = conn.prepareStatement(insertSQL);

                String value1 = Data.getTconst();

                int value8 = Integer.parseInt(searchTitleType(Data.getTitleType(), conn));

                String value2 = Data.getPrimaryTitle();
                String value3 = Data.getOriginalTitle();
                boolean value4 = Data.getIsAdult();
                String value5 = Data.getStartYear();
                String value6 = Data.getEndYear();
                String value7 = Data.getRuntimeMinutes();

                stmt.setString(1, value1);
                stmt.setString(2, value2);
                stmt.setString(3, value3);
                stmt.setBoolean(4, value4);


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
                stmt.setInt(8, value8);

                stmt.executeUpdate();


            stmt.close();
//__________________      TitleGenre ---------------------------------------------------------------
            insertSQL ="INSERT INTO [dbo].[TitleGenre]([FK_titleID],[FK_genreID])VALUES(?,?)";
            PreparedStatement stmtTitleGenre = conn.prepareStatement(insertSQL);
            System.out.println("before insert genres"+Data.getGenres());
                String[] genre = Data.getGenres().split(",");


                //String value1 =Data.getTconst();
                for (int i = 0; i <genre.length ; i++) {
                    int value2ToInt = Integer.parseInt(searchGenre(genre[i], conn));

                    stmtTitleGenre.setString(1, value1);
                    stmtTitleGenre.setInt(2, value2ToInt);

                    stmtTitleGenre.executeUpdate();
                }



            stmtTitleGenre.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//--------------------------------add Name-----------------------------
    static void PreparedInsertInputName(name_basics Data) { //Insert name.basics dataset // ARRAY
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;Database=MandatoryAssDB;user=IMDB;password=1234;encrypt=true;trustServerCertificate=true");

            String insertSQL = "" +
                    "BEGIN TRANSACTION\n" +
                    "                   INSERT INTO [dbo].[Name]([nconst],[primaryName],[birthYear],[deathYear]) VALUES (?, ?, ?, ?); \n" +
                    "                   INSERT INTO [MandatoryAssDB].[dbo].[NamePrimaryProfession] ([FK_nconst],[primaryProfession]) VALUES (?, ?);\n" +
                    "                   INSERT INTO [MandatoryAssDB].[dbo].[NameKnownForTitles] ([FK_nconst],[knownForTitles]) VALUES (?, ?);\n" +
                    "                   COMMIT TRANSACTION;";
            PreparedStatement stmt = conn.prepareStatement(insertSQL);


                String value1 = Data.getNconst();
                String value2 = Data.getPrimaryName();
                String value3 = Data.getBirthYear();
                String value4 = Data.getDeathYear();
                String[] value5= Data.getPrimaryProfession();
                String[] value6 = Data.getKnownForTitles();

                stmt.setString(1, value1);
                stmt.setString(2, value2);

                if (value3 == null || value3.equals("\\N")) {
                    stmt.setNull(3, Types.INTEGER);
                } else {
                    stmt.setString(3, value3);
                }

                if (value4 == null || value4.equals("\\N")) {
                    stmt.setNull(4, Types.INTEGER);
                } else {
                    stmt.setString(4, value4);
                }

                //todo make it so more primaryProfession and knownForTitles
            for (int i = 0; i <value5.length ; i++) {
                stmt.setString(5,value1);
                stmt.setString(6,value5[i]);
            }
            for (int i = 0; i <value6.length ; i++) {
                stmt.setString(7,value1);
                stmt.setString(8,value6[i]);
            }


            stmt.executeUpdate();

            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}





/*
  String insertSQL = "BEGIN TRANSACTION; " +
                   "INSERT INTO [dbo].[Name]([nconst],[primaryName],[birthYear],[deathYear]) VALUES (?, ?, ?, ?); " +
                   "INSERT INTO [MandatoryAssDB].[dbo].[NamePrimaryProfession] ([FK_nconst],[primaryProfession]) VALUES (?, ?); " +
                   "INSERT INTO [MandatoryAssDB].[dbo].[NameKnownForTitles] ([FK_nconst],[knownForTitles]) VALUES (?, ?); " +
                   "COMMIT TRANSACTION;";
 */
