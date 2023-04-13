package com.example.mandatorysql_imdb_system4;

import java.sql.*;
import java.util.ArrayList;

import com.example.mandatorysql_imdb_system4.Object.Title_basics;
import com.example.mandatorysql_imdb_system4.Object.name_basics;

//todo SearchName metode
public class searchSQL {

    public static ArrayList<Title_basics> searchTitle(String a) {
        Connection conn;
        ArrayList<Title_basics> titleSearch = new ArrayList<>();

        try {
            System.out.println("searchTitle =" + a);
            // Connect to the database
            conn = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost;Database=MandatoryAssDB;user=IMDB;password=1234;encrypt=true;trustServerCertificate=true");

            // Prepare the stored procedure call
            CallableStatement stmtSearchTitle = conn.prepareCall("EXEC SearchMovieByTitle ?");

            stmtSearchTitle.setString(1, a); // Set the input parameter value

            // Execute the stored procedure
            //ResultSet rs = stmtSearchTitle.executeQuery();
            boolean hasResult = stmtSearchTitle.execute();
            System.out.println("hasResult = "+hasResult);
            if (hasResult) {
                ResultSet rs = stmtSearchTitle.getResultSet();

                while (rs.next()) {
                    // Process the result set
                    //todo GET COLUMN DATA
                    String primaryTitle = rs.getString("primaryTitle");
                    String originalTitle = rs.getString("originalTitle");
                    boolean isAdult  = rs.getBoolean("isAdult");
                    String startYear = rs.getString("startYear");
                    String endYear = rs.getString("endYear");
                    String runTimeMinutes = rs.getString("runTimeMinutes");
                    String titleType = rs.getString("titleType");
                    String genreTypes = rs.getString("genreTypes");

                    Title_basics d = new Title_basics("Null",titleType,primaryTitle,originalTitle,isAdult,startYear,endYear,runTimeMinutes,genreTypes);
                    titleSearch.add(d);

                }
            }

            // Iterate through the result set and display the results
            /*while (rs.next()) {
                System.out.println(rs.getString("MovieTitle = "));
            }*/

            // Close the database connection
            stmtSearchTitle.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //todo RETURN ARRAY
        return titleSearch;
    }


    public static ArrayList<name_basics> searchName(String a) {
        Connection conn;
        ArrayList<name_basics> titleSearch = new ArrayList<>();

        try {
            System.out.println("searchName =" + a);
            // Connect to the database
            conn = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost;Database=MandatoryAssDB;user=IMDB;password=1234;encrypt=true;trustServerCertificate=true");

            // Prepare the stored procedure call
            CallableStatement stmtSearchName = conn.prepareCall("EXEC [dbo].[SearchName] ?");

            stmtSearchName.setString(1, a); // Set the input parameter value

            // Execute the stored procedure
            //ResultSet rs = stmtSearchTitle.executeQuery();
            boolean hasResult = stmtSearchName.execute();
            System.out.println("hasResult = "+hasResult);
            if (hasResult) {
                ResultSet rs = stmtSearchName.getResultSet();

                while (rs.next()) {
                    // Process the result set
                    //todo GET COLUMN DATA
                    String primaryName = rs.getString("primaryName");
                    String birthYear = rs.getString("birthYear");
                    String deathYear = rs.getString("deathYear");
                    String[] primaryProfession = rs.getString("primaryProfession").split(", ");
                    String[] knownForTitles = rs.getString("knownForTitles").split(", ");



                    name_basics d = new name_basics("Null",primaryName,birthYear,deathYear,primaryProfession,knownForTitles);
                    titleSearch.add(d);
                }
            }

            // Iterate through the result set and display the results
            /*while (rs.next()) {
                System.out.println(rs.getString("MovieTitle = "));
            }*/

            // Close the database connection
            stmtSearchName.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Search a Name size = "+titleSearch.size());
        //todo RETURN ARRAY
        return titleSearch;
    }





}
