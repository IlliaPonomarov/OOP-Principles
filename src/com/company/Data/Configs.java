package com.company.Data;

import java.io.File;

public class Configs {

    //DB Configs
    protected static  File path_to_database = new File("src\\com\\company\\Data");
    private static String url = "jdbc:sqlite:" + path_to_database + "\\database.db";


    public static String getUrl() {
        return url;
    }

    public File getPath_to_database() {
        return path_to_database;
    }
}
