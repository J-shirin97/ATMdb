package com.paris.view;

import com.paris.action.WithdrawAction;
import com.paris.controller.AccountController;
import com.paris.controller.PersonController;
import com.paris.entity.Person;

import javax.xml.transform.Result;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("welcome to ATM");
        System.out.println("login OR signup");
        String str = scanner.nextLine().toLowerCase(Locale.ROOT);

        if (str.equals("signup")){
            System.out.println("----------------------");
            System.out.println("Enter National Code: ");
            String nationalCode = scanner.nextLine();
            System.out.println("Enter firstname :  ");
            String firstname = scanner.nextLine();
            System.out.println("Enter lastname :  ");
            String lastname = scanner.nextLine();
            System.out.println("Enter age :  ");
            Integer age = scanner.nextInt();
            PersonController personController = new PersonController();
            personController.save(nationalCode,firstname,lastname,age);
        }else {
            System.out.println("Enter your AccountNumber :  ");
            String accountNumber = scanner.nextLine();
            System.out.println("Enter your password :   ");
            String password = scanner.nextLine();
            AccountController accountController = new AccountController();
            //accountController.save();
        }
    }*/

    public static void main(String[] args) throws Exception {
        //Select
        PersonController personController = new PersonController();
        personController.all();
        //Remove
        /*Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id: ");
        int id = scanner.nextInt();
        personController.delete(id);*/
    }
}
