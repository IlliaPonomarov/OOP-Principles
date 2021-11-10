package com.company.People;

public class Cashier extends Person{


   private int cashier_number;
   private boolean avail_of_cashier;
   private double cost_of_goods;
   private double customer_money;

    public Cashier(){}

    public Cashier(String name, String surname, int cashier_number, boolean avail_of_cashier, double cost_of_goods, double customer_money) {


        setFirst_name(name);
        setSecond_name(surname);
        this.cashier_number = cashier_number;
        this.avail_of_cashier = avail_of_cashier;
        this.cost_of_goods = cost_of_goods;
        this.customer_money = customer_money;
    }

    public int getCashier_number() {
        return cashier_number;
    }

    public void setCashier_number(int cashier_number) {
        this.cashier_number = cashier_number;
    }

    public boolean isAvail_of_cashier() {
        return avail_of_cashier;
    }

    public void setAvail_of_cashier(boolean avail_of_cashier) {
        this.avail_of_cashier = avail_of_cashier;
    }

    public double getCost_of_goods() {
        return cost_of_goods;
    }

    public void setCost_of_goods(double cost_of_goods) {
        this.cost_of_goods = cost_of_goods;
    }

    public double getCustomer_money() {
        return customer_money;
    }

    public void setCustomer_money(double customer_money) {
        this.customer_money = customer_money;
    }

    @Override
    public void greetings(Person person, Person person1) {
        System.out.println();
    }

    @Override
    public int chooseOfProduct(int i) throws InterruptedException {

        return i;
    }
}
