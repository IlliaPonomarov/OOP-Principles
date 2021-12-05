package com.company.Things.Lighting;

public class LampShades extends Lighting{

    String name;
    String color;
    int height;
    int width;

    public LampShades(){}

    public LampShades(String name, double price, boolean avail_guarantie, boolean presence_bulbs, String color, int avail_warehouse, int height, int width){
        this.name = name;
        this.setPrice(price);
        this.setAvailabilityOfGuarantee(avail_guarantie);
        this.setPresenceOfBulbs(presence_bulbs);
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
    public boolean isPresenceOfBulbs(){
        return super.isPresenceOfBulbs();
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
