package org.mystringstorage;

public interface CRUDable {

    void createString(String userString);

    void updateString(int index, String command);

    void deleteString(int index);

    void getStringByIndex(int index);

    void getAllString();
}
