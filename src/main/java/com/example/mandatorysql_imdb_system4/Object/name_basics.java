package com.example.mandatorysql_imdb_system4.Object;

public class name_basics {
    String nconst;
    String primaryName;
    String birthYear;
    String deathYear;
    String[] primaryProfession;
    String[] knownForTitles;

    public name_basics(String nconst, String primaryName, String birthYear, String deathYear, String[] primaryProfession, String[] knownForTitles) {
        this.nconst = nconst;
        this.primaryName = primaryName;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
        this.primaryProfession = primaryProfession;
        this.knownForTitles = knownForTitles;
    }

    public String getNconst() {
        return nconst;
    }

    public void setNconst(String nconst) {
        this.nconst = nconst;
    }

    public String getPrimaryName() {
        return primaryName;
    }

    public void setPrimaryName(String primaryName) {
        this.primaryName = primaryName;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(String deathYear) {
        this.deathYear = deathYear;
    }

    public String[] getPrimaryProfession() {
        return primaryProfession;
    }

    public void setPrimaryProfession(String[] primaryProfession) {
        this.primaryProfession = primaryProfession;
    }

    public String[] getKnownForTitles() {
        return knownForTitles;
    }

    public void setKnownForTitles(String[] knownForTitles) {
        this.knownForTitles = knownForTitles;
    }
}
