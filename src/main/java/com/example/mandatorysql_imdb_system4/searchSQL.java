package com.example.mandatorysql_imdb_system4;

import java.sql.*;

import com.example.mandatorysql_imdb_system4.Object.Title_basics;


public class searchSQL {
//todo NEED TO RETURN ARRAY
    public static String searchTitle(String a) {
        Connection conn;

        try {
            System.out.println("searchTitle");
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
                    System.out.println("primaryTitles = "+primaryTitle);
                    //TODO INSØRT IN ARRAY OF OBJECT
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
        return "nul";
    }





}
