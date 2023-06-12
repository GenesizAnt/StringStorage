package org.mystringstorage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {

        StartCRUDapp app = new StartCRUDapp();
        app.startApp();

//        Person person = new Person("Anton", 32);
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        String personJson ="{\"name\":\"Anton\",\"age\":33333}";
//
//        try {
//            Person person1 = objectMapper.readValue(personJson, Person.class);
//            System.out.println(person1);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//
//        try {
//            String json = objectMapper.writeValueAsString(person);
//            System.out.println(json);
//            String[] dd = json.split(" ");
//            for (int i = 0; i < dd.length; i++) {
//                System.out.println(dd[i]);
//            }
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
    }
}