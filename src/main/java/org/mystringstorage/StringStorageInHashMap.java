package org.mystringstorage;

import java.util.HashMap;

public class StringStorageInHashMap { //ToDo в данном классе сделать методы КРУД, т.е. работы с этой базой

    private static int stringIdCount = 1;
    private final HashMap<Integer, String> stringStorageMap = new HashMap<>();

    public static int getStringIdCount() {
        return stringIdCount;
    }

    public HashMap<Integer, String> getStringStorageMap() {
        return stringStorageMap;
    }

    public static int decrementStringIdCount() {
        return stringIdCount++;
    }
}
