package com.company.People;

import com.company.Interface.ConsoleColors;
import com.company.Data.DBHandler;
import com.company.Main;
import com.company.Interface.InteractionCustomersManager;
import com.company.Interface.OrderOfGoods;
import com.company.Interface.ProductSearch;
import com.company.Things.Lighting.WallLamps;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class Manager extends Person implements ConsoleColors, InteractionCustomersManager, ProductSearch, OrderOfGoods {



    static ArrayList<WallLamps> wallLamps;


    OrderOfThings orderOfThings;



    //Overloading
    public Manager(String name, double price, boolean avail_guarantie, String color, int height, int width){
        this.orderOfThings = new OrderOfThings(name, price, avail_guarantie, color, 0, height, width);
    }


    //Overloading
    public Manager(){

    }

    //Overloading
    public Manager(String name, String surname) {
        setFirst_name(name);
        setSecond_name(surname);

    }





    @Override
    public void greetings(Person manager, Person customer) throws InterruptedException {

        Thread.sleep(1000);
        System.out.println(GREEN_BOLD_BRIGHT + getFirst_name() + " " + getSecond_name() + "(Manager) approaches the Customers ..." + TEXT_RESET);
        Thread.sleep(1000);
        System.out.println(GREEN_BOLD_BRIGHT + manager.getFirst_name() + " " + manager.getSecond_name() + " (Manager) welcomes " + customer.getFirst_name() + " " + customer.getSecond_name() + TEXT_RESET);
        Thread.sleep(1000);

    }



    @Override
    public String toString() {
        return "Manager{" +
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
                case 1:

                    System.out.println("Furniture");
                    System.err.println("The class Furniture (1)  hasn't been written yet. Only the class \"Lighting\"  works (3)");
                    break;

                case 2:
                    System.out.println("The class Technic (2)  hasn't been written yet. Only the class \"Lighting\"  works (3)");

                    break;
                case 3:
                    int j = -1;

                    Thread.sleep(1000);
                    System.out.println(GREEN_BOLD_BRIGHT + getFirst_name() + " " + getSecond_name() +"(Manager):" + TEXT_RESET + WHITE_BOLD_BRIGHT + " Goes up to the 3rd floor and enters the \"Lighting\" section." + TEXT_RESET);

                    Thread.sleep(1000);
                    System.out.println(GREEN_BOLD_BRIGHT + getFirst_name() + " " + getSecond_name() +"(Manager):" + TEXT_RESET + WHITE_BOLD_BRIGHT + "We are a small shop and we only have 1.\"Lamp Shades\"(doesn't work) and 2.\"Wall Lamps\" (work)"  + TEXT_RESET);
                    j = in.nextInt();

                    if (j == 2) {
                        System.out.println(GREEN_BOLD_BRIGHT + getFirst_name() + " " + getSecond_name() + "(Manager) goes to the Wall Lamps section ..." + TEXT_RESET);
                        searchOfWallLamps();
                    }
                   else if (j == 1) {
                        System.out.println(GREEN_BOLD_BRIGHT + getFirst_name() + " " + getSecond_name() + "(Manager) goes to the Lamps Shades section ..." + TEXT_RESET);
                        searchOfLampsShades();
                    }
                    break;
                default:
                    System.out.println("Такого варианта нет. Попробуйте еще");
                    chooseOfProduct(in.nextInt());
                    break;
            }
        }
    return 0;
    }

    public void searchOfWallLamps() throws SQLException , InterruptedException {

        Scanner in = new Scanner(System.in);
        DBHandler dbHandler = DBHandler.getInstance();

        int size_c = Main.customers.size() - 1;
        int size_m = Main.customers.size() - 1;
        int choose_c = 0;

        wallLamps = new ArrayList<WallLamps>();
        wallLamps = dbHandler.getWallLamps();

        Thread.sleep(1000);
        System.out.println(GREEN_BOLD_BRIGHT + getFirst_name() + " " + getSecond_name() + "(Manager):" + TEXT_RESET + WHITE_BOLD_BRIGHT + " Are there any special requests? Colour? Price?" + TEXT_RESET);

        Thread.sleep(1000);
        System.out.println(GREEN_BOLD_BRIGHT + getFirst_name() + " " + getSecond_name() + "(Manager):" + TEXT_RESET + WHITE_BOLD_BRIGHT + " Select 1.Price (almost work) 2.Color (doesn't work) 3.Color and Price (doesn't work)" + TEXT_RESET);



        while (choose_c != 1 && choose_c != 2 && choose_c != 3) {
            choose_c = Main.customers.get(size_c).chooseOfProduct(in.nextInt());
            switch (choose_c) {
                case 1:
                    ProductSearch.searchByPrice(wallLamps);
                    break;
                case 2:
                    System.out.println("Менеджер: Окей, мы имеем в наличии Wall Lamps только с такими цветами: ");
                     ProductSearch.searchByColor(wallLamps);
                    break;
                case 3:
                     ProductSearch.searchByColor_Price(wallLamps);
                    break;
                default:
                    System.err.println("Try again.");

            }
        }
    }

    public void searchOfLampsShades(){

    }

    public void FloorStand(){

    }

    public void HangingCurbstone(){
        System.out.println("");
    }

    public void TripleOfSofa(){

    }

    public void searchOfChair(){

    }

    public void searchOfTV(){

    }

    public void searchOfAudioSystem(){

    }

    public void searchOfBath(){

    }

    public void searchOfShowerHeads(){

    }


}
