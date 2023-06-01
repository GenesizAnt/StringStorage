package org.mystringstorage;

import java.util.Scanner;

public class StartCRUDapp {

    private ParserStringForCRUD parser;
    private final StringStorageInHashMap stringStorage = new StringStorageInHashMap();

    public void startApp() {

        System.out.println("Welcome to CRUD String Storage. Please choose command and press Enter:");
        System.out.println("_________________________________________________");

        String command = "";
        parser = new ParserStringForCRUD(command, stringStorage);
        try (Scanner scanner = new Scanner(System.in)) {
            while (!command.equals(parser.getQUIT_COMMAND())) {

                System.out.println("CREATE {some_sting}  : For to save string");
                System.out.println("GET or GET 'number str'  : For to read string or specific string");
                System.out.println("UPDATE 'number str' : For to edit a specific string");
                System.out.println("DELETE 'number str'  : For to delete a string");
                System.out.println("QUIT  : To close the programme");

                command = scanner.nextLine();
                parser.getCommandUser(command);

//                if (command.contains(CREATE_COMMAND)) {
//                    performerCRUD.createStringInStringStorage(command);
//                } else if (command.contains(GET_COMMAND) || (command.contains(GET_COMMAND) && command.matches("\\d+"))) {//ToDo не использовать регулярки??? а как тогда по другому
//                    performerCRUD.getStringInStringStorage(command);
//                } else if (command.contains(UPDATE_COMMAND) || (command.contains(UPDATE_COMMAND) && command.matches("\\d+"))) {
//                    performerCRUD.updateStringInStringStorage(command);
//                } else if (command.contains(DELETE_COMMAND) || (command.contains(DELETE_COMMAND) && command.matches("\\d+"))) {
//                    performerCRUD.deleteStringInStringStorage(command);
//                } else if (command.contains(QUIT_COMMAND)) {
//                    System.out.println("Exit programme. Bye!");
//                    fileController.saveFile(stringStorage);
//                    break;
//                } else {
//                    System.err.println("Command not recognized! Please try again");
//                }

            }
        }

    }

    private String getParserCommand(String command) {
        return parser.getCommandUser(command);
    }
}
