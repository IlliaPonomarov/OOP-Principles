package com.company.Things;

public abstract class Fourniture extends Product{

    private boolean presenceOfLegs;

    public boolean isPresenceOfLegs() {
        return presenceOfLegs;
    }

    public void setPresenceOfLegs(boolean presenceOfLegs) {
        this.presenceOfLegs = presenceOfLegs;
    }
}
