package com.company.People;

import com.company.Things.Lighting.WallLamps;

public class OrderOfThings {

    private String name;
    private String color;

    private double price;
    private boolean avail_guarantie;
    private boolean presence_bulbs;

    private int avail_warehouse;
    private int height;
    private int width;

    private WallLamps wallLamps;


    public OrderOfThings(String name, double price, boolean avail_guarantie, String color, int avail_warehouse, int height, int width) {
        this.name = name;
        this.price = price;
        this.avail_guarantie = avail_guarantie;
        this.color = color;
        this.avail_warehouse = avail_warehouse;
        this.height = height;
        this.width = width;
    }

    public OrderOfThings(WallLamps wallLamps){
        this.wallLamps = wallLamps;
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

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
