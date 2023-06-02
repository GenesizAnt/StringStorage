package org.mystringstorage;

import java.util.Scanner;

public class StartCRUDapp {

    private final StringStorageInHashMap stringStorage = new StringStorageInHashMap();
    private final FileController fileController = new FileController();
    public void startApp() {

        System.out.println("Welcome to CRUD String Storage. Please choose command and press Enter:");
        System.out.println("_________________________________________________");
        String command = "";

        stringStorage.setStringStorageMap(fileController.readFile(stringStorage));
        ParserStringForCRUD parser = new ParserStringForCRUD(stringStorage);

        try (Scanner scanner = new Scanner(System.in)) {
            while (!command.equals(parser.getQUIT_COMMAND())) {

                System.out.println("CREATE {some_sting}  : For to save string");
                System.out.println("GET or GET 'number str'  : For to read string or specific string");
                System.out.println("UPDATE 'number str' : For to edit a specific string");
                System.out.println("DELETE 'number str'  : For to delete a string");
                System.out.println("QUIT  : To close the programme");

                command = scanner.nextLine();
                parser.getCommandUser(command);
            }
            fileController.saveFile(stringStorage);
        }
    }
}
