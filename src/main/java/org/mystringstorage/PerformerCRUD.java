package org.mystringstorage;

public class PerformerCRUD {

    private CRUDLogicInDataBase dataBase;

    public PerformerCRUD(CRUDLogicInDataBase dataBase) {
        this.dataBase = dataBase;
    }


    public void createStringInStringStorage(String command) {
        dataBase.createString(command);
    }


    public void updateStringInStringStorage(String command) {
        dataBase.updateString(command);
    }


    public void deleteStringInStringStorage(String command) {
        dataBase.deleteString(command);
    }


    public void getStringInStringStorage(String command) {
        dataBase.getString(command);
    }
}
