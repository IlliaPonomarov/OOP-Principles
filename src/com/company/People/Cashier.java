package com.company.People;

import com.company.Interface.ConsoleColors;
import com.company.Main;
import com.company.Things.Product;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Cashier extends Person implements ConsoleColors {



   private double cost_of_goods;
   private double customer_money;



    public Cashier(String name, String surname) {

        setFirst_name(name);
        setSecond_name(surname);
    }


    public  Cashier(double cost_of_goods, double customer_money){
        this.cost_of_goods = cost_of_goods;
        this.customer_money = customer_money;
    }



    public void sale_of_goods() throws InterruptedException {
        int size_c = Main.customers.size() - 1;
        int size_cashier = Main.cashiers.size() - 1;

        String name_surname_customers = Main.customers.get(Main.customers.size() - 1).getFirst_name() + " " + Main.customers.get(size_c).getSecond_name();
        String name_surname_cashier = Main.cashiers.get(size_cashier).getFirst_name() + " " + Main.cashiers.get(size_cashier).getSecond_name();

        Thread.sleep(1000);
        System.out.println(PURPLE_BOLD_BRIGHT + "Good afternoon, I am your cashier, my name is " + TEXT_RESET +
                name_surname_cashier + PURPLE_BOLD_BRIGHT + " show me your receipt so I can sell you your item.."+ TEXT_RESET );


        Thread.sleep(1000);
        System.out.println(CYAN_BOLD_BRIGHT + name_surname_customers + " (Customers) Of course, keep a check." + TEXT_RESET);


        Thread.sleep(1000);
        System.out.println(PURPLE_BOLD_BRIGHT + name_surname_cashier + "(Cashier) looks at the check ...\nYou have to pay " + TEXT_RESET + cost_of_goods);


        Thread.sleep(1000);
        System.out.println(GREEN_BOLD_BRIGHT + name_surname_cashier + "(Customers) opens a wallet, in his wallet " + TEXT_RESET + customer_money);

        if (customer_money >= cost_of_goods){
            Thread.sleep(1000);
            System.out.println(GREEN_BOLD_BRIGHT + name_surname_customers + "(Customers) transfers money to the cashier ... " + TEXT_RESET);

            Thread.sleep(1000);
            System.out.println(PURPLE_BOLD_BRIGHT + name_surname_cashier + "(Cashier) puts money in the cashier and gives the check to the buyer ..." + TEXT_RESET);

            Thread.sleep(1000);
            System.out.println(PURPLE_BOLD_BRIGHT + name_surname_cashier + "(Cashier) gives change to the user ... " + TEXT_RESET);
            customer_money -= cost_of_goods;

            Thread.sleep(1000);
            System.out.printf(GREEN_BOLD_BRIGHT + "The buyer has %.2f\n" , customer_money);

            Thread.sleep(1000);
            System.out.println(GREEN_BOLD_BRIGHT + "(Customers) leaving the store ..." + TEXT_RESET);

            Thread.sleep(1000);
            System.exit(0);

        }
        else if (customer_money < cost_of_goods)
        {
            Thread.sleep(1000);
            System.out.println(GREEN_BOLD_BRIGHT + "(Customers) Oh, sorry, I don't have enough money." + TEXT_RESET);


            Thread.sleep(1000);
            System.out.println(PURPLE_BOLD_BRIGHT + "(Cashier) Sorry, I cannot sell this product to you." + TEXT_RESET);


            Thread.sleep(1000);
            System.out.println(GREEN_BOLD_BRIGHT + "(Customers) Then I will come to you next time." + TEXT_RESET);

            Thread.sleep(1000);
            System.out.println(GREEN_BOLD_BRIGHT + "(Customers) leaving the store ..." + TEXT_RESET);


            Thread.sleep(1000);
            System.exit(0);
        }

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


    @Override
    public void greetings(Person person, Person person1) {
        System.out.println();
    }

    @Override
    public int chooseOfProduct(int i) throws InterruptedException {

        return i;
    }
}
