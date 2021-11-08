package com.company.Things;

import com.company.People.Manager;

public abstract class Product extends Manager {
    private double price;
    private boolean availabilityOfGuarantee;



    public boolean isAvailabilityOfGuarantee() {
        return availabilityOfGuarantee;
    }

    public void setAvailabilityOfGuarantee(boolean availabilityOfGuarantee) {
        this.availabilityOfGuarantee = availabilityOfGuarantee;
    }

}
