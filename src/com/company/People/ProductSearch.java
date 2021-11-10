package com.company.People;

import com.company.ConsoleColors;
import com.company.Main;
import com.company.Things.Product;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Stream;

public interface ProductSearch extends ConsoleColors {

    static void searchByPrice(ArrayList<? extends Product> listOf, int price) throws InterruptedException, SQLException {
        System.out.println("Вы хотите товар 1.За самую низкую цену 2.За самую высокую цену 3. Скажите сами, на какую сумму вы расчитываете.");
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
                System.out.printf("Higher price: %f", high);
                break;

            case 3:
                double ii = 0.0;
                System.out.println(CYAN_BOLD_BRIGHT + Main.customers.get(Main.customers.size() - 1).getFirst_name() + " " + Main.customers.get(Main.customers.size() - 1).getSecond_name() + "(Customer): " + TEXT_RESET + WHITE_BOLD_BRIGHT + "I want a price no higher than: " + TEXT_RESET);
                ii = in.nextDouble();
                double finalIi = ii;


                price_list.stream().filter(p-> p <= finalIi).forEach(System.out::println);

                break;
        }



    }
    static void searchByColor(String color){}
    static void searchByColor_Price(int price, String color){}
}
