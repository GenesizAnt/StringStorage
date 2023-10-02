package org.mystringstorage.data;

public interface CRUDable {

    void create(String userString);

    void updateString(int index, String userString);

    void delete(int index);

    void getByIndex(int index);

    void getAll();
}
