package org.mystringstorage.controller;

import org.mystringstorage.data.CRUDable;
import org.mystringstorage.command.CrudCommand;

public class ControllerCrud {

    private final String CREATE_COMMAND = "CREATE";
    private final String GET_COMMAND = "GET";
    private final String UPDATE_COMMAND = "UPDATE";
    private final String DELETE_COMMAND = "DELETE";
    private final String QUIT_COMMAND = "QUIT";

    public void controlCommand(CRUDable crudStorage, CrudCommand command) {

        switch (command.getCommand()) {
            case CREATE_COMMAND -> crudStorage.create(command.getUserString());
            case GET_COMMAND -> {
                if (command.getIndex() == 0) {
                    crudStorage.getAll();
                } else {
                    crudStorage.getByIndex(command.getIndex());
                }
            }
            case UPDATE_COMMAND -> crudStorage.updateString(command.getIndex(), command.getUserString());
            case DELETE_COMMAND -> crudStorage.delete(command.getIndex());
            case QUIT_COMMAND -> System.out.println("Завершение программы. Все данные сохранены!");
            default -> System.out.println("Введена некорректная команда!");
        }

    }

    public String getQUIT_COMMAND() {
        return QUIT_COMMAND;
    }
}
