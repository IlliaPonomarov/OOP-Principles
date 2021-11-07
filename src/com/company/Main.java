package com.company;

import com.company.Data.DBHandler;
import com.company.People.Customers;
import com.company.People.Person;

import java.sql.SQLException;
import java.util.*;
import java.util.Scanner;

public class Main implements ConsoleColors{

    public static void main(String[] args)  {
	 try
     {
         String first_name = "", second_name = null,  phone_number = null, mail = null, city = null, street = null;
         double money = 0.0;
         int age = 0, apartment = 0;


         greetingsText();
         DBHandler dbHandler = DBHandler.getInstance();
         Scanner in = new Scanner(System.in);


         //Customers входит в магазин (создается объект)
         ArrayList<Person> customers = new ArrayList<Person>();
         customers.add(dbHandler.getCustomers());
         System.out.println(CYAN_BOLD_BRIGHT + customers.get(0).getFirst_name() + " " + customers.get(0).getSecond_name() + " (Customers)enter the store IP company ..." + TEXT_RESET);
         //Менеджер подходит к покупателю (Создается объект)





     }catch (SQLException throwables){
	     throwables.printStackTrace();
         System.out.println("Connection Error");
     }




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


