package org.mystringstorage;

public class ControllerCrud {

    private StringStorageInHashMap stringStorage;
    private final String CREATE_COMMAND = "CREATE";
    private final String GET_COMMAND = "GET";
    private final String UPDATE_COMMAND = "UPDATE";
    private final String DELETE_COMMAND = "DELETE";
    private final String QUIT_COMMAND = "QUIT";

    public ControllerCrud(StringStorageInHashMap stringStorage) {
        this.stringStorage = stringStorage;
    }

    public void controlCommand(CrudCommand command) {

        switch (command.getCommand()) {
            case CREATE_COMMAND -> stringStorage.createString(command.getUserString());
            case GET_COMMAND -> {
                if (command.getIndex() == 0) {
                    stringStorage.getAllString();
                } else {
                    stringStorage.getStringByIndex(command.getIndex());
                }
            }
            case UPDATE_COMMAND -> stringStorage.updateString(command.getIndex(), command.getUserString());
            case DELETE_COMMAND -> stringStorage.deleteString(command.getIndex());
            case QUIT_COMMAND -> System.out.println("Завершение программы. Все данные сохранены!");
            default -> System.out.println("Введена некорректная команда!");
        }

    }

    public String getQUIT_COMMAND() {
        return QUIT_COMMAND;
    }
}
