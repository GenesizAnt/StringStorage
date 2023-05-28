package org.mystringstorage;

public class PerformerCRUD implements ManagerCRUD {

    private CRUDLogicInDataBase dataBase;

    public PerformerCRUD(CRUDLogicInDataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void createStringInStringStorage(String command) {
        dataBase.createString(command);
    }

    @Override
    public void updateStringInStringStorage(String command) {
        dataBase.updateString(command);
    }

    @Override
    public void deleteStringInStringStorage(String command) {
        dataBase.deleteString(command);
    }

    @Override
    public void getStringInStringStorage(String command) {
        dataBase.getString(command);
    }
}
