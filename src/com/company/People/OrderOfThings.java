package com.company.People;

import com.company.Data.DBHandler;
import com.company.Main;
import com.company.Things.Lighting.WallLamps;

import java.sql.SQLException;

public class OrderOfThings {

    private String name;
    private String color;

    private double price;
    private boolean avail_guarantie;
    private boolean presence_bulbs;

    private int avail_warehouse;
    private double height;
    private double width;

    private WallLamps wallLamps;



    public OrderOfThings(String name, double price, boolean avail_guarantie, String color, int avail_warehouse, double height, double width) {
        this.name = name;
        this.price = price;
        this.avail_guarantie = avail_guarantie;
        this.color = color;
        this.avail_warehouse = avail_warehouse;
        this.height = height;
        this.width = width;
    }


    public void addData(String name, double price, boolean avail, String color, int avail_warehouse, double height, double width) throws SQLException {
        DBHandler dbHandler = DBHandler.getInstance();
        dbHandler.insertOrder(name, price, avail_guarantie, color, 1, height, width);
    }




    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvail_guarantie() {
        return avail_guarantie;
    }



    public int getAvail_warehouse() {
        return avail_warehouse;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }
}
