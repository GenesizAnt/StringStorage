package org.mystringstorage;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CRUDLogicInHashMap extends CRUDLogicInDataBase {

    StringStorageInHashMap stringStorage;

    public CRUDLogicInHashMap(StringStorageInHashMap stringStorage) {
        this.stringStorage = stringStorage;
    }

    @Override
    public void createString(String command) {
        int indexStart = command.indexOf("{") + 1;
        int indexEnd = command.indexOf("}");

        String result = command.substring(indexStart, indexEnd);
        stringStorage.getStringStorageMap().put(StringStorageInHashMap.getStringIdCount(), result);
        System.out.println("String saved with id = {" + StringStorageInHashMap.getStringIdCount() + "}");

        StringStorageInHashMap.decrementStringIdCount();
    }

    @Override
    public void getString(String command) {
        Map<Integer, String> stringMap = stringStorage.getStringStorageMap();
        int index = getStringFromStringStorage(command);

        if (command.equals(Main.GET_COMMAND)) {
            if (stringMap.isEmpty()) {
                System.err.println("База строк еще пустая!");
            } else {
                for (Map.Entry<Integer, String> entry : stringMap.entrySet()) {
                    System.out.println("String with id: " + entry.getKey() + " = " + " {" + entry.getValue() + "}");
                }
            }
        }

        if (index < 0) {

        } else if (index > stringMap.size()) {
            System.err.println("Строка с таким индексом еще не создана!");
        } else if (!stringStorage.getStringStorageMap().containsKey(index)) {
            System.err.println("Строка с индексом " + index + " уже была удалена!");
        } else {
            System.out.println("String with id: " + index + " = " + " {" + stringMap.get(index) + "}");
        }
    }

    @Override
    public void updateString(String command) {
        int index = getStringFromStringStorage(command);

        if (index < 0) {

        } else if (index > stringStorage.getStringStorageMap().size()) {
            System.err.println("Строка с таким индексом еще не создана!");
        } else if (!stringStorage.getStringStorageMap().containsKey(index)) {
            System.err.println("Строка с индексом " + index + " уже была удалена!");
        } else {
            int indexStart = command.indexOf("{") + 1;
            int indexEnd = command.indexOf("}");

            String result = command.substring(indexStart, indexEnd);
            stringStorage.getStringStorageMap().put(index, result);

            System.out.println("String with id: " + index + " updated");
        }
    }

    @Override
    public void deleteString(String command) {
        int index = getStringFromStringStorage(command);

        if (index < 0) {

        } else if (index > stringStorage.getStringStorageMap().size()) {
            System.err.println("Строка с таким индексом еще не создана!");
        } else if (!stringStorage.getStringStorageMap().containsKey(index)) {
            System.err.println("Строка с индексом " + index + " уже была удалена!");
        } else {
            stringStorage.getStringStorageMap().remove(index);
            System.out.println("String with id: " + index + " deleted");
        }
    }

    public int getStringFromStringStorage(String command) {
        return getNumericOfString(command);
    }

    private int getNumericOfString(String str) {
        int indexStr = -1;

        if (str.contains("-") || str.contains(".") || str.contains(",")) {
            System.err.println("Индекс строки не может начинаться с нуля, быть отрицательным или дробным!");
        } else {
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                indexStr = Integer.parseInt(matcher.group());
                if (indexStr == 0) {
                    return indexStr;
                }
            }
        }
        return indexStr;
    }
}
