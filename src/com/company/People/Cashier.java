package com.company.People;

public class Cashier extends Person{


    int cashier_number;
    boolean avail_of_cashier;
    double cost_of_goods;
    double customer_money;

    public Cashier(){}



    public Cashier(String name, String surname, int cashier_number, boolean avail_of_cashier, double cost_of_goods, double customer_money) {


        setFirst_name(name);
        setSecond_name(surname);
        this.cashier_number = cashier_number;
        this.avail_of_cashier = avail_of_cashier;
        this.cost_of_goods = cost_of_goods;
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
