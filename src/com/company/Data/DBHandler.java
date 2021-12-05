package com.company.Data;
import com.company.People.Cashier;
import com.company.People.Customers;
import com.company.People.Manager;
import com.company.People.Person;
import com.company.Things.Lighting.WallLamps;


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

        try {

            connection = DriverManager.getConnection(Configs.getUrl());
            statement = connection.createStatement();
            System.out.println("Connected to SQL.");

        }catch(SQLException throwables){
            throwables.printStackTrace();
            System.err.println("Connection error.");
        }

    }

    public static DBHandler getInstance() throws SQLException {
        if (instance == null)
            instance = new DBHandler();
        return instance;
    }




    //Customers
    public Person getCustomers() throws SQLException, ClassNotFoundException {

        Person person;

        String first_name = " ", second_name = " ", mail = " ", street = " ", phone_number = " ", city = " ";
        double money = 0.0;
        int age = 0, apartment = 0;



        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + Const.TABLE_NAME_CUSTOMERS);
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


    public Cashier getCashiers()throws SQLException, InterruptedException{
        Cashier cashier;

        String first_name = "", second_name = "";

        ResultSet resultSet = statement.executeQuery("SELECT  * FROM " + Const.TABLE_NAME_CASHIER);

        while (resultSet.next()){
            first_name = resultSet.getString(2);
            second_name = resultSet.getString(3);
        }

        cashier = new Cashier(first_name, second_name);

        return cashier;
    }


    public Person getManager() throws SQLException{
        Person manager;
        String first_n = "", second_n = "";

        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + Const.TABLE_NAME_MANAGER);
        while (resultSet.next()){
           first_n =  resultSet.getString(2);
           second_n = resultSet.getString(3);
        }

        manager = new Manager(first_n, second_n);


        return manager;
    }

    public ArrayList<WallLamps> getWallLamps() throws SQLException{

        ArrayList<WallLamps> wallLamps = new ArrayList<WallLamps>();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + Const.TABLE_NAME_WALL_LAMPS);
      //  ResultSet countOf = statement.executeQuery("SELECT  id FROM WallLamps ORDER BY name DESC ");
        int count = 0, i = 0;




            while (resultSet.next()) {
//                System.out.println(resultSet.getString(2));
//                System.out.println(resultSet.getDouble(3));
//                System.out.println(resultSet.getBoolean(4));
//                System.out.println(resultSet.getBoolean(5));
//                System.out.println(resultSet.getString(6));
//                System.out.println(resultSet.getInt(7));
//                System.out.println(resultSet.getInt(8));
//                System.out.println(resultSet.getInt(9));
                    WallLamps lll = new WallLamps(
                            resultSet.getString(2),
                            resultSet.getDouble(3),
                            resultSet.getBoolean(4),
                            resultSet.getBoolean(5),
                            resultSet.getString(6),
                            resultSet.getInt(7),
                            resultSet.getInt(8),
                            resultSet.getInt(9));
                    wallLamps.add(lll);
            }

//            System.out.println(wallLamps.get(0).toString());
//            System.out.println(wallLamps.get(1).toString());
    return wallLamps;

        }

    public void insertOrder(String name, double price, boolean avail, String color, int avail_warehouse, double height, double width)  throws SQLException{
        int rows = statement.executeUpdate("INSERT INTO 'OrderOfGoods'(name, price, avail_guarantie, color, avail_warehouse, height, width) VALUES (name , price, true, color, avail_warehouse, hright, width);");
    }


    }


