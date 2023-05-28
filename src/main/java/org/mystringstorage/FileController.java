package org.mystringstorage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class FileController {
    public void saveFile(StringStorageInHashMap stringStorage) {
        Map<Integer, String> stringMap = stringStorage.getStringStorageMap();
        try (FileWriter writer = new FileWriter("saveStringStorage.txt")) {
            for (Map.Entry<Integer, String> entry : stringStorage.getStringStorageMap().entrySet()) {
                writer.write(entry.getKey() + ";" + entry.getValue() + ";\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<Integer, String> readFile(StringStorageInHashMap stringStorage) {
        Map<Integer, String> stringMap = stringStorage.getStringStorageMap();
        try (BufferedReader reader = new BufferedReader(new FileReader("saveStringStorage.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(";");
                Integer id = Integer.parseInt(tokens[0]);
                String value = tokens[1];
                stringMap.put(id, value);
            }
            System.out.println("Стартовые данные были взяты из файла - saveStringStorage.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringMap;
    }
}
