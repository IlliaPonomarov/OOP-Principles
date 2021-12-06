package com.company.People;

import com.company.Interface.*;
import com.company.Data.DBHandler;
import com.company.Main;
import com.company.Things.Bathroom.FurnitureBR.FloorStand;
import com.company.Things.Bathroom.TechnicBR.ShowerHeads;
import com.company.Things.Lighting.LampShades;
import com.company.Things.Lighting.WallLamps;
import com.company.Things.LivingRoom.FurnitureLR.Chair;
import com.company.Things.LivingRoom.TechnicLR.TV;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class Manager extends Person implements ConsoleColors, InteractionCustomersManager, ProductSearch, OrderOfGoods, ChooseORDER {


    //Lighting
    static ArrayList<WallLamps> wallLamps;
    static ArrayList<LampShades> shades_lamps;

    //Technic
    static ArrayList<TV> tvs;
    static ArrayList<ShowerHeads> showerHeads;

    //Furniture
    static ArrayList<Chair> chairs;
    static ArrayList<FloorStand> floorStands;


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
                    int furniture = -1;

                    Thread.sleep(1000);
                    System.out.println(GREEN_BOLD_BRIGHT + getFirst_name() + " " + getSecond_name() +"(Manager):" + TEXT_RESET + WHITE_BOLD_BRIGHT + " Goes up to the 1rd floor and enters the \"Furniture\" section." + TEXT_RESET);

                    Thread.sleep(1000);
                    System.out.println(GREEN_BOLD_BRIGHT + getFirst_name() + " " + getSecond_name() +"(Manager):" + TEXT_RESET + WHITE_BOLD_BRIGHT + "We are a small shop and we only have 1.\"FloorStand\" and 2.\"Chair\" "  + TEXT_RESET);
                    furniture = in.nextInt();

                    switch (furniture){
                        case 1:
                            System.out.println(GREEN_BOLD_BRIGHT +ns_manager + "(Manager) goes to the FloorStand section ..." + TEXT_RESET);
                            searchOfFloorStand();
                            break;
                        case 2:

                            System.out.println(GREEN_BOLD_BRIGHT +ns_manager + "(Manager) goes to the Chair section ..." + TEXT_RESET);
                            searchOfChair();

                            break;
                        default:
                            System.err.println("There is no such option. Try again");
                            chooseOfProduct(in.nextInt());
                            break;
                    }

                    break;

                case 2:
                    int technic = -1;

                    Thread.sleep(1000);
                    System.out.println(GREEN_BOLD_BRIGHT + ns_manager +" (Manager):" + TEXT_RESET + WHITE_BOLD_BRIGHT + " Goes up to the 1rd floor and enters the \"Technic\" section." + TEXT_RESET);

                    Thread.sleep(1000);
                    System.out.println(GREEN_BOLD_BRIGHT +ns_manager +" (Manager):" + TEXT_RESET + WHITE_BOLD_BRIGHT + "We are a small shop and we only have 1.\"TV\" and 2.\"ShowerHeads\" "  + TEXT_RESET);
                    technic = in.nextInt();

                    switch (technic) {
                        case 1:
                            System.out.println(GREEN_BOLD_BRIGHT +ns_manager + "(Manager) goes to the TV section ..." + TEXT_RESET);
                            searchOfTV();
                            break;
                        case 2:
                            System.out.println(GREEN_BOLD_BRIGHT +ns_manager + "(Manager) goes to the ShowerHeads section ..." + TEXT_RESET);
                            searchOfShowerHeads();
                            break;
                        default:
                            System.err.println("There is no such option. Try again");
                            chooseOfProduct(in.nextInt());
                            break;

                    }

                    break;
                case 3:
                    int j = -1;

                    Thread.sleep(1000);
                    System.out.println(GREEN_BOLD_BRIGHT + getFirst_name() + " " + getSecond_name() +"(Manager):" + TEXT_RESET + WHITE_BOLD_BRIGHT + " Goes up to the 3rd floor and enters the \"Lighting\" section." + TEXT_RESET);

                    Thread.sleep(1000);
                    System.out.println(GREEN_BOLD_BRIGHT + getFirst_name() + " " + getSecond_name() +"(Manager):" + TEXT_RESET + WHITE_BOLD_BRIGHT + "We are a small shop and we only have 1.\"Lamp Shades\" and 2.\"Wall Lamps\" "  + TEXT_RESET);
                    j = in.nextInt();

                    if (j == 2) {
                        System.out.println(GREEN_BOLD_BRIGHT + getFirst_name() + " " + getSecond_name() + "(Manager) goes to the Wall Lamps section ..." + TEXT_RESET);
                        searchOfWallLamps();
                    }
                     else if (j == 1) {
                        System.out.println(GREEN_BOLD_BRIGHT + getFirst_name() + " " + getSecond_name() + "(Manager) goes to the Lamps Shades section ..." + TEXT_RESET);
                        searchOfLampsShades();
                    }
                     else {
                        System.err.println("There is no such option. Try again");
                        chooseOfProduct(in.nextInt());
                    }
                    break;
                default:
                    System.err.println("There is no such option. Try again");
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
        double price = 0;
        String answer = "";

        wallLamps = new ArrayList<WallLamps>();
        wallLamps = dbHandler.getWallLamps();

        Thread.sleep(1000);
        System.out.println(GREEN_BOLD_BRIGHT + getFirst_name() + " " + getSecond_name() + "(Manager):" + TEXT_RESET + WHITE_BOLD_BRIGHT + " Are there any special requests? Colour? Price?" + TEXT_RESET);

        Thread.sleep(1000);
        System.out.println(GREEN_BOLD_BRIGHT + getFirst_name() + " " + getSecond_name() + "(Manager):" + TEXT_RESET + WHITE_BOLD_BRIGHT + " Select 1.Price  2.Color  3.Color and Price" + TEXT_RESET);



        while (choose_c != 1 && choose_c != 2 && choose_c != 3) {
            choose_c = Main.customers.get(size_c).chooseOfProduct(in.nextInt());
            switch (choose_c) {
                case 1:
                    price = ProductSearch.searchByPrice(wallLamps);

                    if (price != -1 ){
                        Thread.sleep(1000);
                        System.out.println(GREEN_BOLD_BRIGHT + ns_manager + " (Manager)" + TEXT_RESET + " Do you want to buy this item? (Y/N)");

                        answer = ChooseORDER.choose(in.next());

                        if (answer.equals("Yes")) {
                            Cashier cashier = new Cashier(price, Main.customers.get(size_c).getMoney());
                            cashier.sale_of_goods();
                        }
                        else if (answer.equals("No")){
                            System.out.println(GREEN_BOLD_BRIGHT + "(Manager) Do you wanna order this items? (Y/N)" + TEXT_RESET);
                            answer = in.next();
                            if (answer.equals("Yes")){
                                String name_r = "", color = "";
                                double price_r = 0, height = 0, width = 0;
                                boolean avail_guarantie;

                                Thread.sleep(1000);
                                System.out.printf("\nName of item: ");
                                name_r = in.next();

                                Thread.sleep(1000);
                                System.out.printf("\nHeight: ");
                                height = in.nextDouble();

                                Thread.sleep(1000);
                                System.out.println("\nWidth: ");
                                width = in.nextDouble();

                                Thread.sleep(1000);
                                price = width * height;
                                System.out.printf("\nPrice %.2f", price);

                                Thread.sleep(1000);
                                avail_guarantie = true;

                                Thread.sleep(1000);
                                System.out.printf("\nColor: ");
                                color = in.next();

                                Thread.sleep(1000);
                                System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager) We place an order ... ..." + TEXT_RESET);

                                Thread.sleep(1000);
                                System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager)" + TEXT_RESET + " Your order has been placed! Go to the checkout and pay.");


                                OrderOfThings orderOfThings= new OrderOfThings(name_r, price, avail_guarantie, color, 1, height, width);
                                orderOfThings.addData(name_r, price, avail_guarantie, color, 1, height, width);

                                Thread.sleep(1000);
                                System.out.println(CYAN_BOLD_BRIGHT + "(Customers) Подходит к кассе ..." + TEXT_RESET);
                                Cashier cashier = new Cashier(price_r, Main.customers.get(size_c).getMoney());

                            }

                            System.out.println(CYAN_BOLD_BRIGHT + "(Customers) exits the store ..." + TEXT_RESET);
                            System.exit(0);
                        }
                    }
                    else if (price == -1){
                        Thread.sleep(1000);
                        System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager)" + " Do you wanna order this item?" + TEXT_RESET);
                        answer = ChooseORDER.choose(in.next());

                        if (answer.equals("Yes"))
                            OrderOfGoods.order_start();
                        else
                            System.exit(0);
                    }

                    break;
                case 2:

                    System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager) Okay, we only have Wall Lamps in stock with these colors: " + TEXT_RESET);
                    double color_r =  ProductSearch.searchByColor(wallLamps);

                    if (color_r != -1 ){
                        Thread.sleep(1000);
                        System.out.println(GREEN_BOLD_BRIGHT + ns_manager + " (Manager)" + TEXT_RESET + " Do you want to buy this item? (Y/N)");

                        answer = ChooseORDER.choose(in.next());

                        if (answer.equals("Yes")) {
                            Cashier cashier = new Cashier(color_r, Main.customers.get(size_c).getMoney());
                            cashier.sale_of_goods();
                        }
                        else if (answer.equals("No")){
                            System.out.println(GREEN_BOLD_BRIGHT + "(Manager) Do you wanna order this items? (Y/N)" + TEXT_RESET);
                            answer = in.next();
                            if (answer.equals("Yes")){
                                String name_r = "", color = "";
                                double price_r = 0, height = 0, width = 0;
                                boolean avail_guarantie;

                                Thread.sleep(1000);
                                System.out.printf("\nName of item: ");
                                name_r = in.next();

                                Thread.sleep(1000);
                                System.out.printf("\nHeight: ");
                                height = in.nextDouble();

                                Thread.sleep(1000);
                                System.out.println("\nWidth: ");
                                width = in.nextDouble();

                                Thread.sleep(1000);
                                price = width * height;
                                System.out.printf("\nPrice %.2f", price);

                                Thread.sleep(1000);
                                avail_guarantie = true;

                                Thread.sleep(1000);
                                System.out.printf("\nColor: ");
                                color = in.next();

                                Thread.sleep(1000);
                                System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager) We place an order ... ..." + TEXT_RESET);

                                Thread.sleep(1000);
                                System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager)" + TEXT_RESET + " Your order has been placed! Go to the checkout and pay.");


                                OrderOfThings orderOfThings= new OrderOfThings(name_r, price, avail_guarantie, color, 1, height, width);
                                orderOfThings.addData(name_r, price, avail_guarantie, color, 1, height, width);

                                Thread.sleep(1000);
                                System.out.println(CYAN_BOLD_BRIGHT + ns_customers + "(Customers) Coming to the checkout ..." + TEXT_RESET);
                                Cashier cashier = new Cashier(price_r, Main.customers.get(size_c).getMoney());

                            }

                            System.out.println(CYAN_BOLD_BRIGHT + ns_customers + "(Customers) exits the store ..." + TEXT_RESET);
                            System.exit(0);
                        }
                    }
                    else if (color_r == -1){
                        Thread.sleep(1000);
                        System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager)" + " Do you wanna order this item?" + TEXT_RESET);
                        answer = ChooseORDER.choose(in.next());

                        if (answer.equals("Yes"))
                            OrderOfGoods.order_start();
                        else
                            System.exit(0);
                    }

                    break;
                case 3:


                    System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager) Okay, we only have Wall Lamps in stock with these colors: " + TEXT_RESET);

                    double color_price = 0;
                    color_price = ProductSearch.searchByColor_Price(wallLamps);


                    if (color_price != -1 ){
                        Thread.sleep(1000);
                        System.out.println(GREEN_BOLD_BRIGHT + ns_manager + " (Manager)" + TEXT_RESET + " Do you want to buy this item? (Y/N)");

                        answer = ChooseORDER.choose(in.next());

                        if (answer.equals("Yes")) {
                            Cashier cashier = new Cashier(color_price, Main.customers.get(size_c).getMoney());
                            cashier.sale_of_goods();
                        }
                        else if (answer.equals("No")){
                            System.out.println(GREEN_BOLD_BRIGHT + "(Manager) Do you wanna order this items? (Y/N)" + TEXT_RESET);
                            answer = in.next();
                            if (answer.equals("Yes")){
                                String name_r = "", color = "";
                                double price_r = 0, height = 0, width = 0;
                                boolean avail_guarantie;

                                Thread.sleep(1000);
                                System.out.printf("\nName of item: ");
                                name_r = in.next();

                                Thread.sleep(1000);
                                System.out.printf("\nHeight: ");
                                height = in.nextDouble();

                                Thread.sleep(1000);
                                System.out.println("\nWidth: ");
                                width = in.nextDouble();

                                Thread.sleep(1000);
                                price = width * height;
                                System.out.printf("\nPrice %.2f", price);

                                Thread.sleep(1000);
                                avail_guarantie = true;

                                Thread.sleep(1000);
                                System.out.printf("\nColor: ");
                                color = in.next();

                                Thread.sleep(1000);
                                System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager) We place an order ... ..." + TEXT_RESET);

                                Thread.sleep(1000);
                                System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager)" + TEXT_RESET + " Your order has been placed! Go to the checkout and pay.");


                                OrderOfThings orderOfThings= new OrderOfThings(name_r, price, avail_guarantie, color, 1, height, width);
                                orderOfThings.addData(name_r, price, avail_guarantie, color, 1, height, width);

                                Thread.sleep(1000);
                                System.out.println(CYAN_BOLD_BRIGHT + ns_customers + "(Customers) Coming to the checkout ..." + TEXT_RESET);
                                Cashier cashier = new Cashier(price_r, Main.customers.get(size_c).getMoney());

                            }

                            System.out.println(CYAN_BOLD_BRIGHT + ns_customers + "(Customers) exits the store ..." + TEXT_RESET);
                            System.exit(0);
                        }
                    }
                    else if (color_price == -1){
                        Thread.sleep(1000);
                        System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager)" + " Do you wanna order this item?" + TEXT_RESET);
                        answer = ChooseORDER.choose(in.next());

                        if (answer.equals("Yes"))
                            OrderOfGoods.order_start();
                        else
                            System.exit(0);
                    }

                    break;
                default:
                    System.err.println("Try again.");

            }
        }
    }

    public void searchOfLampsShades() throws SQLException, InterruptedException{
        Scanner in = new Scanner(System.in);
        DBHandler dbHandler = DBHandler.getInstance();

        int size_c = Main.customers.size() - 1;
        int size_m = Main.customers.size() - 1;
        int choose_c = 0;
        double price = 0;
        String answer = "";

        shades_lamps = new ArrayList<LampShades>();
        shades_lamps = dbHandler.getLamps_shades();

        shades_lamps.get(shades_lamps.size() - 1).getColor();


        Thread.sleep(1000);
        System.out.println(GREEN_BOLD_BRIGHT + getFirst_name() + " " + getSecond_name() + "(Manager):" + TEXT_RESET + WHITE_BOLD_BRIGHT + " Are there any special requests? Colour? Price?" + TEXT_RESET);

        Thread.sleep(1000);
        System.out.println(GREEN_BOLD_BRIGHT + getFirst_name() + " " + getSecond_name() + "(Manager):" + TEXT_RESET + WHITE_BOLD_BRIGHT + " Select 1.Price  2.Color  3.Color and Price" + TEXT_RESET);

        while (choose_c != 1 && choose_c != 2 && choose_c != 3) {
            choose_c = Main.customers.get(size_c).chooseOfProduct(in.nextInt());
            switch (choose_c) {
                case 1:
                    price = ProductSearch.searchByPrice(shades_lamps);

                    if (price != -1 ){
                        Thread.sleep(1000);
                        System.out.println(GREEN_BOLD_BRIGHT + ns_manager + " (Manager)" + TEXT_RESET + " Do you want to buy this item? (Y/N)");

                        answer = ChooseORDER.choose(in.next());

                        if (answer.equals("Yes")) {
                            Cashier cashier = new Cashier(price, Main.customers.get(size_c).getMoney());
                            cashier.sale_of_goods();
                        }
                        else if (answer.equals("No")){
                            System.out.println(GREEN_BOLD_BRIGHT + "(Manager) Do you wanna order this items? (Y/N)" + TEXT_RESET);
                            answer = in.next();
                            if (answer.equals("Yes")){
                                String name_r = "", color = "";
                                double price_r = 0, height = 0, width = 0;
                                boolean avail_guarantie;

                                Thread.sleep(1000);
                                System.out.printf("\nName of item: ");
                                name_r = in.next();

                                Thread.sleep(1000);
                                System.out.printf("\nHeight: ");
                                height = in.nextDouble();

                                Thread.sleep(1000);
                                System.out.println("\nWidth: ");
                                width = in.nextDouble();

                                Thread.sleep(1000);
                                price = width * height;
                                System.out.printf("\nPrice %.2f", price);

                                Thread.sleep(1000);
                                avail_guarantie = true;

                                Thread.sleep(1000);
                                System.out.printf("\nColor: ");
                                color = in.next();

                                Thread.sleep(1000);
                                System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager) We place an order ... ..." + TEXT_RESET);

                                Thread.sleep(1000);
                                System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager)" + TEXT_RESET + " Your order has been placed! Go to the checkout and pay.");


                                OrderOfThings orderOfThings= new OrderOfThings(name_r, price, avail_guarantie, color, 1, height, width);
                                orderOfThings.addData(name_r, price, avail_guarantie, color, 1, height, width);

                                Thread.sleep(1000);
                                System.out.println(CYAN_BOLD_BRIGHT + "(Customers) Подходит к кассе ..." + TEXT_RESET);
                                Cashier cashier = new Cashier(price_r, Main.customers.get(size_c).getMoney());

                            }

                            System.out.println(CYAN_BOLD_BRIGHT + "(Customers) exits the store ..." + TEXT_RESET);
                            System.exit(0);
                        }
                    }
                    else if (price == -1){
                        Thread.sleep(1000);
                        System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager)" + " Do you wanna order this item?" + TEXT_RESET);
                        answer = ChooseORDER.choose(in.next());

                        if (answer.equals("Yes"))
                            OrderOfGoods.order_start();
                        else
                            System.exit(0);
                    }

                    break;
                case 2:

                    System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager) Okay, we only have Wall Lamps in stock with these colors: " + TEXT_RESET);
                    double color_r =  ProductSearch.searchByColor(shades_lamps);

                    if (color_r != -1 ){
                        Thread.sleep(1000);
                        System.out.println(GREEN_BOLD_BRIGHT + ns_manager + " (Manager)" + TEXT_RESET + " Do you want to buy this item? (Y/N)");

                        answer = ChooseORDER.choose(in.next());

                        if (answer.equals("Yes")) {
                            Cashier cashier = new Cashier(color_r, Main.customers.get(size_c).getMoney());
                            cashier.sale_of_goods();
                        }
                        else if (answer.equals("No")){
                            System.out.println(GREEN_BOLD_BRIGHT + "(Manager) Do you wanna order this items? (Y/N)" + TEXT_RESET);
                            answer = in.next();
                            if (answer.equals("Yes")){
                                String name_r = "", color = "";
                                double price_r = 0, height = 0, width = 0;
                                boolean avail_guarantie;

                                Thread.sleep(1000);
                                System.out.printf("\nName of item: ");
                                name_r = in.next();

                                Thread.sleep(1000);
                                System.out.printf("\nHeight: ");
                                height = in.nextDouble();

                                Thread.sleep(1000);
                                System.out.println("\nWidth: ");
                                width = in.nextDouble();

                                Thread.sleep(1000);
                                price = width * height;
                                System.out.printf("\nPrice %.2f", price);

                                Thread.sleep(1000);
                                avail_guarantie = true;

                                Thread.sleep(1000);
                                System.out.printf("\nColor: ");
                                color = in.next();

                                Thread.sleep(1000);
                                System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager) We place an order ... ..." + TEXT_RESET);

                                Thread.sleep(1000);
                                System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager)" + TEXT_RESET + " Your order has been placed! Go to the checkout and pay.");


                                OrderOfThings orderOfThings= new OrderOfThings(name_r, price, avail_guarantie, color, 1, height, width);
                                orderOfThings.addData(name_r, price, avail_guarantie, color, 1, height, width);

                                Thread.sleep(1000);
                                System.out.println(CYAN_BOLD_BRIGHT + ns_customers + "(Customers) Coming to the checkout ..." + TEXT_RESET);
                                Cashier cashier = new Cashier(price_r, Main.customers.get(size_c).getMoney());

                            }

                            System.out.println(CYAN_BOLD_BRIGHT + ns_customers + "(Customers) exits the store ..." + TEXT_RESET);
                            System.exit(0);
                        }
                    }
                    else if (color_r == -1){
                        Thread.sleep(1000);
                        System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager)" + " Do you wanna order this item?" + TEXT_RESET);
                        answer = ChooseORDER.choose(in.next());

                        if (answer.equals("Yes"))
                            OrderOfGoods.order_start();
                        else
                            System.exit(0);
                    }

                    break;
                case 3:


                    System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager) Okay, we only have Wall Lamps in stock with these colors: " + TEXT_RESET);

                    double color_price = 0;
                    color_price = ProductSearch.searchByColor_Price(shades_lamps);


                    if (color_price != -1 ){
                        Thread.sleep(1000);
                        System.out.println(GREEN_BOLD_BRIGHT + ns_manager + " (Manager)" + TEXT_RESET + " Do you want to buy this item? (Y/N)");

                        answer = ChooseORDER.choose(in.next());

                        if (answer.equals("Yes")) {
                            Cashier cashier = new Cashier(color_price, Main.customers.get(size_c).getMoney());
                            cashier.sale_of_goods();
                        }
                        else if (answer.equals("No")){
                            System.out.println(GREEN_BOLD_BRIGHT + "(Manager) Do you wanna order this items? (Y/N)" + TEXT_RESET);
                            answer = in.next();
                            if (answer.equals("Yes")){
                                String name_r = "", color = "";
                                double price_r = 0, height = 0, width = 0;
                                boolean avail_guarantie;

                                Thread.sleep(1000);
                                System.out.printf("\nName of item: ");
                                name_r = in.next();

                                Thread.sleep(1000);
                                System.out.printf("\nHeight: ");
                                height = in.nextDouble();

                                Thread.sleep(1000);
                                System.out.println("\nWidth: ");
                                width = in.nextDouble();

                                Thread.sleep(1000);
                                price = width * height;
                                System.out.printf("\nPrice %.2f", price);

                                Thread.sleep(1000);
                                avail_guarantie = true;

                                Thread.sleep(1000);
                                System.out.printf("\nColor: ");
                                color = in.next();

                                Thread.sleep(1000);
                                System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager) We place an order ... ..." + TEXT_RESET);

                                Thread.sleep(1000);
                                System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager)" + TEXT_RESET + " Your order has been placed! Go to the checkout and pay.");


                                OrderOfThings orderOfThings= new OrderOfThings(name_r, price, avail_guarantie, color, 1, height, width);
                                orderOfThings.addData(name_r, price, avail_guarantie, color, 1, height, width);

                                Thread.sleep(1000);
                                System.out.println(CYAN_BOLD_BRIGHT + ns_customers + "(Customers) Coming to the checkout ..." + TEXT_RESET);
                                Cashier cashier = new Cashier(price_r, Main.customers.get(size_c).getMoney());

                            }

                            System.out.println(CYAN_BOLD_BRIGHT + ns_customers + "(Customers) exits the store ..." + TEXT_RESET);
                            System.exit(0);
                        }
                    }
                    else if (color_price == -1){
                        Thread.sleep(1000);
                        System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager)" + " Do you wanna order this item?" + TEXT_RESET);
                        answer = ChooseORDER.choose(in.next());

                        if (answer.equals("Yes"))
                            OrderOfGoods.order_start();
                        else
                            System.exit(0);
                    }

                    break;
                default:
                    System.err.println("Try again.");

            }
        }
    }

    public void searchOfFloorStand() throws SQLException, InterruptedException{
        Scanner in = new Scanner(System.in);
        DBHandler dbHandler = DBHandler.getInstance();

        int size_c = Main.customers.size() - 1;
        int size_m = Main.customers.size() - 1;
        int choose_c = 0;
        double price = 0;
        String answer = "";

        floorStands = new ArrayList<FloorStand>();
        floorStands = dbHandler.getFloorStand();

        Thread.sleep(1000);
        System.out.println(GREEN_BOLD_BRIGHT + getFirst_name() + " " + getSecond_name() + "(Manager):" + TEXT_RESET + WHITE_BOLD_BRIGHT + " Are there any special requests? Colour? Price?" + TEXT_RESET);

        Thread.sleep(1000);
        System.out.println(GREEN_BOLD_BRIGHT + getFirst_name() + " " + getSecond_name() + "(Manager):" + TEXT_RESET + WHITE_BOLD_BRIGHT + " Select 1.Price  2.Color  3.Color and Price" + TEXT_RESET);



        while (choose_c != 1 && choose_c != 2 && choose_c != 3) {
            choose_c = Main.customers.get(size_c).chooseOfProduct(in.nextInt());
            switch (choose_c) {
                case 1:
                    price = ProductSearch.searchByPrice(floorStands);

                    if (price != -1 ){
                        Thread.sleep(1000);
                        System.out.println(GREEN_BOLD_BRIGHT + ns_manager + " (Manager)" + TEXT_RESET + " Do you want to buy this item? (Y/N)");

                        answer = ChooseORDER.choose(in.next());

                        if (answer.equals("Yes")) {
                            Cashier cashier = new Cashier(price, Main.customers.get(size_c).getMoney());
                            cashier.sale_of_goods();
                        }
                        else if (answer.equals("No")){
                            System.out.println(GREEN_BOLD_BRIGHT + "(Manager) Do you wanna order this items? (Y/N)" + TEXT_RESET);
                            answer = in.next();
                            if (answer.equals("Yes")){
                                String name_r = "", color = "";
                                double price_r = 0, height = 0, width = 0;
                                boolean avail_guarantie;

                                Thread.sleep(1000);
                                System.out.printf("\nName of item: ");
                                name_r = in.next();

                                Thread.sleep(1000);
                                System.out.printf("\nHeight: ");
                                height = in.nextDouble();

                                Thread.sleep(1000);
                                System.out.println("\nWidth: ");
                                width = in.nextDouble();

                                Thread.sleep(1000);
                                price = width * height;
                                System.out.printf("\nPrice %.2f", price);

                                Thread.sleep(1000);
                                avail_guarantie = true;

                                Thread.sleep(1000);
                                System.out.printf("\nColor: ");
                                color = in.next();

                                Thread.sleep(1000);
                                System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager) We place an order ... ..." + TEXT_RESET);

                                Thread.sleep(1000);
                                System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager)" + TEXT_RESET + " Your order has been placed! Go to the checkout and pay.");


                                OrderOfThings orderOfThings= new OrderOfThings(name_r, price, avail_guarantie, color, 1, height, width);
                                orderOfThings.addData(name_r, price, avail_guarantie, color, 1, height, width);

                                Thread.sleep(1000);
                                System.out.println(CYAN_BOLD_BRIGHT + "(Customers) Подходит к кассе ..." + TEXT_RESET);
                                Cashier cashier = new Cashier(price_r, Main.customers.get(size_c).getMoney());

                            }

                            System.out.println(CYAN_BOLD_BRIGHT + "(Customers) exits the store ..." + TEXT_RESET);
                            System.exit(0);
                        }
                    }
                    else if (price == -1){
                        Thread.sleep(1000);
                        System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager)" + " Do you wanna order this item?" + TEXT_RESET);
                        answer = ChooseORDER.choose(in.next());

                        if (answer.equals("Yes"))
                            OrderOfGoods.order_start();
                        else
                            System.exit(0);
                    }

                    break;
                case 2:

                    System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager) Okay, we only have Wall Lamps in stock with these colors: " + TEXT_RESET);
                    double color_r =  ProductSearch.searchByColor(floorStands);

                    if (color_r != -1 ){
                        Thread.sleep(1000);
                        System.out.println(GREEN_BOLD_BRIGHT + ns_manager + " (Manager)" + TEXT_RESET + " Do you want to buy this item? (Y/N)");

                        answer = ChooseORDER.choose(in.next());

                        if (answer.equals("Yes")) {
                            Cashier cashier = new Cashier(color_r, Main.customers.get(size_c).getMoney());
                            cashier.sale_of_goods();
                        }
                        else if (answer.equals("No")){
                            System.out.println(GREEN_BOLD_BRIGHT + "(Manager) Do you wanna order this items? (Y/N)" + TEXT_RESET);
                            answer = in.next();
                            if (answer.equals("Yes")){
                                String name_r = "", color = "";
                                double price_r = 0, height = 0, width = 0;
                                boolean avail_guarantie;

                                Thread.sleep(1000);
                                System.out.printf("\nName of item: ");
                                name_r = in.next();

                                Thread.sleep(1000);
                                System.out.printf("\nHeight: ");
                                height = in.nextDouble();

                                Thread.sleep(1000);
                                System.out.println("\nWidth: ");
                                width = in.nextDouble();

                                Thread.sleep(1000);
                                price = width * height;
                                System.out.printf("\nPrice %.2f", price);

                                Thread.sleep(1000);
                                avail_guarantie = true;

                                Thread.sleep(1000);
                                System.out.printf("\nColor: ");
                                color = in.next();

                                Thread.sleep(1000);
                                System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager) We place an order ... ..." + TEXT_RESET);

                                Thread.sleep(1000);
                                System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager)" + TEXT_RESET + " Your order has been placed! Go to the checkout and pay.");


                                OrderOfThings orderOfThings= new OrderOfThings(name_r, price, avail_guarantie, color, 1, height, width);
                                orderOfThings.addData(name_r, price, avail_guarantie, color, 1, height, width);

                                Thread.sleep(1000);
                                System.out.println(CYAN_BOLD_BRIGHT + ns_customers + "(Customers) Coming to the checkout ..." + TEXT_RESET);
                                Cashier cashier = new Cashier(price_r, Main.customers.get(size_c).getMoney());

                            }

                            System.out.println(CYAN_BOLD_BRIGHT + ns_customers + "(Customers) exits the store ..." + TEXT_RESET);
                            System.exit(0);
                        }
                    }
                    else if (color_r == -1){
                        Thread.sleep(1000);
                        System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager)" + " Do you wanna order this item?" + TEXT_RESET);
                        answer = ChooseORDER.choose(in.next());

                        if (answer.equals("Yes"))
                            OrderOfGoods.order_start();
                        else
                            System.exit(0);
                    }

                    break;
                case 3:


                    System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager) Okay, we only have Wall Lamps in stock with these colors: " + TEXT_RESET);

                    double color_price = 0;
                    color_price = ProductSearch.searchByColor_Price(floorStands);


                    if (color_price != -1 ){
                        Thread.sleep(1000);
                        System.out.println(GREEN_BOLD_BRIGHT + ns_manager + " (Manager)" + TEXT_RESET + " Do you want to buy this item? (Y/N)");

                        answer = ChooseORDER.choose(in.next());

                        if (answer.equals("Yes")) {
                            Cashier cashier = new Cashier(color_price, Main.customers.get(size_c).getMoney());
                            cashier.sale_of_goods();
                        }
                        else if (answer.equals("No")){
                            System.out.println(GREEN_BOLD_BRIGHT + "(Manager) Do you wanna order this items? (Y/N)" + TEXT_RESET);
                            answer = in.next();
                            if (answer.equals("Yes")){
                                String name_r = "", color = "";
                                double price_r = 0, height = 0, width = 0;
                                boolean avail_guarantie;

                                Thread.sleep(1000);
                                System.out.printf("\nName of item: ");
                                name_r = in.next();

                                Thread.sleep(1000);
                                System.out.printf("\nHeight: ");
                                height = in.nextDouble();

                                Thread.sleep(1000);
                                System.out.println("\nWidth: ");
                                width = in.nextDouble();

                                Thread.sleep(1000);
                                price = width * height;
                                System.out.printf("\nPrice %.2f", price);

                                Thread.sleep(1000);
                                avail_guarantie = true;

                                Thread.sleep(1000);
                                System.out.printf("\nColor: ");
                                color = in.next();

                                Thread.sleep(1000);
                                System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager) We place an order ... ..." + TEXT_RESET);

                                Thread.sleep(1000);
                                System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager)" + TEXT_RESET + " Your order has been placed! Go to the checkout and pay.");


                                OrderOfThings orderOfThings= new OrderOfThings(name_r, price, avail_guarantie, color, 1, height, width);
                                orderOfThings.addData(name_r, price, avail_guarantie, color, 1, height, width);

                                Thread.sleep(1000);
                                System.out.println(CYAN_BOLD_BRIGHT + ns_customers + "(Customers) Coming to the checkout ..." + TEXT_RESET);
                                Cashier cashier = new Cashier(price_r, Main.customers.get(size_c).getMoney());

                            }

                            System.out.println(CYAN_BOLD_BRIGHT + ns_customers + "(Customers) exits the store ..." + TEXT_RESET);
                            System.exit(0);
                        }
                    }
                    else if (color_price == -1){
                        Thread.sleep(1000);
                        System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager)" + " Do you wanna order this item?" + TEXT_RESET);
                        answer = ChooseORDER.choose(in.next());

                        if (answer.equals("Yes"))
                            OrderOfGoods.order_start();
                        else
                            System.exit(0);
                    }

                    break;
                default:
                    System.err.println("Try again.");

            }
        }
    }



    public void searchOfChair() throws SQLException, InterruptedException{
        Scanner in = new Scanner(System.in);
        DBHandler dbHandler = DBHandler.getInstance();

        int size_c = Main.customers.size() - 1;
        int size_m = Main.customers.size() - 1;
        int choose_c = 0;
        double price = 0;
        String answer = "";

        chairs = new ArrayList<Chair>();
        chairs = dbHandler.getChairs();

        chairs.get(chairs.size() - 1).getColor();


        Thread.sleep(1000);
        System.out.println(GREEN_BOLD_BRIGHT + ns_manager + " (Manager):" + TEXT_RESET + WHITE_BOLD_BRIGHT + " Are there any special requests? Colour? Price?" + TEXT_RESET);

        Thread.sleep(1000);
        System.out.println(GREEN_BOLD_BRIGHT + ns_manager + " (Manager):" + TEXT_RESET + WHITE_BOLD_BRIGHT + " Select 1.Price  2.Color  3.Color and Price" + TEXT_RESET);

        while (choose_c != 1 && choose_c != 2 && choose_c != 3) {
            choose_c = Main.customers.get(size_c).chooseOfProduct(in.nextInt());
            switch (choose_c) {
                case 1:
                    price = ProductSearch.searchByPrice(chairs);

                    if (price != -1 ){
                        Thread.sleep(1000);
                        System.out.println(GREEN_BOLD_BRIGHT + ns_manager + " (Manager)" + TEXT_RESET + " Do you want to buy this item? (Y/N)");

                        answer = ChooseORDER.choose(in.next());

                        if (answer.equals("Yes")) {
                            Cashier cashier = new Cashier(price, Main.customers.get(size_c).getMoney());
                            cashier.sale_of_goods();
                        }
                        else if (answer.equals("No")){
                            System.out.println(GREEN_BOLD_BRIGHT + "(Manager) Do you wanna order this items? (Y/N)" + TEXT_RESET);
                            answer = in.next();
                            if (answer.equals("Yes")){
                                String name_r = "", color = "";
                                double price_r = 0, height = 0, width = 0;
                                boolean avail_guarantie;

                                Thread.sleep(1000);
                                System.out.printf("\nName of item: ");
                                name_r = in.next();

                                Thread.sleep(1000);
                                System.out.printf("\nHeight: ");
                                height = in.nextDouble();

                                Thread.sleep(1000);
                                System.out.println("\nWidth: ");
                                width = in.nextDouble();

                                Thread.sleep(1000);
                                price = width * height;
                                System.out.printf("\nPrice %.2f", price);

                                Thread.sleep(1000);
                                avail_guarantie = true;

                                Thread.sleep(1000);
                                System.out.printf("\nColor: ");
                                color = in.next();

                                Thread.sleep(1000);
                                System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager) We place an order ... ..." + TEXT_RESET);

                                Thread.sleep(1000);
                                System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager)" + TEXT_RESET + " Your order has been placed! Go to the checkout and pay.");


                                OrderOfThings orderOfThings= new OrderOfThings(name_r, price, avail_guarantie, color, 1, height, width);
                                orderOfThings.addData(name_r, price, avail_guarantie, color, 1, height, width);

                                Thread.sleep(1000);
                                System.out.println(CYAN_BOLD_BRIGHT + "(Customers) Подходит к кассе ..." + TEXT_RESET);
                                Cashier cashier = new Cashier(price_r, Main.customers.get(size_c).getMoney());

                            }

                            System.out.println(CYAN_BOLD_BRIGHT + "(Customers) exits the store ..." + TEXT_RESET);
                            System.exit(0);
                        }
                    }
                    else if (price == -1){
                        Thread.sleep(1000);
                        System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager)" + " Do you wanna order this item?" + TEXT_RESET);
                        answer = ChooseORDER.choose(in.next());

                        if (answer.equals("Yes"))
                            OrderOfGoods.order_start();
                        else
                            System.exit(0);
                    }

                    break;
                case 2:

                    System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager) Okay, we only have Wall Lamps in stock with these colors: " + TEXT_RESET);
                    double color_r =  ProductSearch.searchByColor(chairs);

                    if (color_r != -1 ){
                        Thread.sleep(1000);
                        System.out.println(GREEN_BOLD_BRIGHT + ns_manager + " (Manager)" + TEXT_RESET + " Do you want to buy this item? (Y/N)");

                        answer = ChooseORDER.choose(in.next());

                        if (answer.equals("Yes")) {
                            Cashier cashier = new Cashier(color_r, Main.customers.get(size_c).getMoney());
                            cashier.sale_of_goods();
                        }
                        else if (answer.equals("No")){
                            System.out.println(GREEN_BOLD_BRIGHT + "(Manager) Do you wanna order this items? (Y/N)" + TEXT_RESET);
                            answer = in.next();
                            if (answer.equals("Yes")){
                                String name_r = "", color = "";
                                double price_r = 0, height = 0, width = 0;
                                boolean avail_guarantie;

                                Thread.sleep(1000);
                                System.out.printf("\nName of item: ");
                                name_r = in.next();

                                Thread.sleep(1000);
                                System.out.printf("\nHeight: ");
                                height = in.nextDouble();

                                Thread.sleep(1000);
                                System.out.println("\nWidth: ");
                                width = in.nextDouble();

                                Thread.sleep(1000);
                                price = width * height;
                                System.out.printf("\nPrice %.2f", price);

                                Thread.sleep(1000);
                                avail_guarantie = true;

                                Thread.sleep(1000);
                                System.out.printf("\nColor: ");
                                color = in.next();

                                Thread.sleep(1000);
                                System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager) We place an order ... ..." + TEXT_RESET);

                                Thread.sleep(1000);
                                System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager)" + TEXT_RESET + " Your order has been placed! Go to the checkout and pay.");


                                OrderOfThings orderOfThings= new OrderOfThings(name_r, price, avail_guarantie, color, 1, height, width);
                                orderOfThings.addData(name_r, price, avail_guarantie, color, 1, height, width);

                                Thread.sleep(1000);
                                System.out.println(CYAN_BOLD_BRIGHT + ns_customers + "(Customers) Coming to the checkout ..." + TEXT_RESET);
                                Cashier cashier = new Cashier(price_r, Main.customers.get(size_c).getMoney());

                            }

                            System.out.println(CYAN_BOLD_BRIGHT + ns_customers + "(Customers) exits the store ..." + TEXT_RESET);
                            System.exit(0);
                        }
                    }
                    else if (color_r == -1){
                        Thread.sleep(1000);
                        System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager)" + " Do you wanna order this item?" + TEXT_RESET);
                        answer = ChooseORDER.choose(in.next());

                        if (answer.equals("Yes"))
                            OrderOfGoods.order_start();
                        else
                            System.exit(0);
                    }

                    break;
                case 3:


                    System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager) Okay, we only have Wall Lamps in stock with these colors: " + TEXT_RESET);

                    double color_price = 0;
                    color_price = ProductSearch.searchByColor_Price(chairs);


                    if (color_price != -1 ){
                        Thread.sleep(1000);
                        System.out.println(GREEN_BOLD_BRIGHT + ns_manager + " (Manager)" + TEXT_RESET + " Do you want to buy this item? (Y/N)");

                        answer = ChooseORDER.choose(in.next());

                        if (answer.equals("Yes")) {
                            Cashier cashier = new Cashier(color_price, Main.customers.get(size_c).getMoney());
                            cashier.sale_of_goods();
                        }
                        else if (answer.equals("No")){
                            System.out.println(GREEN_BOLD_BRIGHT + "(Manager) Do you wanna order this items? (Y/N)" + TEXT_RESET);
                            answer = in.next();
                            if (answer.equals("Yes")){
                                String name_r = "", color = "";
                                double price_r = 0, height = 0, width = 0;
                                boolean avail_guarantie;

                                Thread.sleep(1000);
                                System.out.printf("\nName of item: ");
                                name_r = in.next();

                                Thread.sleep(1000);
                                System.out.printf("\nHeight: ");
                                height = in.nextDouble();

                                Thread.sleep(1000);
                                System.out.println("\nWidth: ");
                                width = in.nextDouble();

                                Thread.sleep(1000);
                                price = width * height;
                                System.out.printf("\nPrice %.2f", price);

                                Thread.sleep(1000);
                                avail_guarantie = true;

                                Thread.sleep(1000);
                                System.out.printf("\nColor: ");
                                color = in.next();

                                Thread.sleep(1000);
                                System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager) We place an order ... ..." + TEXT_RESET);

                                Thread.sleep(1000);
                                System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager)" + TEXT_RESET + " Your order has been placed! Go to the checkout and pay.");


                                OrderOfThings orderOfThings= new OrderOfThings(name_r, price, avail_guarantie, color, 1, height, width);
                                orderOfThings.addData(name_r, price, avail_guarantie, color, 1, height, width);

                                Thread.sleep(1000);
                                System.out.println(CYAN_BOLD_BRIGHT + ns_customers + "(Customers) Coming to the checkout ..." + TEXT_RESET);
                                Cashier cashier = new Cashier(price_r, Main.customers.get(size_c).getMoney());

                            }

                            System.out.println(CYAN_BOLD_BRIGHT + ns_customers + "(Customers) exits the store ..." + TEXT_RESET);
                            System.exit(0);
                        }
                    }
                    else if (color_price == -1){
                        Thread.sleep(1000);
                        System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager)" + " Do you wanna order this item?" + TEXT_RESET);
                        answer = ChooseORDER.choose(in.next());

                        if (answer.equals("Yes"))
                            OrderOfGoods.order_start();
                        else
                            System.exit(0);
                    }

                    break;
                default:
                    System.err.println("Try again.");

            }
        }
    }

    public void searchOfTV() throws SQLException, InterruptedException{
        Scanner in = new Scanner(System.in);
        DBHandler dbHandler = DBHandler.getInstance();

        int size_c = Main.customers.size() - 1;
        int size_m = Main.customers.size() - 1;
        int choose_c = 0;
        double price = 0;
        String answer = "";

        tvs = new ArrayList<TV>();
        tvs = dbHandler.getTV();

        Thread.sleep(1000);
        System.out.println(GREEN_BOLD_BRIGHT + getFirst_name() + " " + getSecond_name() + "(Manager):" + TEXT_RESET + WHITE_BOLD_BRIGHT + " Are there any special requests? Colour? Price?" + TEXT_RESET);

        Thread.sleep(1000);
        System.out.println(GREEN_BOLD_BRIGHT + getFirst_name() + " " + getSecond_name() + "(Manager):" + TEXT_RESET + WHITE_BOLD_BRIGHT + " Select 1.Price  2.Color  3.Color and Price" + TEXT_RESET);


        while (choose_c != 1 && choose_c != 2 && choose_c != 3) {
            choose_c = Main.customers.get(size_c).chooseOfProduct(in.nextInt());
            switch (choose_c) {
                case 1:
                    price = ProductSearch.searchByPrice(tvs);

                    if (price != -1) {
                        Thread.sleep(1000);
                        System.out.println(GREEN_BOLD_BRIGHT + ns_manager + " (Manager)" + TEXT_RESET + " Do you want to buy this item? (Y/N)");

                        answer = ChooseORDER.choose(in.next());

                        if (answer.equals("Yes")) {
                            Cashier cashier = new Cashier(price, Main.customers.get(size_c).getMoney());
                            cashier.sale_of_goods();
                        } else if (answer.equals("No")) {
                            System.out.println(GREEN_BOLD_BRIGHT + "(Manager) Do you wanna order this items? (Y/N)" + TEXT_RESET);
                            answer = in.next();
                            if (answer.equals("Yes")) {
                                String name_r = "", color = "";
                                double price_r = 0, height = 0, width = 0;
                                boolean avail_guarantie;

                                Thread.sleep(1000);
                                System.out.printf("\nName of item: ");
                                name_r = in.next();

                                Thread.sleep(1000);
                                System.out.printf("\nHeight: ");
                                height = in.nextDouble();

                                Thread.sleep(1000);
                                System.out.println("\nWidth: ");
                                width = in.nextDouble();

                                Thread.sleep(1000);
                                price = width * height;
                                System.out.printf("\nPrice %.2f", price);

                                Thread.sleep(1000);
                                avail_guarantie = true;

                                Thread.sleep(1000);
                                System.out.printf("\nColor: ");
                                color = in.next();

                                Thread.sleep(1000);
                                System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager) We place an order ... ..." + TEXT_RESET);

                                Thread.sleep(1000);
                                System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager)" + TEXT_RESET + " Your order has been placed! Go to the checkout and pay.");


                                OrderOfThings orderOfThings = new OrderOfThings(name_r, price, avail_guarantie, color, 1, height, width);
                                orderOfThings.addData(name_r, price, avail_guarantie, color, 1, height, width);

                                Thread.sleep(1000);
                                System.out.println(CYAN_BOLD_BRIGHT + "(Customers) Подходит к кассе ..." + TEXT_RESET);
                                Cashier cashier = new Cashier(price_r, Main.customers.get(size_c).getMoney());

                            }

                            System.out.println(CYAN_BOLD_BRIGHT + "(Customers) exits the store ..." + TEXT_RESET);
                            System.exit(0);
                        }
                    } else if (price == -1) {
                        Thread.sleep(1000);
                        System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager)" + " Do you wanna order this item?" + TEXT_RESET);
                        answer = ChooseORDER.choose(in.next());

                        if (answer.equals("Yes"))
                            OrderOfGoods.order_start();
                        else
                            System.exit(0);
                    }

                    break;
                case 2:

                    System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager) Okay, we only have Wall Lamps in stock with these colors: " + TEXT_RESET);
                    double color_r = ProductSearch.searchByColor(tvs);

                    if (color_r != -1) {
                        Thread.sleep(1000);
                        System.out.println(GREEN_BOLD_BRIGHT + ns_manager + " (Manager)" + TEXT_RESET + " Do you want to buy this item? (Y/N)");

                        answer = ChooseORDER.choose(in.next());

                        if (answer.equals("Yes")) {
                            Cashier cashier = new Cashier(color_r, Main.customers.get(size_c).getMoney());
                            cashier.sale_of_goods();
                        } else if (answer.equals("No")) {
                            System.out.println(GREEN_BOLD_BRIGHT + "(Manager) Do you wanna order this items? (Y/N)" + TEXT_RESET);
                            answer = in.next();
                            if (answer.equals("Yes")) {
                                String name_r = "", color = "";
                                double price_r = 0, height = 0, width = 0;
                                boolean avail_guarantie;

                                Thread.sleep(1000);
                                System.out.printf("\nName of item: ");
                                name_r = in.next();

                                Thread.sleep(1000);
                                System.out.printf("\nHeight: ");
                                height = in.nextDouble();

                                Thread.sleep(1000);
                                System.out.println("\nWidth: ");
                                width = in.nextDouble();

                                Thread.sleep(1000);
                                price = width * height;
                                System.out.printf("\nPrice %.2f", price);

                                Thread.sleep(1000);
                                avail_guarantie = true;

                                Thread.sleep(1000);
                                System.out.printf("\nColor: ");
                                color = in.next();

                                Thread.sleep(1000);
                                System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager) We place an order ... ..." + TEXT_RESET);

                                Thread.sleep(1000);
                                System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager)" + TEXT_RESET + " Your order has been placed! Go to the checkout and pay.");


                                OrderOfThings orderOfThings = new OrderOfThings(name_r, price, avail_guarantie, color, 1, height, width);
                                orderOfThings.addData(name_r, price, avail_guarantie, color, 1, height, width);

                                Thread.sleep(1000);
                                System.out.println(CYAN_BOLD_BRIGHT + ns_customers + "(Customers) Coming to the checkout ..." + TEXT_RESET);
                                Cashier cashier = new Cashier(price_r, Main.customers.get(size_c).getMoney());

                            }

                            System.out.println(CYAN_BOLD_BRIGHT + ns_customers + "(Customers) exits the store ..." + TEXT_RESET);
                            System.exit(0);
                        }
                    } else if (color_r == -1) {
                        Thread.sleep(1000);
                        System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager)" + " Do you wanna order this item?" + TEXT_RESET);
                        answer = ChooseORDER.choose(in.next());

                        if (answer.equals("Yes"))
                            OrderOfGoods.order_start();
                        else
                            System.exit(0);
                    }

                    break;
                case 3:


                    System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager) Okay, we only have Wall Lamps in stock with these colors: " + TEXT_RESET);

                    double color_price = 0;
                    color_price = ProductSearch.searchByColor_Price(tvs);


                    if (color_price != -1) {
                        Thread.sleep(1000);
                        System.out.println(GREEN_BOLD_BRIGHT + ns_manager + " (Manager)" + TEXT_RESET + " Do you want to buy this item? (Y/N)");

                        answer = ChooseORDER.choose(in.next());

                        if (answer.equals("Yes")) {
                            Cashier cashier = new Cashier(color_price, Main.customers.get(size_c).getMoney());
                            cashier.sale_of_goods();
                        } else if (answer.equals("No")) {
                            System.out.println(GREEN_BOLD_BRIGHT + "(Manager) Do you wanna order this items? (Y/N)" + TEXT_RESET);
                            answer = in.next();
                            if (answer.equals("Yes")) {
                                String name_r = "", color = "";
                                double price_r = 0, height = 0, width = 0;
                                boolean avail_guarantie;

                                Thread.sleep(1000);
                                System.out.printf("\nName of item: ");
                                name_r = in.next();

                                Thread.sleep(1000);
                                System.out.printf("\nHeight: ");
                                height = in.nextDouble();

                                Thread.sleep(1000);
                                System.out.println("\nWidth: ");
                                width = in.nextDouble();

                                Thread.sleep(1000);
                                price = width * height;
                                System.out.printf("\nPrice %.2f", price);

                                Thread.sleep(1000);
                                avail_guarantie = true;

                                Thread.sleep(1000);
                                System.out.printf("\nColor: ");
                                color = in.next();

                                Thread.sleep(1000);
                                System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager) We place an order ... ..." + TEXT_RESET);

                                Thread.sleep(1000);
                                System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager)" + TEXT_RESET + " Your order has been placed! Go to the checkout and pay.");


                                OrderOfThings orderOfThings = new OrderOfThings(name_r, price, avail_guarantie, color, 1, height, width);
                                orderOfThings.addData(name_r, price, avail_guarantie, color, 1, height, width);

                                Thread.sleep(1000);
                                System.out.println(CYAN_BOLD_BRIGHT + ns_customers + "(Customers) Coming to the checkout ..." + TEXT_RESET);
                                Cashier cashier = new Cashier(price_r, Main.customers.get(size_c).getMoney());

                            }

                            System.out.println(CYAN_BOLD_BRIGHT + ns_customers + "(Customers) exits the store ..." + TEXT_RESET);
                            System.exit(0);
                        }
                    } else if (color_price == -1) {
                        Thread.sleep(1000);
                        System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager)" + " Do you wanna order this item?" + TEXT_RESET);
                        answer = ChooseORDER.choose(in.next());

                        if (answer.equals("Yes"))
                            OrderOfGoods.order_start();
                        else
                            System.exit(0);
                    }

                    break;
                default:
                    System.err.println("Try again.");

            }
        }
    }



    public void searchOfShowerHeads() throws SQLException, InterruptedException{
        Scanner in = new Scanner(System.in);
        DBHandler dbHandler = DBHandler.getInstance();

        int size_c = Main.customers.size() - 1;
        int size_m = Main.customers.size() - 1;
        int choose_c = 0;
        double price = 0;
        String answer = "";

        showerHeads = new ArrayList<ShowerHeads>();
        showerHeads = dbHandler.getShowerHeads();

        Thread.sleep(1000);
        System.out.println(GREEN_BOLD_BRIGHT + getFirst_name() + " " + getSecond_name() + "(Manager):" + TEXT_RESET + WHITE_BOLD_BRIGHT + " Are there any special requests? Colour? Price?" + TEXT_RESET);

        Thread.sleep(1000);
        System.out.println(GREEN_BOLD_BRIGHT + getFirst_name() + " " + getSecond_name() + "(Manager):" + TEXT_RESET + WHITE_BOLD_BRIGHT + " Select 1.Price  2.Color  3.Color and Price" + TEXT_RESET);


        while (choose_c != 1 && choose_c != 2 && choose_c != 3) {
            choose_c = Main.customers.get(size_c).chooseOfProduct(in.nextInt());
            switch (choose_c) {
                case 1:
                    price = ProductSearch.searchByPrice(showerHeads);

                    if (price != -1) {
                        Thread.sleep(1000);
                        System.out.println(GREEN_BOLD_BRIGHT + ns_manager + " (Manager)" + TEXT_RESET + " Do you want to buy this item? (Y/N)");

                        answer = ChooseORDER.choose(in.next());

                        if (answer.equals("Yes")) {
                            Cashier cashier = new Cashier(price, Main.customers.get(size_c).getMoney());
                            cashier.sale_of_goods();
                        } else if (answer.equals("No")) {
                            System.out.println(GREEN_BOLD_BRIGHT + "(Manager) Do you wanna order this items? (Y/N)" + TEXT_RESET);
                            answer = in.next();
                            if (answer.equals("Yes")) {
                                String name_r = "", color = "";
                                double price_r = 0, height = 0, width = 0;
                                boolean avail_guarantie;

                                Thread.sleep(1000);
                                System.out.printf("\nName of item: ");
                                name_r = in.next();

                                Thread.sleep(1000);
                                System.out.printf("\nHeight: ");
                                height = in.nextDouble();

                                Thread.sleep(1000);
                                System.out.println("\nWidth: ");
                                width = in.nextDouble();

                                Thread.sleep(1000);
                                price = width * height;
                                System.out.printf("\nPrice %.2f", price);

                                Thread.sleep(1000);
                                avail_guarantie = true;

                                Thread.sleep(1000);
                                System.out.printf("\nColor: ");
                                color = in.next();

                                Thread.sleep(1000);
                                System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager) We place an order ... ..." + TEXT_RESET);

                                Thread.sleep(1000);
                                System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager)" + TEXT_RESET + " Your order has been placed! Go to the checkout and pay.");


                                OrderOfThings orderOfThings = new OrderOfThings(name_r, price, avail_guarantie, color, 1, height, width);
                                orderOfThings.addData(name_r, price, avail_guarantie, color, 1, height, width);

                                Thread.sleep(1000);
                                System.out.println(CYAN_BOLD_BRIGHT + "(Customers) Подходит к кассе ..." + TEXT_RESET);
                                Cashier cashier = new Cashier(price_r, Main.customers.get(size_c).getMoney());

                            }

                            System.out.println(CYAN_BOLD_BRIGHT + "(Customers) exits the store ..." + TEXT_RESET);
                            System.exit(0);
                        }
                    } else if (price == -1) {
                        Thread.sleep(1000);
                        System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager)" + " Do you wanna order this item?" + TEXT_RESET);
                        answer = ChooseORDER.choose(in.next());

                        if (answer.equals("Yes"))
                            OrderOfGoods.order_start();
                        else
                            System.exit(0);
                    }

                    break;
                case 2:

                    System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager) Okay, we only have Wall Lamps in stock with these colors: " + TEXT_RESET);
                    double color_r = ProductSearch.searchByColor(showerHeads);

                    if (color_r != -1) {
                        Thread.sleep(1000);
                        System.out.println(GREEN_BOLD_BRIGHT + ns_manager + " (Manager)" + TEXT_RESET + " Do you want to buy this item? (Y/N)");

                        answer = ChooseORDER.choose(in.next());

                        if (answer.equals("Yes")) {
                            Cashier cashier = new Cashier(color_r, Main.customers.get(size_c).getMoney());
                            cashier.sale_of_goods();
                        } else if (answer.equals("No")) {
                            System.out.println(GREEN_BOLD_BRIGHT + "(Manager) Do you wanna order this items? (Y/N)" + TEXT_RESET);
                            answer = in.next();
                            if (answer.equals("Yes")) {
                                String name_r = "", color = "";
                                double price_r = 0, height = 0, width = 0;
                                boolean avail_guarantie;

                                Thread.sleep(1000);
                                System.out.printf("\nName of item: ");
                                name_r = in.next();

                                Thread.sleep(1000);
                                System.out.printf("\nHeight: ");
                                height = in.nextDouble();

                                Thread.sleep(1000);
                                System.out.println("\nWidth: ");
                                width = in.nextDouble();

                                Thread.sleep(1000);
                                price = width * height;
                                System.out.printf("\nPrice %.2f", price);

                                Thread.sleep(1000);
                                avail_guarantie = true;

                                Thread.sleep(1000);
                                System.out.printf("\nColor: ");
                                color = in.next();

                                Thread.sleep(1000);
                                System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager) We place an order ... ..." + TEXT_RESET);

                                Thread.sleep(1000);
                                System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager)" + TEXT_RESET + " Your order has been placed! Go to the checkout and pay.");


                                OrderOfThings orderOfThings = new OrderOfThings(name_r, price, avail_guarantie, color, 1, height, width);
                                orderOfThings.addData(name_r, price, avail_guarantie, color, 1, height, width);

                                Thread.sleep(1000);
                                System.out.println(CYAN_BOLD_BRIGHT + ns_customers + "(Customers) Coming to the checkout ..." + TEXT_RESET);
                                Cashier cashier = new Cashier(price_r, Main.customers.get(size_c).getMoney());

                            }

                            System.out.println(CYAN_BOLD_BRIGHT + ns_customers + "(Customers) exits the store ..." + TEXT_RESET);
                            System.exit(0);
                        }
                    } else if (color_r == -1) {
                        Thread.sleep(1000);
                        System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager)" + " Do you wanna order this item?" + TEXT_RESET);
                        answer = ChooseORDER.choose(in.next());

                        if (answer.equals("Yes"))
                            OrderOfGoods.order_start();
                        else
                            System.exit(0);
                    }

                    break;
                case 3:


                    System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager) Okay, we only have Wall Lamps in stock with these colors: " + TEXT_RESET);

                    double color_price = 0;
                    color_price = ProductSearch.searchByColor_Price(showerHeads);


                    if (color_price != -1) {
                        Thread.sleep(1000);
                        System.out.println(GREEN_BOLD_BRIGHT + ns_manager + " (Manager)" + TEXT_RESET + " Do you want to buy this item? (Y/N)");

                        answer = ChooseORDER.choose(in.next());

                        if (answer.equals("Yes")) {
                            Cashier cashier = new Cashier(color_price, Main.customers.get(size_c).getMoney());
                            cashier.sale_of_goods();
                        } else if (answer.equals("No")) {
                            System.out.println(GREEN_BOLD_BRIGHT + "(Manager) Do you wanna order this items? (Y/N)" + TEXT_RESET);
                            answer = in.next();
                            if (answer.equals("Yes")) {
                                String name_r = "", color = "";
                                double price_r = 0, height = 0, width = 0;
                                boolean avail_guarantie;

                                Thread.sleep(1000);
                                System.out.printf("\nName of item: ");
                                name_r = in.next();

                                Thread.sleep(1000);
                                System.out.printf("\nHeight: ");
                                height = in.nextDouble();

                                Thread.sleep(1000);
                                System.out.println("\nWidth: ");
                                width = in.nextDouble();

                                Thread.sleep(1000);
                                price = width * height;
                                System.out.printf("\nPrice %.2f", price);

                                Thread.sleep(1000);
                                avail_guarantie = true;

                                Thread.sleep(1000);
                                System.out.printf("\nColor: ");
                                color = in.next();

                                Thread.sleep(1000);
                                System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager) We place an order ... ..." + TEXT_RESET);

                                Thread.sleep(1000);
                                System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager)" + TEXT_RESET + " Your order has been placed! Go to the checkout and pay.");


                                OrderOfThings orderOfThings = new OrderOfThings(name_r, price, avail_guarantie, color, 1, height, width);
                                orderOfThings.addData(name_r, price, avail_guarantie, color, 1, height, width);

                                Thread.sleep(1000);
                                System.out.println(CYAN_BOLD_BRIGHT + ns_customers + "(Customers) Coming to the checkout ..." + TEXT_RESET);
                                Cashier cashier = new Cashier(price_r, Main.customers.get(size_c).getMoney());

                            }

                            System.out.println(CYAN_BOLD_BRIGHT + ns_customers + "(Customers) exits the store ..." + TEXT_RESET);
                            System.exit(0);
                        }
                    } else if (color_price == -1) {
                        Thread.sleep(1000);
                        System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager)" + " Do you wanna order this item?" + TEXT_RESET);
                        answer = ChooseORDER.choose(in.next());

                        if (answer.equals("Yes"))
                            OrderOfGoods.order_start();
                        else
                            System.exit(0);
                    }

                    break;
                default:
                    System.err.println("Try again.");

            }
        }
    }


}
