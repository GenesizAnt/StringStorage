package org.mystringstorage;

import java.util.HashMap;

public class StringStorageInHashMap {

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
