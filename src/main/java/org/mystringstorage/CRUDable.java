package org.mystringstorage;

public interface CRUDable {

    void createStringInStringStorage(String userString);//ToDo возможно лишний класс и избыточное название

    void updateStringInStringStorage(int index, String command);

    void deleteStringInStringStorage(String command);

    void getStringInStringStorage(int index);

    void getStringInStringStorage();
}
