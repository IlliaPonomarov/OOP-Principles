package com.company.Things.Bathroom.FurnitureBR;

import com.company.Things.Fourniture;
import sun.net.www.protocol.file.FileURLConnection;

public class FloorStand extends Fourniture {

    private String name;
    private String color;
    private int height;
    private int width;

    public FloorStand(){}

    public FloorStand(String name, double price, boolean avail_guarantie, boolean presence_legs, String color, int avail_warehouse, int height, int width){
        this.name = name;
        this.setPrice(price);
        this.setAvailabilityOfGuarantee(avail_guarantie);
        this.setPresenceOfLegs(presence_legs);
        this.color = color;
        this.setAvail_in_warehouse(avail_warehouse);
        this.height = height;
        this.width = width;

    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public int getAvail_in_warehouse() {
        return super.getAvail_in_warehouse();
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean isAvailabilityOfGuarantee() {
        return super.isAvailabilityOfGuarantee();
    }

    @Override
    public boolean isPresenceOfLegs(){
        return super.isPresenceOfLegs();
    }


    public String getColor() {
        return color;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public String toString() {
        return "WallLamps{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}
