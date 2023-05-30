package org.mystringstorage;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//ToDo добавить файл гитИгнор чтобы не попадали папки Идеа и Таргет
public class Main {
    public static final String CREATE_COMMAND = "CREATE"; //ToDo вынести все поля в отдельный класс, чтобы в Майн было только старт класса + поля не будут Статик
    public static final String GET_COMMAND = "GET";
    public static final String UPDATE_COMMAND = "UPDATE";
    public static final String DELETE_COMMAND = "DELETE";
    public static final String QUIT_COMMAND = "QUIT";

    public static FileController fileController = new FileController();
    public static StringStorageInHashMap stringStorage = new StringStorageInHashMap();
    public static CRUDLogicInDataBase logicInDataBase = new CRUDLogicInHashMap(stringStorage);
    public static PerformerCRUD performerCRUD = new PerformerCRUD(logicInDataBase);

    public static void main(String[] args) {

        System.out.println("Welcome to CRUD String Storage. Please choose command and press Enter:");
        System.out.println("_________________________________________________");

        Scanner scanner = new Scanner(System.in);//ToDo сделать закрытие сканера когда он уже не нужен - https://stackoverflow.com/questions/47588704/java-using-scanner-with-try-with-resources
        String command = "";

        fileController.readFile(stringStorage); //ToDo метод не должен менять состояние передаваемого объекта, лучше возвращает массив, который мы сохраним в переменную сами

        while (!command.equals(QUIT_COMMAND)) {

            System.out.println("CREATE {some_sting}  : For to save string");
            System.out.println("GET or GET 'number str'  : For to read string or specific string");
            System.out.println("UPDATE 'number str' : For to edit a specific string");
            System.out.println("DELETE 'number str'  : For to delete a string");
            System.out.println("QUIT  : To close the programme");

            command = scanner.nextLine();

            if (command.contains(CREATE_COMMAND)) {
                performerCRUD.createStringInStringStorage(command);
            } else if (command.contains(GET_COMMAND) || (command.contains(GET_COMMAND) && command.matches("\\d+"))) {//ToDo не использовать регулярки??? а как тогда по другому
                performerCRUD.getStringInStringStorage(command);
            } else if (command.contains(UPDATE_COMMAND) || (command.contains(UPDATE_COMMAND) && command.matches("\\d+"))) {
                performerCRUD.updateStringInStringStorage(command);
            } else if (command.contains(DELETE_COMMAND) || (command.contains(DELETE_COMMAND) && command.matches("\\d+"))) {
                performerCRUD.deleteStringInStringStorage(command);
            } else if (command.contains(QUIT_COMMAND)) {
                System.out.println("Exit programme. Bye!");
                fileController.saveFile(stringStorage);
                break;
            } else {
                System.err.println("Command not recognized! Please try again");
            }
        }
    }
}