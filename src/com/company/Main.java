package com.company;

import com.company.Data.DBHandler;
import com.company.Interface.ConsoleColors;
import com.company.People.Person;
import  java.lang.InterruptedException;
import java.sql.SQLException;
import java.util.*;
import java.util.Scanner;

public class Main implements ConsoleColors {
    public static ArrayList<Person> customers;
    public static ArrayList<Person> manager;

    public static void main(String[] args)  {
	 try
     {


         greetingsText();
         DBHandler dbHandler = DBHandler.getInstance();
         Scanner in = new Scanner(System.in);


         // Customers enters the store (object is created)
         customers = new ArrayList<Person>();
         manager = new ArrayList<Person>();

         customers.add(dbHandler.getCustomers());
         manager.add(dbHandler.getManager());

         System.out.println(CYAN_BOLD_BRIGHT + customers.get(0).getFirst_name() + " " + customers.get(0).getSecond_name() + " (Customers)enter the store IP company ..." + TEXT_RESET);



         // The manager approaches the buyer (An object is created)
         manager.get(manager.size() - 1).greetings(manager.get(manager.size() - 1), customers.get(customers.size() - 1));
         customers.get(customers.size() - 1).greetings(customers.get(customers.size() - 1), customers.get(customers.size() - 1));


         // The manager asks what the Customers wants
        questionsByManager(customers, manager);


     }catch (SQLException | InterruptedException throwables){
	     throwables.printStackTrace();
         System.out.println("Connection Error");
     }




    }

    public static void questionsByManager(ArrayList<Person> customers, ArrayList<Person> manager) throws InterruptedException, SQLException{
        int size_c = customers.size() - 1, size_m = manager.size() - 1;
        manager.get(size_m).chooseOfProduct(0);
        Scanner in = new Scanner(System.in);
        int answer_by_cust = customers.get(size_c).chooseOfProduct(in.nextInt());
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


