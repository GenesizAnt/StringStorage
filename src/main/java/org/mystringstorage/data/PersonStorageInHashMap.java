package org.mystringstorage.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class PersonStorageInHashMap implements CRUDable {

    private ObjectMapper objectMapper = new ObjectMapper();
    private int personIdCount = 1;
    private HashMap<Integer, Person> personStorageMap = new HashMap<>();

    public int getPersonIdCount() {
        return personIdCount;
    }

    public HashMap<Integer, Person> getPersonStorageMap() {
        return personStorageMap;
    }

    public int incrementPersonIdCount() {
        return personIdCount++;
    }

    public void setPersonStorageMap(HashMap<Integer, Person> personStorageMap) {
        this.personStorageMap = personStorageMap;
        this.personIdCount = personStorageMap.size() + 1;
    }

    @Override
    public void create(String userString) {
        if (isCorrectPersonInformation(userString)) {
            personStorageMap.put(getPersonIdCount(), personFromJSON(userString));
            System.out.println("Person saved with id = " + incrementPersonIdCount());
        }
    }

    @Override
    public void updateString(int index, String userString) {
        if(isCorrectIndex(index) && isCorrectPersonInformation(userString)) {
            personStorageMap.put(index, personFromJSON(userString));
            System.out.println("Person with id: " + index + " updated");
        }
    }

    @Override
    public void delete(int index) {
        if (isCorrectIndex(index)) {
            personStorageMap.remove(index);
            System.out.println("Person with id: " + index + " deleted");
        }
    }

    @Override
    public void getByIndex(int index) {
        if (isCorrectIndex(index)) {
            System.out.println("Person with id: " + index + " = " + personStorageMap.get(index));
        }
    }

    @Override
    public void getAll() {
        for (Map.Entry<Integer, Person> entry : personStorageMap.entrySet()) {
            System.out.println("Person with id: " + entry.getKey() + " = " + entry.getValue());
        }
    }

    private boolean isCorrectPersonInformation(String personInformation) {
        try {
            objectMapper.readValue(personInformation, Person.class);
            return true;
        } catch (JsonProcessingException e) {
            System.out.println("Неправильный формат данных!");
            return false;
        }
    }

    private Person personFromJSON (String personInformation) {
        try {
            return objectMapper.readValue(personInformation, Person.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isCorrectIndex(int index) {
        if (personStorageMap.isEmpty()) {
            System.out.println("База Person еще пустая!");
            return false;
        } else if (index > personStorageMap.size()) {
            System.err.println("Person с таким индексом еще не создан!");
            return false;
        } else if (index <= 0) {
            System.out.println("Такой Person не может существовать!");
            return false;
        } else if (!personStorageMap.containsKey(index)) {
            System.err.println("Person с индексом " + index + " уже был удален!");
            return false;
        } else {
            return true;
        }
    }
}
