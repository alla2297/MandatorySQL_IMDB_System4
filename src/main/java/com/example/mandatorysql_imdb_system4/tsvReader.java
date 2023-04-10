package com.example.mandatorysql_imdb_system4;

import com.example.mandatorysql_imdb_system4.Object.Title_basics;
import com.example.mandatorysql_imdb_system4.Object.name_basics;
import com.example.mandatorysql_imdb_system4.Object.title_crew;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


public class tsvReader {

//Title_basics------------------------------ insert into at object Array ---------------------------------------------
    public static ArrayList<Title_basics> tsvreaderTitles(File test2) {
        ArrayList<Title_basics> Data = new ArrayList<Title_basics>(); //initializing a new ArrayList out of String[]'s
        try (BufferedReader TSVReader = new BufferedReader(new FileReader(test2))) {
            String line = null;
            TSVReader.readLine().lines().skip(1);
            while ((line = TSVReader.readLine()) != null) {
                try {
                    String[] lineItems = line.split("\t"); //splitting the line and adding its items in String[]
                    //System.out.println("lineItems.toString() = " + Arrays.toString(lineItems));

                    Title_basics o = new Title_basics(lineItems[0],lineItems[1],lineItems[2],lineItems[3],Boolean.parseBoolean(lineItems[4]),lineItems[5], lineItems[6],lineItems[7],lineItems[8]);
                    Data.add(o); //adding the splitted line array to the ArrayList

                    //System.out.println("in while " + line);
                }catch (OutOfMemoryError e){
                    System.out.println(e+"in tsvReader.java line 22");
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
        return Data;
    }
    //name_basics------------------------------ insert into at object Array ---------------------------------------------
    public static ArrayList<name_basics> tsvreaderNames(File test2) {
        ArrayList<name_basics> Data = new ArrayList<name_basics>(); //initializing a new ArrayList out of String[]'s
        try (BufferedReader TSVReader = new BufferedReader(new FileReader(test2))) {
            String line = null;
            TSVReader.readLine().lines().skip(1);
            while ((line = TSVReader.readLine()) != null) {
                try {
                    String[] lineItems = line.split("\t"); //splitting the line and adding its items in String[]
                    //System.out.println("lineItems.toString() = " + Arrays.toString(lineItems));

                    name_basics o = new name_basics(lineItems[0],lineItems[1],lineItems[2],lineItems[3],lineItems[4].split(","),lineItems[5].split(","));
                    Data.add(o); //adding the splitted line array to the ArrayList

                    //System.out.println("in while " + line);
                }catch (OutOfMemoryError e){
                    System.out.println(e+"in tsvReader.java line 22");
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
        return Data;
    }

    //title_crew------------------------------ insert into at object Array ---------------------------------------------
    public static ArrayList<title_crew> tsvreaderCrew(File test2) {
        ArrayList<title_crew> Data = new ArrayList<title_crew>(); //initializing a new ArrayList out of String[]'s
        try (BufferedReader TSVReader = new BufferedReader(new FileReader(test2))) {
            String line = null;
            TSVReader.readLine().lines().skip(1);
            while ((line = TSVReader.readLine()) != null) {
                try {
                    String[] lineItems = line.split("\t"); //splitting the line and adding its items in String[]
                    //System.out.println("lineItems.toString() = " + Arrays.toString(lineItems));

                    title_crew o = new title_crew(lineItems[0],lineItems[1].split(","),lineItems[2].split(","));
                    Data.add(o); //adding the splitted line array to the ArrayList

                    //System.out.println("in while " + line);
                }catch (OutOfMemoryError e){
                    System.out.println(e+"in tsvReader.java line 22");
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
        return Data;
    }


//--------------------------without using object-------------------------------------------------------------
    public static ArrayList<String[]> tsvreader(File test2) {
        ArrayList<String[]> Data = new ArrayList<>(); //initializing a new ArrayList out of String[]'s
        try (BufferedReader TSVReader = new BufferedReader(new FileReader(test2))) {
            //System.out.println("test");
            String line = null;
            //System.out.println("before while " + TSVReader.readLine());
            while ((line = TSVReader.readLine()) != null) {
                try {
                    String[] lineItems = line.split("\t"); //splitting the line and adding its items in String[]
                    Data.add(lineItems); //adding the splitted line array to the ArrayList
                    System.out.println("in while " + line);
                }catch (OutOfMemoryError e){
                    System.out.println(e+"in tsvReader.java line 22");
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
        return Data;
    }





}
/*
 if (lineItems[6].equals("\\N")|| lineItems[7].equals("\\N")){
                        Title_basics o = new Title_basics(lineItems[0],lineItems[1],lineItems[2],lineItems[3],Boolean.parseBoolean(lineItems[4]),Integer.parseInt(lineItems[5]),Integer.parseInt(lineItems[7]),lineItems[8]);
                        Data.add(o); //adding the splitted line array to the ArrayList
                    }else {
                        Title_basics o = new Title_basics(lineItems[0],lineItems[1],lineItems[2],lineItems[3],Boolean.parseBoolean(lineItems[4]),Integer.parseInt(lineItems[5]),Integer.parseInt(lineItems[6]),Integer.parseInt(lineItems[7]),lineItems[8]);
                        Data.add(o); //adding the splitted line array to the ArrayList
                    }
 */