package com.company.People;

import com.company.ConsoleColors;

public class Customers extends Person implements ConsoleColors {

    double money;
    String phone_number;
    String mail;
    String city;
    String street;
    int apartment;

    public Customers(){}

    public Customers(String name, String surname, int age, double money, String phone_number, String mail, String city, String street, int apartment) {

        setFirst_name(name);
        setSecond_name(surname);
        setAge(age);

        this.money = money;
        this.phone_number = phone_number;
        this.mail = mail;
        this.city = city;
        this.street = street;
        this.apartment = apartment;
    }




    @Override
    void greetings(Person person, Person person1) {

        System.out.println(CYAN_BOLD_BRIGHT + getFirst_name() + " " + getSecond_name() + " (Customers) greets the manager." + TEXT_RESET);
    }

    @Override
    public String toString() {
        return "Customers 1:" +
                "\nName: " + getFirst_name()+
                "\nSurname: " + getSecond_name()+
                "\nAge: "+ getAge()+
                "\nMoney: "+money+
                "\nPhone number: " + phone_number +
                "\nMail: " + mail +
                "\nCity: " + city +
                "\nStreet: " + street +
                "\nApartment: " + apartment;
    }
}
