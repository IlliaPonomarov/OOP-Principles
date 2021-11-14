package com.company.People;

import com.company.Interface.ConsoleColors;

public class Customers extends Person implements ConsoleColors {

   private double money;
   private String phone_number;
   private String mail;
   private String city;
   private String street;
   private int apartment;

    public Customers(){}



    public Customers(String name, String surname, int age, double money, String phone_number, String mail, String city, String street, int apartment) {

        super.setFirst_name(name);
        super.setSecond_name(surname);
        super.setAge(age);

        this.money = money;
        this.phone_number = phone_number;
        this.mail = mail;
        this.city = city;
        this.street = street;
        this.apartment = apartment;
    }




    @Override
    public  void greetings(Person person, Person person1) throws InterruptedException{

        System.out.println(CYAN_BOLD_BRIGHT + getFirst_name() + " " + getSecond_name() + " (Customers) greets the manager." + TEXT_RESET);
        Thread.sleep(1000);

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



    @Override
    public  int chooseOfProduct(int i) throws InterruptedException {
        System.out.println(CYAN_BOLD_BRIGHT + getFirst_name() + " " + getSecond_name() + " (Customer) chose: " + TEXT_RESET + WHITE_BOLD_BRIGHT + i + TEXT_RESET);
        return i;
    }




    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }
}
