package com.company.People;

import com.company.ConsoleColors;
import com.company.Data.DBHandler;
import com.company.Main;
import com.company.Things.Lighting.WallLamps;
import com.company.Things.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager extends Person implements ConsoleColors, InteractionCustomersManager, ProductSearch {


    OrderOfGoods orderOfGoods;
    static ArrayList<WallLamps> wallLamps;

    public Manager(){}
    public Manager(String name, String surname) {
        setFirst_name(name);
        setSecond_name(surname);

    }

    @Override
    public void greetings(Person person, Person person1) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(GREEN_BOLD_BRIGHT + getFirst_name() + " " + getSecond_name() + "(Manager) approaches the Customers ..." + TEXT_RESET);
        Thread.sleep(1000);
        System.out.println(GREEN_BOLD_BRIGHT + person.getFirst_name() + " " + person.getSecond_name() + " (Manager) welcomes " + person1.getFirst_name() + " " + person1.getSecond_name() + TEXT_RESET);
        Thread.sleep(1000);

    }



    @Override
    public String toString() {
        return "Manager{" +
                "orderOfGoods=" + orderOfGoods +
                '}';
    }

    @Override
    public int chooseOfProduct(int i) throws InterruptedException, SQLException{
        Scanner in = new Scanner(System.in);
        if (i == 0) {
            Thread.sleep(1000);
            System.out.println(GREEN_BOLD_BRIGHT + getFirst_name() + " " + getSecond_name() + "(Manager): " + TEXT_RESET + WHITE_BOLD_BRIGHT + "Hello! What product do you need?" + TEXT_RESET);
            Thread.sleep(1000);
            System.out.println(WHITE_BOLD_BRIGHT + "Choose product:" + TEXT_RESET);
            Thread.sleep(1000);
            System.out.println(WHITE_BOLD_BRIGHT + "1.Furniture\t 2.Technic\t3.Lighting" + TEXT_RESET);
            Thread.sleep(1000);
        }else {
            switch (i){
                case 1: System.out.println("Furniture"); break;
                case 2: System.out.println("Technic"); break;
                case 3:
                    Thread.sleep(1000);
                    System.out.println(GREEN_BOLD_BRIGHT + "The Manager goes up to the 3rd floor and enters the \"Lighting\" section." + TEXT_RESET);
                    Thread.sleep(1000);
                    System.out.println(GREEN_BOLD_BRIGHT + "Manager: " + TEXT_RESET+ WHITE_BOLD_BRIGHT + "We are a small shop and we only have 1.\"Lamp Shades\" and 2.\"Wall Lamps\""  + TEXT_RESET);
                    int j = in.nextInt();
                    if (j == 2)
                        searchOfWallLamps();
                   else if (j == 1)
                        searchOfLampsShades();
                    break;
            }
        }
    return 0;
    }

    public void searchOfWallLamps() throws SQLException , InterruptedException{
        Scanner in = new Scanner(System.in);
        int size_c = Main.customers.size() - 1;
        wallLamps = new ArrayList<WallLamps>();
        DBHandler dbHandler = DBHandler.getInstance();
        wallLamps = dbHandler.getWallLamps();
        System.out.println(GREEN_BOLD_BRIGHT + getFirst_name() + " " + getSecond_name() + TEXT_RESET + WHITE_BOLD_BRIGHT +" (Менеджер) есть ли какие - то особые пожилания? Цвет? Цена?" + TEXT_RESET);
        System.out.println("Выберите 1.Цена 2.Цвет 3.Цвет и Цена");
        int choose_c = Main.customers.get(size_c).chooseOfProduct(in.nextInt());


        switch(choose_c){
            case 1: ProductSearch.searchByPrice(wallLamps, choose_c);break;
            case 2: break;
            case 3: break;
        }
    }

    public void searchOfLampsShades(){

    }


}
