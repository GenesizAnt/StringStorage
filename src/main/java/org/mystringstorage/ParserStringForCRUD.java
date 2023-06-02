package org.mystringstorage;

public class ParserStringForCRUD {

    private final StringStorageInHashMap stringStorage;
    private final String CREATE_COMMAND = "CREATE";
    private final String GET_COMMAND = "GET";
    private final String UPDATE_COMMAND = "UPDATE";
    private final String DELETE_COMMAND = "DELETE";
    private final String QUIT_COMMAND = "QUIT";

    public ParserStringForCRUD(StringStorageInHashMap stringStorage) {
        this.stringStorage = stringStorage;
    }

    public void getCommandUser(String command) {
        String[] userString = command.split(" ");

        switch (userString[0]) {
            case CREATE_COMMAND -> stringStorage.createString(getNewString(userString));
            case GET_COMMAND -> {
                if (userString.length == 1) {
                    stringStorage.getAllString();
                } else {
                    stringStorage.getStringByIndex(searchStringIndex(userString));
                }
            }
            case UPDATE_COMMAND -> stringStorage.updateString(searchStringIndex(userString), getNewString(userString));
            case DELETE_COMMAND -> stringStorage.deleteString(searchStringIndex(userString));
            case QUIT_COMMAND ->
                    System.out.println("Завершение программы. Все данные сохранены!");
            default -> System.out.println("Введена некорректная команда!");

        }
    }

    public String getNewString(String[] userString) {
        int count = 0;
        if (userString[0].equals(CREATE_COMMAND)) {
            count = 1;
        }
        if (userString[0].equals(UPDATE_COMMAND)) {
            count = 2;
        }

        StringBuilder newString = new StringBuilder();
        for (; count < userString.length; count++) {
            if (count < userString.length - 1) {
                newString.append(userString[count]).append(" ");
            } else {
                newString.append(userString[count]);
            }
        }
        return String.valueOf(newString);
    }


    public int searchStringIndex(String[] userString) {
        int MAX_SIZE_PARAMETER_COMMAND = 3;
        if (userString.length > MAX_SIZE_PARAMETER_COMMAND) {
            System.err.println("Некорректный ввод!");
        }
        int index = 0;
        try {
            index = Integer.parseInt(userString[1]);
        } catch (NumberFormatException e) {
            System.out.println("Индекс должен быть целым числом!");
        }
        return index;
    }

    public String getQUIT_COMMAND() {
        return QUIT_COMMAND;
    }
}
