package com.company.Interface;

import com.company.Things.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public interface ChooseORDER {
    public static void setSelect(ArrayList<? extends Product> listOf, int select) throws SQLException, InterruptedException {

        switch (select) {
            case 1:
                ProductSearch.searchByPrice(listOf);
                break;
            case 2:
                ProductSearch.searchByColor(listOf);
                break;
            case 3:
                ProductSearch.searchByColor_Price(listOf);
                break;
        }
    }

    public static String choose(String answer_YN) throws SQLException, InterruptedException {
        Scanner in = new Scanner(System.in);

        while (!answer_YN.toLowerCase().equals("y") || !answer_YN.toLowerCase().equals("n")) {
            Thread.sleep(1000);


            if (answer_YN.toLowerCase().equals("y")) {

                Thread.sleep(1000);
                System.out.println("You chose Yes.");
                return "Yes";

            } else if (answer_YN.toLowerCase().equals("n")) {

                // Написать симуляцию выхода из магазина
                Thread.sleep(1000);
                System.out.println("You chose No.");
                return "No";

            } else {
                Thread.sleep(1000);
                System.err.println("Can you try again.");
            }
        }
        return  "";
    }
}
