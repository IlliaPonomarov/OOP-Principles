package com.company.People;

import com.company.ConsoleColors;
import com.company.Things.Lighting.LampShades;
import com.company.Things.Lighting.Lighting;
import com.company.Things.Lighting.WallLamps;
import com.company.Things.Product;

import java.util.Scanner;

public class Manager extends Person implements ConsoleColors, InteractionCustomersManager {


    OrderOfGoods orderOfGoods;

    public Manager(){}
    public Manager(String name, String surname) {
        setFirst_name(name);
        setSecond_name(surname);

    }

    @Override
    public void greetings(Person person, Person person1) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(GREEN_BOLD_BRIGHT + "Manager approaches the Customers ..." + TEXT_RESET);
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
    public int chooseOfProduct(int i) throws InterruptedException{
        Scanner in = new Scanner(System.in);
        if (i == 0) {
            Thread.sleep(1000);
            System.out.println(GREEN_BOLD_BRIGHT + "\nManager: " + TEXT_RESET + WHITE_BOLD_BRIGHT + "Hello! What product do you need?" + TEXT_RESET);
            Thread.sleep(1000);
            System.out.println(WHITE_BOLD_BRIGHT + "Choose product:" + TEXT_RESET);
            Thread.sleep(1000);
            System.out.println(WHITE_BOLD_BRIGHT + "1.Furniture\t 2.Technic\t3.Lighting" + TEXT_RESET);
        }else {
            switch (i){
                case 1: System.out.println("Furniture"); break;
                case 2: System.out.println("Technic"); break;
                case 3:
                    System.out.println(GREEN_BOLD_BRIGHT + "Manager: " + TEXT_RESET+ WHITE_BOLD_BRIGHT + "We are a small shop and we only have 1.\"Lamp Shades\" and 2.\"Wall Lamps\""  + TEXT_RESET);
                    int j = in.nextInt();
                    if (j == 1)
                        creatOfWallLamps();
                   else if (j == 2)
                        createOfLampsShades();
                    break;
            }
        }
    return 0;
    }

    public void creatOfWallLamps(){

    }

    public void createOfLampsShades(){

    }


}
