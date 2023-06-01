package org.mystringstorage;

public abstract class DataBase implements CRUDable{

    private final CRUDable cruDable;

    public DataBase(CRUDable cruDable) {
        this.cruDable = cruDable;
    }
}
