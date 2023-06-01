package org.mystringstorage;

import java.util.HashMap;
import java.util.Map;

public class StringStorageInHashMap implements CRUDable { //ToDo в данном классе сделать методы КРУД, т.е. работы с этой базой

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

    @Override
    public void createStringInStringStorage(String userString) {
        stringStorageMap.put(getStringIdCount(), userString);
        System.out.println("String saved with id = {" + incrementStringIdCount() + "}");
    }

    @Override
    public void getStringInStringStorage(int index) {
        if (stringStorageMap.isEmpty()) {
            System.out.println("База строк еще пустая!");
        } else if (index > stringStorageMap.size()) {
            System.err.println("Строка с таким индексом еще не создана!");
        }  else if (index <= 0) {
            System.out.println("Такая строка не может существовать!");
        } else if (!stringStorageMap.containsKey(index)) {
            System.err.println("Строка с индексом " + index + " уже была удалена!");
        } else {
            System.out.println("String with id: " + index + " = " + "{" + stringStorageMap.get(index) + "}");
        }
    }
    //ToDo Да просто попробуй все что после гет привести к целому числу
    //ToDo Можно взять подстроку с 5 символа до конца и попытаться преобразовать в число + А так, по ТЗ говорят число будет, значит нужно ждать число или ругаться)


    @Override
    public void updateStringInStringStorage(int index, String command) {
//        if (index < 0) {
//
//        } else if (index > stringStorage.getStringStorageMap().size()) {
//            System.err.println("Строка с таким индексом еще не создана!");
//        } else if (!stringStorage.getStringStorageMap().containsKey(index)) {
//            System.err.println("Строка с индексом " + index + " уже была удалена!");
//        } else {
//            int indexStart = command.indexOf("{") + 1;
//            int indexEnd = command.indexOf("}");
//
//            String result = command.substring(indexStart, indexEnd);
//            stringStorage.getStringStorageMap().put(index, result);
//
//            System.out.println("String with id: " + index + " updated");
//        }
    }

    @Override
    public void deleteStringInStringStorage(String command) {

    }

    @Override
    public void getStringInStringStorage() {
        for (Map.Entry<Integer, String> entry : stringStorageMap.entrySet()) {
            System.out.println("String with id: " + entry.getKey() + " = " + "{" + entry.getValue() + "}");
        }
    }
}
