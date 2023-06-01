package org.mystringstorage;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ParserStringForCRUD {

    private StringStorageInHashMap stringStorage;
    private final String CREATE_COMMAND = "CREATE"; //ToDo вынести все поля в отдельный класс, чтобы в Майн было только старт класса + поля не будут Статик
    private final String GET_COMMAND = "GET";
    private final String UPDATE_COMMAND = "UPDATE";
    private final String DELETE_COMMAND = "DELETE";
    private final String QUIT_COMMAND = "QUIT";

    private String command;

    public ParserStringForCRUD(String command, StringStorageInHashMap stringStorage) {
        this.command = command;
        this.stringStorage = stringStorage;
    }

    public String getCommandUser(String command) {
        String[] userString = command.split(" ");

        switch (userString[0]) {
            case CREATE_COMMAND -> stringStorage.createStringInStringStorage(getNewString(userString));
            case GET_COMMAND -> {
                if (userString.length == 1) {
                    stringStorage.getStringInStringStorage();
                } else {
                    stringStorage.getStringInStringStorage(searchStringIndex(userString));
                }
            }
            case UPDATE_COMMAND -> getCREATE_COMMAND();
            case DELETE_COMMAND -> getDELETE_COMMAND();
            case QUIT_COMMAND ->
                    System.out.println("Завершение программы. Все данные сохранены!"); //ToDo создать метод с прощалкой и сохранением данных
            default -> {
                System.out.println("Введена некорректная команда!");
            }
        }
        return "";
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
        if (userString.length > 2) {
            System.err.println("Некорректный ввод!"); //ToDo проверить ввод индекса на +2 и пр.
        }
        int index = 0;
        try {
            index = Integer.parseInt(userString[1]);
        } catch (NumberFormatException e) {
            System.out.println("Индекс должен быть целым числом!");
        }
        return index;
    }


    public String getCREATE_COMMAND() {
        return CREATE_COMMAND;
    }

    public String getGET_COMMAND() {
        return GET_COMMAND;
    }

    public String getUPDATE_COMMAND() {
        return UPDATE_COMMAND;
    }

    public String getDELETE_COMMAND() {
        return DELETE_COMMAND;
    }

    public String getQUIT_COMMAND() {
        return QUIT_COMMAND;
    }

    public String getCommand() {
        return command;
    }
}
