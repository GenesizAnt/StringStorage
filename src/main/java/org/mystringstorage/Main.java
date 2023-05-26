package org.mystringstorage;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

//        String str = "aиавпивапиbc 3";
//        if (str.matches(".*[0-9].*")) {
//            System.out.println("В строке содержатся цифры");
//        } else {
//            System.out.println("Цифр в строке нет");
//        }

        StringStorage stringStorage = new StringStorage();
        LogicCRUD logicCRUD = new LogicCRUD(stringStorage);

        String s = "CREATE { }";
        String s1 = "CREATE {}";
        String s2 = "CREATE {dfvsdfv}";
        String s3 = "CREATE {GET -198}";
        String s4 = "CREATE { fdgv 34 dgfg}";


//        logicCRUD.createStr(s);
//        logicCRUD.createStr(s1);
//        logicCRUD.createStr(s2);
//        logicCRUD.createStr(s3);
//        logicCRUD.createStr(s4);













//        Scanner scanner = new Scanner(System.in);
//        String command = "";
//
//        while (!command.equals("QUIT")) {
//
//            System.out.println("Welcome to CRUD String Storage. Please press Enter:");
//            System.out.println("_________________________________________________");
//            System.out.println("CREATE {some_sting}  : For to save string");
//            System.out.println("GET or GET 'number str'  : For to read string or specific string");
//            System.out.println("UPDATE 'number str' : For to edit a specific string");
//            System.out.println("DELETE 'number str'  : For to delete a string");
//            System.out.println("QUIT  : To close the programme");
//
//            command = scanner.nextLine();
//
//            switch (command) {
//                case "CREATE" -> System.out.println(1);
//                case "GET" -> System.out.println(2);
//                case "UPDATE" -> System.out.println(3);
//                case "DELETE" -> {
//                    break;
//                }
//                default -> System.out.println("Command not recognized! Please try again");
//            }
//        }
    }
}
