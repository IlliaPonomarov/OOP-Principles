package com.company.Interface;

import com.company.Main;
import com.company.Things.Product;

import javax.print.attribute.standard.OrientationRequested;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Stream;

public interface ProductSearch extends ConsoleColors {

    static double searchByPrice(ArrayList<? extends Product> listOf) throws InterruptedException, SQLException {
        Thread.sleep(1000);
        System.out.println(GREEN_BOLD_BRIGHT + Main.manager.get(Main.customers.size() - 1).getFirst_name() + " " + Main.manager.get(Main.customers.size() - 1).getSecond_name() + " (Manager)" + WHITE_BOLD_BRIGHT + " Do you want the product 1. For the lowest price 2. For the highest price 3. Tell yourself how much you expect?" + TEXT_RESET);
        Scanner in = new Scanner(System.in);
        ArrayList<Double> price_list = new ArrayList<Double>();
        ArrayList<Integer> count_of_price = new ArrayList<>();

        for (int i = 0; i < listOf.size(); i++) {
            Collections.addAll(price_list, listOf.get(i).getPrice());
            Collections.addAll(count_of_price, i + 1);
        }

        Collections.sort(price_list);

        int i = Main.customers.get(Main.customers.size() - 1).chooseOfProduct(in.nextInt()), choose = 0;

        switch (i) {
            case 1:
                double lower = price_list.get(0);
                System.out.printf("Lower price: %.2f\n", lower);
                return lower;
            case 2:
                double high = price_list.get(price_list.size() - 1);
                System.out.printf("Higher price: %.2f\n", high);
                return high;


            case 3:
                double ii = 0.0;
                double finalIi;
                String answer_YN = "";

                Thread.sleep(1000);
                System.out.println(CYAN_BOLD_BRIGHT + Main.customers.get(Main.customers.size() - 1).getFirst_name() + " " + Main.customers.get(Main.customers.size() - 1).getSecond_name() + "(Customer): " + TEXT_RESET + WHITE_BOLD_BRIGHT + "I want a price no higher than: " + TEXT_RESET);
                Thread.sleep(1000);

                ii = in.nextDouble();
                finalIi = ii;


                System.out.println("Менеджер: Мы имеем этот товар за такую цену: ");
                for (int j = 0; j < price_list.size(); j++) {

                    if (price_list.get(j) <= finalIi) {
                        System.out.printf("%d) Price: %.2f\n", count_of_price.get(j), price_list.get(j));

                    }
                }

                System.out.println("Менеджер: Выберите цену ");
                choose = in.nextInt();
                for (int j = 1; j <= count_of_price.size() - 1; j++) {
                    if (count_of_price.contains(choose)) {
                        System.out.printf("Вы выбрали %d) %.2f.\n", count_of_price.get(j), price_list.get(j));
                        return price_list.get(j);
                    } else {
                      OrderStart.order_start();
                    }
                }

                break;
        }


        return 0;
    }
    static String searchByColor(ArrayList<? extends Product> listOf) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        ArrayList<String> colors = new ArrayList<String>();
        ArrayList<Integer> count_of_colors = new ArrayList<>();
        int choose = 0;

        listOf.stream().forEach(p-> colors.add(p.getColor()));
        System.out.println("Менеджер: Мы имеем в наличии только товары с такими цветами: ");

        for (int i = 0; i < colors.size(); i++){
            System.out.printf("%d) %s\n", i+1, colors.get(i));
            Collections.addAll(count_of_colors, i + 1);
        }

        System.out.println("Менеджер: Выберите цвет: ");

        choose = in.nextInt();
        for (int i = 1; i <= count_of_colors.size() - 1; i++){
            if (count_of_colors.contains(choose)){
                System.out.printf("Менеджер: Вы выбрали %d) %s\n", count_of_colors.get(i), colors.get(i));
                return colors.get(i);
            }else{
                OrderStart.order_start();
            }
        }

        return "";
    }


    static void searchByColor_Price(ArrayList<? extends Product> listOf) throws SQLException, InterruptedException {
        double price = searchByPrice(listOf);
        String color = searchByColor(listOf);
        System.out.printf("Price: %.2f\nColor: %s\n", price, color);

        ArrayList<String> colors_array = new ArrayList<String>();
        ArrayList<Double> price_array = new ArrayList<Double>();

        listOf.stream().forEach(product -> price_array.add(product.getPrice()));
        listOf.stream().forEach(product -> colors_array.add(product.getColor()));


        for(int i = 0; i < listOf.size(); i++){
            if (price_array.contains(price) && colors_array.contains(color)) {
                System.out.println("Товар с такими параметрами существует!");
            }
        }


    }

}

interface OrderStart {
    static void order_start() throws InterruptedException {
        Scanner in = new Scanner(System.in);
        String answer_YN = "";

        while (!answer_YN.toLowerCase().equals("y") || !answer_YN.toLowerCase().equals("n")) {
            Thread.sleep(1000);
            System.out.println(
                    Main.manager.get(Main.manager.size() - 1).getFirst_name() + " "
                            + Main.manager.get(Main.manager.size() - 1).getSecond_name() +
                            "(Manager) Unfortunately, there is no product with such a price. Do you want to place an order? (Y/N): "
            );

            answer_YN = in.next();

            if (answer_YN.toLowerCase().equals("y")) {

                //
                Thread.sleep(1000);
                System.out.println("You chose Yes.");
                OrderStart.order_start();


            } else if (answer_YN.toLowerCase().equals("n")) {

                // Написать симуляцию выхода из магазина
                Thread.sleep(1000);
                System.out.println("You chose No.");

            } else {
                Thread.sleep(1000);
                System.err.println("Can you try again.");
            }

        }

      }
    }
