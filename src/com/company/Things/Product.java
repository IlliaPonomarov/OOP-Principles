package com.company.Things;

import com.company.People.Manager;

public abstract class Product extends Manager {
    private boolean availabilityOfGuarantee;
    private int avail_in_warehouse;
    private double price;
    private String color;





    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isAvailabilityOfGuarantee() {
        return availabilityOfGuarantee;
    }

    public int getAvail_in_warehouse() {
        return avail_in_warehouse;
    }

    public void setAvail_in_warehouse(int avail_in_warehouse) {
        this.avail_in_warehouse = avail_in_warehouse;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAvailabilityOfGuarantee(boolean availabilityOfGuarantee) {
        this.availabilityOfGuarantee = availabilityOfGuarantee;
    }

}
