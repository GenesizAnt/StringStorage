package org.mystringstorage.controller;

import org.mystringstorage.data.CRUDable;
import org.mystringstorage.data.PersonStorageInHashMap;
import org.mystringstorage.data.StringStorageInHashMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileController<K, V> {

    private String pathDataFile = "";
    private HashMap<K, V> dataMap = new HashMap<>();

    public void saveFile(CRUDable crudStorage) {
        checkStorage(crudStorage);
        try (FileWriter writer = new FileWriter(pathDataFile)) {
            for (Map.Entry<K, V> entry : dataMap.entrySet()) {
                writer.write(entry.getKey() + ";" + entry.getValue() + ";\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashMap<K, V> readFile(CRUDable crudStorage) {

        checkStorage(crudStorage);

        try (BufferedReader reader = new BufferedReader(new FileReader(pathDataFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(";");
                Integer id = Integer.parseInt(tokens[0]);
                String value = tokens[1];
                dataMap.put((K) id, (V) value);
            }
            System.out.println("Стартовые данные были взяты из файла");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataMap;
    }

    private void checkStorage(CRUDable crudStorage) {
        if (crudStorage instanceof StringStorageInHashMap) {
            dataMap = (HashMap<K, V>) ((StringStorageInHashMap) crudStorage).getStringStorageMap();
            pathDataFile = "src/main/resources/saveStringStorage.txt";
        } else if (crudStorage instanceof PersonStorageInHashMap) {
            dataMap = (HashMap<K, V>) ((PersonStorageInHashMap) crudStorage).getPersonStorageMap();
            pathDataFile = "src/main/resources/savePersonStorage.txt";
        }
    }
}
