package org.mystringstorage;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.assertEquals;


class ParserStringForCRUDTest {

    StringStorageInHashMap stringStorage = new StringStorageInHashMap();
    ParserStringForCRUD parser = new ParserStringForCRUD(stringStorage);

//    @BeforeAll
//    static void createStringStorage() {
//        stringStorage = new StringStorageInHashMap();
//    }
//
//    @BeforeAll
//    static void createParserForTest() {
//        parser = new ParserStringForCRUD(stringStorage);
//    }

//    GET|
//    UPDATE|
//    DELETE|
//    QUIT|

    @ParameterizedTest
    @CsvFileSource(resources = "dataTest.csv", delimiter = '|', numLinesToSkip = 1)
    void getCommandUser(String strByUser, String check) {
        parser.getCommandUser(strByUser);
        assertEquals(check,stringStorage.getStringStorageMap().get(1));
    }

//    @Test
//    @ParameterizedTest
//    @DisplayName("Получить строку для сохранения")
//    void getNewString() {
//
//    }
//
//    @Test
//    void searchStringIndex() {
//    }
}