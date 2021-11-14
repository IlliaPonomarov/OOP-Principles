package com.company.Interface;

import com.company.Main;
import com.company.Things.Product;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public interface ProductSearch extends ConsoleColors {

    static boolean searchByPrice(ArrayList<? extends Product> listOf, int price) throws InterruptedException, SQLException {
        Thread.sleep(1000);
        System.out.println(GREEN_BOLD_BRIGHT + Main.manager.get(Main.customers.size() - 1).getFirst_name() + " " + Main.manager.get(Main.customers.size() - 1).getSecond_name() + " (Manager) You want the product 1. For the lowest price 2. For the highest price 3. Tell yourself how much you expect?" + TEXT_RESET);
        Scanner in = new Scanner(System.in);
        ArrayList<Double> price_list = new ArrayList<Double>();

        for (int i = 0; i < listOf.size(); i++){
            Collections.addAll(price_list, listOf.get(i).getPrice());
        }

        Collections.sort(price_list);

        int i = Main.customers.get(Main.customers.size() - 1).chooseOfProduct(in.nextInt());

        switch (i){
            case 1:
                double lower = price_list.get(0) ;
                System.out.println(lower);
                break;
            case 2:
                double high = price_list.get(price_list.size() - 1);
                System.out.printf("Higher price: %.2f", high);
                break;

            case 3:
                double ii = 0.0;
                double finalIi;
                String answer_YN = "";

                Thread.sleep(1000);
                System.out.println(CYAN_BOLD_BRIGHT + Main.customers.get(Main.customers.size() - 1).getFirst_name() + " " + Main.customers.get(Main.customers.size() - 1).getSecond_name() + "(Customer): " + TEXT_RESET + WHITE_BOLD_BRIGHT + "I want a price no higher than: " + TEXT_RESET);
                Thread.sleep(1000);

                ii = in.nextDouble();
                finalIi = ii;

                price_list.stream().filter(p-> p <= finalIi).forEach(System.out::println);
                for (int j = 0; j < price_list.size() - 1; j++) {
                    if (price_list.get(j) <= finalIi){
                        System.out.println(price_list.get(j));
                    }else {
                        while (!answer_YN.toLowerCase().equals("y") || !answer_YN.toLowerCase().equals("n")) {
                            Thread.sleep(1000);
                            System.out.println(Main.manager.get(Main.manager.size() - 1).getFirst_name() + " " + Main.manager.get(Main.manager.size() - 1).getSecond_name() + "(Manager) Unfortunately, there is no product with such a price. Do you want to place an order? (Y/N): ");
                            answer_YN = in.next();
                            if (answer_YN.toLowerCase().equals("y")){
                                Thread.sleep(1000);
                                System.out.println("You chose Yes.");

                                return true;

                            }else if (answer_YN.toLowerCase().equals("n")){
                                Thread.sleep(1000);
                                System.out.println("You chose No.");
                                return false;
                            }else {
                                Thread.sleep(1000);
                                System.err.println("Can you try again.");
                            }

                        }

                    }
                }
                    


                break;
        }


        return true;
    }
    static void searchByColor(String color){}
    static void searchByColor_Price(int price, String color){}
}
