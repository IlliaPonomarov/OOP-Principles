package com.company.Interface;
import com.company.Main;
import com.company.Things.Product;
import java.util.ArrayList;
import java.util.Scanner;

public interface OrderOfGoods {
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

                Thread.sleep(1000);
                System.out.println("You chose Yes.");


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
