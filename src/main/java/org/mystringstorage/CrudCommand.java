package org.mystringstorage;

public final class CrudCommand {

    private String command = "";
    private int index = 0;
    private String userString = "";

    public CrudCommand(String command, int index, String userString) {
        this.command = command;
        this.index = index;
        this.userString = userString;
    }

    public CrudCommand(String command, int index) {
        this.command = command;
        this.index = index;
    }

    public CrudCommand(String command, String userString) {
        this.command = command;
        this.userString = userString;
    }

    public CrudCommand(String command) {
        this.command = command;
    }

    public CrudCommand() {

    }

    public String getCommand() {
        return command;
    }

    public int getIndex() {
        return index;
    }

    public String getUserString() {
        return userString;
    }
}
