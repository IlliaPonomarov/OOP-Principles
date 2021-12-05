package com.company;

import com.company.Data.DBHandler;
import com.company.Interface.ConsoleColors;
import com.company.People.Cashier;
import com.company.People.Person;
import  java.lang.InterruptedException;
import java.sql.SQLException;
import java.util.*;
import java.util.Scanner;

//@author Illia Ponomarov
//@version 1.8

public class Main implements ConsoleColors {
    public static ArrayList<Person> customers;
    public static ArrayList<Person> manager;
    public static ArrayList<Cashier> cashiers;

    /*
    * =============================================================================================================================================== *
    *                                                                                                                                                 *
    * This project uses the SQLITE database, so before starting the project, you need to connect the driver, which is located in the "lib" folder.    *
    *  For IntelliJIDEA: FILE -> PROJECT STRUCTER -> LIBRARIES -> click "+" -> Java -> (select our driver from the folder "lib" ) -> apply            *
    *                                                                                                                                                 *
    * ================================================================================================================================================*


    * */
    public static void main(String[] args)  {
	 try
     {


         greetingsText();
         DBHandler dbHandler = DBHandler.getInstance();
         Scanner in = new Scanner(System.in);


         // Customers enters the store (object is created)
         customers = new ArrayList<Person>();
         manager = new ArrayList<Person>();
         cashiers = new ArrayList<Cashier>();

         customers.add(dbHandler.getCustomers());
         manager.add(dbHandler.getManager());
         cashiers.add(dbHandler.getCashiers());

         System.out.println(CYAN_BOLD_BRIGHT + customers.get(0).getFirst_name() + " " + customers.get(0).getSecond_name() + " (Customers)enter the store IP company ..." + TEXT_RESET);



         // The manager approaches the buyer (An object is created)
         manager.get(manager.size() - 1).greetings(manager.get(manager.size() - 1), customers.get(customers.size() - 1));
         customers.get(customers.size() - 1).greetings(customers.get(customers.size() - 1), customers.get(customers.size() - 1));


         // The manager asks what the Customers wants
        questionsByManager(customers, manager);

        System.currentTimeMillis();
     }catch (SQLException | InterruptedException | ClassNotFoundException throwables){
	     throwables.printStackTrace();
         System.out.println("Connection Error");
     }




    }

    public static void questionsByManager(ArrayList<Person> customers, ArrayList<Person> manager) throws InterruptedException, SQLException{
        int size_c = customers.size() - 1, size_m = manager.size() - 1, answer_by_cust;
        manager.get(size_m).chooseOfProduct(0);
        Scanner in = new Scanner(System.in);

        answer_by_cust = customers.get(size_c).chooseOfProduct(in.nextInt());
        manager.get(size_m).chooseOfProduct(answer_by_cust);

    }

    public static void greetingsText(){
        System.out.println("\n" + RED_BOLD_BRIGHT+
                "██████╗ ███████╗███████╗████████╗    ███╗   ███╗ █████╗ ███╗   ██╗ █████╗  ██████╗ ███████╗██████╗ \n" +
                "██╔══██╗██╔════╝██╔════╝╚══██╔══╝    ████╗ ████║██╔══██╗████╗  ██║██╔══██╗██╔════╝ ██╔════╝██╔══██╗\n" +
                "██████╔╝█████╗  ███████╗   ██║       ██╔████╔██║███████║██╔██╗ ██║███████║██║  ███╗█████╗  ██████╔╝\n" +
                "██╔══██╗██╔══╝  ╚════██║   ██║       ██║╚██╔╝██║██╔══██║██║╚██╗██║██╔══██║██║   ██║██╔══╝  ██╔══██╗\n" +
                "██████╔╝███████╗███████║   ██║       ██║ ╚═╝ ██║██║  ██║██║ ╚████║██║  ██║╚██████╔╝███████╗██║  ██║\n" +
                "╚═════╝ ╚══════╝╚══════╝   ╚═╝       ╚═╝     ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝╚═╝  ╚═╝\n" +
                "                                                                                                   \n" + TEXT_RESET);




    }
}


