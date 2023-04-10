package com.example.mandatorysql_imdb_system4;


import com.example.mandatorysql_imdb_system4.Object.Title_basics;

import java.sql.*;
import java.util.ArrayList;

public class NormalInserter {

    static void  InsertTitles (ArrayList<Title_basics> Data) {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;Database=MandatoryAssDB;user=IMDB;password=1234;encrypt=true;trustServerCertificate=true");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("INSERT INTO [dbo].[Title]\n" +
                    "([tconst]\n" +
                    ",[FK_titleTypeID]\n" +
                    ",[primaryTitle]\n" +
                    ",[originalTitle]\n" +
                    ",[isAdult]\n" +
                    ",[startYear]\n" +
                    ",[endYear]\n" +
                    ",[runTimeMinutes]) "+
                    "Values ("+ Data.get(1));



        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
