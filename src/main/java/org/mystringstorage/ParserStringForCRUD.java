package org.mystringstorage;

public class ParserStringForCRUD {

    private final String CREATE_COMMAND = "CREATE";
    private final String GET_COMMAND = "GET";
    private final String UPDATE_COMMAND = "UPDATE";
    private final String DELETE_COMMAND = "DELETE";
    private final String QUIT_COMMAND = "QUIT";
    private final int MAX_SIZE_PARAMETER_COMMAND = 3;

    public CrudCommand getCrudCommand(String command) {
        String[] userString = command.split(" ");

        switch (userString[0]) {
            case CREATE_COMMAND -> {
                return getCreateCommand(userString);
            }
            case GET_COMMAND -> {
                return getGetCommand(userString);
            }
            case UPDATE_COMMAND -> {
                return getUpdateCommand(userString);
            }
            case DELETE_COMMAND -> {
                return getDeleteCommand(userString);
            }
            case QUIT_COMMAND -> {
                return getQuitCommand(userString);
            }
            default -> {
                return new CrudCommand();
            }
        }
    }

    private CrudCommand getCreateCommand(String[] userString) {
        if (userString.length == 1) {
            return new CrudCommand();
        } else {
            return new CrudCommand(userString[0], getNewString(userString));
        }
    }

    private CrudCommand getGetCommand(String[] userString) {
        if (userString.length == 1) {
            return new CrudCommand(userString[0]);
        } else {
            return new CrudCommand(userString[0], searchStringIndex(userString));
        }
    }

    private CrudCommand getUpdateCommand(String[] userString) {
        if (userString.length < MAX_SIZE_PARAMETER_COMMAND) {
            return new CrudCommand();
        } else {
            return new CrudCommand(userString[0], searchStringIndex(userString), getNewString(userString));
        }
    }

    private CrudCommand getDeleteCommand(String[] userString) {
        if (userString.length == 2) {
            return new CrudCommand(userString[0], searchStringIndex(userString));
        } else {
            return new CrudCommand();
        }
    }
    private CrudCommand getQuitCommand(String[] userString) {
        if (userString.length == 1) {
            return new CrudCommand(userString[0]);
        } else {
            return new CrudCommand();
        }
    }

    private String getNewString(String[] userString) {
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

    private int searchStringIndex(String[] userString) {
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
}
