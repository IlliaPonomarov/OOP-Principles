package com.company.Interface;
import com.company.Main;
import com.company.Things.Product;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public interface ProductSearch extends ConsoleColors,  ChooseORDER {
    String ns_customers = Main.customers.get(Main.customers.size() - 1).getFirst_name() + " " + Main.customers.get(Main.customers.size() - 1).getSecond_name();
    String ns_manager = Main.manager.get(Main.manager.size() - 1).getFirst_name() + " " + Main.manager.get(Main.manager.size() - 1).getSecond_name();

    static double searchByPrice(ArrayList<? extends Product> listOf) throws InterruptedException, SQLException {
        Thread.sleep(1000);
        System.out.println(GREEN_BOLD_BRIGHT + Main.manager.get(Main.customers.size() - 1).getFirst_name() + " " + Main.manager.get(Main.customers.size() - 1).getSecond_name() + " (Manager)" + WHITE_BOLD_BRIGHT + " Do you want the product 1. For the lowest price 2. For the highest price 3. Tell yourself how much you expect?" + TEXT_RESET);
        Scanner in = new Scanner(System.in);
        ArrayList<Double> price_list = new ArrayList<Double>();
        ArrayList<Integer> count_of_price = new ArrayList<>();

        for (int i = 0; i < listOf.size() - 1; i++) {
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
                System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager)" + TEXT_RESET + "  We have this product for such a price: ");


                for (int j = 0; j < price_list.size(); j++) {
                    if (price_list.get(j) <= finalIi) {
                        System.out.printf("%d) Price: %.2f\n", count_of_price.get(j), price_list.get(j));

                    }
                }

                System.out.println(GREEN_BOLD_BRIGHT + ns_manager + " Choose a price: ");
                choose = in.nextInt();
                for (int j = 1; j <= count_of_price.size() - 1; j++) {
                    if (count_of_price.contains(choose)) {
                        System.out.printf(CYAN_BOLD_BRIGHT + "You chose: %d) %.2f.\n", count_of_price.get(j), price_list.get(j));
                        System.out.println("Do you want to buy it? (Y/N)" + TEXT_RESET);
                        return price_list.get(j);
                    }
                }

                break;
        }


        return -1;
    }

    static double searchByColor(ArrayList<? extends Product> listOf) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        ArrayList<String> colors = new ArrayList<String>();
        ArrayList<Integer> count_of_colors = new ArrayList<>();
        int choose = 0;

        listOf.stream().forEach(System.out::println);

        listOf.stream().forEach(p-> colors.add(p.getColor()));
        Thread.sleep(1000);
        System.out.println(GREEN_BOLD_BRIGHT + ns_manager + "(Manager) We only stock products with these colors:: " + TEXT_RESET);

        for (int i = 0; i < colors.size(); i++){
            System.out.printf("%d) %s\n", i, colors.get(i));
            Collections.addAll(count_of_colors, i);
        }

        Thread.sleep(1000);
        System.out.println(GREEN_BOLD_BRIGHT  + ns_manager + "(Manager) Please, choose is: " + TEXT_RESET);

        choose = in.nextInt();
        for (int i = 0; i < count_of_colors.size() ; i++){
            if (count_of_colors.contains(choose)){
                Thread.sleep(1000);

                System.out.printf(GREEN_BOLD_BRIGHT  + ns_manager + "(Manager) You chose %d) %s\n", i, colors.get(choose) + TEXT_RESET);

                return listOf.get(choose).getPrice();
            }
        }

        return -1;
    }

    static double searchByColor_Price(ArrayList<? extends Product> listOf) throws SQLException, InterruptedException {
        double price = searchByPrice(listOf);
        double color = searchByColor(listOf);
        System.out.printf("Price: %.2f\nColor: %s\n", price, color);



        ArrayList<String> colors_array = new ArrayList<String>();
        ArrayList<Double> price_array = new ArrayList<Double>();

        listOf.stream().forEach(product -> price_array.add(product.getPrice()));
        listOf.stream().forEach(product -> colors_array.add(product.getColor()));


        for(int i = 0; i < listOf.size(); i++){
            if (price_array.contains(price) && colors_array.contains(color)) {
                System.out.println("Товар с такими параметрами существует!");
                return price;
            }
        }



        return -1;

    }

}

