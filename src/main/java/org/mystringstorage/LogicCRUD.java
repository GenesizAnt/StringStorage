package org.mystringstorage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogicCRUD {

    private final StringStorage stringStorage;

    public LogicCRUD(StringStorage stringStorage) {
        this.stringStorage = stringStorage;
    }

    public void createStringInStringStorage(String command) {
        int indexStart = command.indexOf("{") + 1;
        int indexEnd = command.indexOf("}");

        String result = command.substring(indexStart, indexEnd);

        stringStorage.getStringStorageMap().put(StringStorage.getStringIdCount(), result);
        StringStorage.decrementStringIdCount();

        System.out.println("String saved with id = {" + result + "}");
    }

    public void getStringFromStringStorage(String command) {
        int indexStr = getNumericOfString(command);

    }

    private int getNumericOfString(String str) {
        int indexStr = -1;

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            indexStr = Integer.parseInt(matcher.group());
        }
        return indexStr;
    }


//            System.out.println("GET or GET 'number str'  : For to read string or specific string");
//            System.out.println("UPDATE 'number str' : For to edit a specific string");
//            System.out.println("DELETE 'number str'  : For to delete a string");
//            System.out.println("QUIT  : To close the programme");
}

