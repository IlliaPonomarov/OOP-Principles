package com.company.People;

import com.company.ConsoleColors;

public class Manager extends Person implements ConsoleColors {


    OrderOfGoods orderOfGoods;


    public Manager(String name, String surname) {
        setFirst_name(name);
        setSecond_name(surname);

    }

    @Override
    void greetings(Person person, Person person1) {
        System.out.println(GREEN_BOLD_BRIGHT + " Manager approaches the Customers ..." + TEXT_RESET);
        System.out.println( GREEN_BOLD_BRIGHT + person.getFirst_name() + " " + person.getSecond_name() + " (Manager) welcomes " + person1.getFirst_name() + " " + person1.getSecond_name() + TEXT_RESET);
        System.out.println("");
    }


    public void setOrderOfGoods(OrderOfGoods orderOfGoods){
        this.orderOfGoods = orderOfGoods;
    }


}
