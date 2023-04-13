package com.example.mandatorysql_imdb_system4;

import com.example.mandatorysql_imdb_system4.Object.Title_basics;
import com.example.mandatorysql_imdb_system4.Object.name_basics;
import com.example.mandatorysql_imdb_system4.Object.title_crew;

import java.sql.*;
import java.util.ArrayList;

public class DeleteSQL {

    static void PreparedDeleteTitle(String tconst)  { //Insert crew directors
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;Database=MandatoryAssDB;user=IMDB;password=1234;encrypt=true;trustServerCertificate=true");

            String deleteTitleSQL =
                    "DELETE FROM [MandatoryAssDB].[dbo].[TitleGenre] WHERE [FK_titleID] = ?;";
            PreparedStatement stmtTitle = conn.prepareStatement(deleteTitleSQL);
            String value1 = tconst;

            stmtTitle.setString(1, value1);
            stmtTitle.executeUpdate();
            stmtTitle.close();

//
            deleteTitleSQL = "DELETE FROM [dbo].[Title] WHERE [tconst] = ?;";
            PreparedStatement stmtTitleGenre = conn.prepareStatement(deleteTitleSQL);
            stmtTitleGenre.setString(1, value1);
            stmtTitleGenre.executeUpdate();
            stmtTitleGenre.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
