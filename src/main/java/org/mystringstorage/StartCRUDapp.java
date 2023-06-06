package org.mystringstorage;

import java.util.Scanner;

public class StartCRUDapp {

    private final StringStorageInHashMap stringStorage = new StringStorageInHashMap();
    private final FileController fileController = new FileController();
    private final ParserStringForCRUD parser = new ParserStringForCRUD();
    private final ControllerCrud controllerCrud = new ControllerCrud(stringStorage);
    public void startApp() {

        System.out.println("Welcome to CRUD String Storage. Please choose command and press Enter:");
        System.out.println("_________________________________________________");
        String lineFromUser = "";

        stringStorage.setStringStorageMap(fileController.readFile(stringStorage));

        try (Scanner scanner = new Scanner(System.in)) {
            while (!lineFromUser.equals(controllerCrud.getQUIT_COMMAND())) {

                System.out.println("CREATE {some_sting}  : For to save string");
                System.out.println("GET or GET 'number str'  : For to read string or specific string");
                System.out.println("UPDATE 'number str' : For to edit a specific string");
                System.out.println("DELETE 'number str'  : For to delete a string");
                System.out.println("QUIT  : To close the programme");

                lineFromUser = scanner.nextLine();
                CrudCommand crudCommand = parser.getCrudCommand(lineFromUser);
                controllerCrud.controlCommand(crudCommand);

            }

            fileController.saveFile(stringStorage);

        }
    }
}
