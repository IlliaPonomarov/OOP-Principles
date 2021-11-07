package com.company.Data;
import com.company.People.Customers;
import com.company.People.Person;

import java.util.ArrayList;
import java.sql.*;
import java.io.File;
import java.lang.*;


public class DBHandler {

    private static DBHandler instance;
    Connection connection;
    Statement statement;
    ResultSet resultSet;


    private DBHandler() {
        File path_to_database = new File("src\\com\\company\\Data");
        File path_to_jdbc = new File("lib\\");
        try {

            connection = DriverManager.getConnection("jdbc:sqlite:" + path_to_database + "\\database.db");
            statement = connection.createStatement();
            System.out.println("Connected to SQL.");

        }catch(SQLException throwables){
            throwables.printStackTrace();
            System.out.println("Connection error.");
        }

    }

    public static DBHandler getInstance() throws SQLException {
        if (instance == null)
            instance = new DBHandler();
        return instance;
    }




    //Customers
    public Person getCustomers() throws SQLException{

        Person person;

        String first_name = " ", second_name = " ", mail = " ", street = " ", phone_number = " ", city = " ";
        double money = 0.0;
        int age = 0, apartment = 0;

        ResultSet resultSet = statement.executeQuery("SELECT * FROM Customers");
        while (resultSet.next()){

            first_name = resultSet.getString(2);
            second_name = resultSet.getString(3);
            age = resultSet.getInt(10);
            money = resultSet.getDouble(4);
            phone_number = resultSet.getString(5);
            mail = resultSet.getString(6);
            city = resultSet.getString(7);
            street = resultSet.getString(8);
            apartment = resultSet.getInt(9);
        }



        person = new Customers(first_name, second_name, age, money, phone_number, mail, city, street, apartment);



        return person;
    }

    public Person getManager() throws SQLException{
        Person manager;

        ResultSet resultSet = statement.executeQuery("SELECT * FROM Manager");
        while (resultSet.next()){

        }


        return manager;
    }



}


