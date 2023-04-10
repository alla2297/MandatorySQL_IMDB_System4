package com.example.mandatorysql_imdb_system4;

import simonstentoft_alla2297.mandatorysql_imdb_system.Object.Title_basics;

import java.sql.*;
import java.util.ArrayList;

public class SQL {
// test to see if I can retrieve data
    static void SQLConnectionTest (){
        Connection connTest;
        try {
            connTest = DriverManager.getConnection("jdbc:sqlserver://localhost;Database=MandatoryAssDB;user=IMDB;password=1234;encrypt=true;trustServerCertificate=true");
            Statement stmt = connTest.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM [dbo].[Title]");
            // test to print out what i have retrieve
            while (rs.next()){
                // i have trim the first column because it is nchar  and it has a fixed-length which annoys me then prints my test
                System.out.println(rs.getString(1).trim()+" , "+
                        rs.getString(2)+" , "+
                        rs.getString(3)+" , "+
                        rs.getString(4)+" , "+
                        rs.getString(5)+" , "+
                        rs.getString(6)+" , "+
                        rs.getString(7)+" , "+
                        rs.getString(8));
                String a = rs.getString(1).trim();

                System.out.println("Hallo("+a+")");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    static ArrayList<Title_basics> SQLConnectionTest2 () {
        Connection connTest;
        ArrayList<Title_basics> Data = new ArrayList<>();
        try {
            connTest = DriverManager.getConnection("jdbc:sqlserver://localhost;Database=MandatoryAssDB;user=<username>;password=<password>;encrypt=true;trustServerCertificate=true");
            Statement stmt = connTest.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM [dbo].[Title]");
            // test to print out what i have retrieve
            while (rs.next()) {
                // i have trim the first column because it is nchar  and it has a fixed-length which annoys me then prints my test
                /*System.out.println(rs.getString(1).trim() + " , " +
                        rs.getString(2) + " , " +
                        rs.getString(3) + " , " +
                        rs.getString(4) + " , " +
                        rs.getString(5) + " , " +
                        rs.getString(6) + " , " +
                        rs.getString(7) + " , " +
                        rs.getString(8));
                String a = rs.getString(1).trim();

                System.out.println("Hallo(" + a + ")");*/
                Title_basics o = new Title_basics(
                        rs.getString(1).trim(),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        Boolean.parseBoolean(rs.getString(5)),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8), "null"
                );
                //System.out.println(o.getisAdult());
                Data.add(o);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Data;
    }

}
