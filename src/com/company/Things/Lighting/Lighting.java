package com.company.Things.Lighting;

import com.company.Things.Product;

public abstract class Lighting extends Product {
    private boolean presenceOfBulbs;


    public boolean isPresenceOfBulbs() {
        return presenceOfBulbs;
    }

    public void setPresenceOfBulbs(boolean presenceOfBulbs) {
        this.presenceOfBulbs = presenceOfBulbs;
    }


}
