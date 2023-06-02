package org.mystringstorage;

import java.util.HashMap;
import java.util.Map;

public class StringStorageInHashMap implements CRUDable {

    private int stringIdCount = 1;
    private HashMap<Integer, String> stringStorageMap = new HashMap<>();

    public int getStringIdCount() {
        return stringIdCount;
    }

    public HashMap<Integer, String> getStringStorageMap() {
        return stringStorageMap;
    }

    public int incrementStringIdCount() {
        return stringIdCount++;
    }

    public void setStringStorageMap(HashMap<Integer, String> stringStorageMap) {
        this.stringStorageMap = stringStorageMap;
        this.stringIdCount = stringStorageMap.size() + 1;
    }

    @Override
    public void createString(String userString) {
        stringStorageMap.put(getStringIdCount(), userString);
        System.out.println("String saved with id = " + incrementStringIdCount());
    }

    @Override
    public void getStringByIndex(int index) {
        if (isCorrectIndex(index)) {
            System.out.println("String with id: " + index + " = " + stringStorageMap.get(index));
        }
    }

    @Override
    public void updateString(int index, String command) {
        if (isCorrectIndex(index)) {
            stringStorageMap.put(index, command);
            System.out.println("String with id: " + index + " updated");
        }
    }

    @Override
    public void deleteString(int index) {
        if (isCorrectIndex(index)) {
            stringStorageMap.remove(index);
            System.out.println("String with id: " + index + " deleted");
        }
    }

    @Override
    public void getAllString() {
        for (Map.Entry<Integer, String> entry : stringStorageMap.entrySet()) {
            System.out.println("String with id: " + entry.getKey() + " = " + entry.getValue());
        }
    }

    private boolean isCorrectIndex(int index) {
        if (stringStorageMap.isEmpty()) {
            System.out.println("База строк еще пустая!");
            return false;
        } else if (index > stringStorageMap.size()) {
            System.err.println("Строка с таким индексом еще не создана!");
            return false;
        } else if (index <= 0) {
            System.out.println("Такая строка не может существовать!");
            return false;
        } else if (!stringStorageMap.containsKey(index)) {
            System.err.println("Строка с индексом " + index + " уже была удалена!");
            return false;
        } else {
            return true;
        }
    }
}
