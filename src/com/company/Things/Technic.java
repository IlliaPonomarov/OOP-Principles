package com.company.Things;

import com.company.Things.Product;

public abstract class Technic extends Product {

    private boolean prsenceOfbolts;

    public boolean isPrsenceOfbolts() {
        return prsenceOfbolts;
    }

    public void setPrsenceOfbolts(boolean prsenceOfbolts) {
        this.prsenceOfbolts = prsenceOfbolts;
    }
}
