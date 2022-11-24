package ru.javarush.golf.servletquest.service;

import ru.javarush.golf.servletquest.TestData;
import ru.javarush.golf.servletquest.entity.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonParserServiceTest {


    @Test
    void parseStepsWithWrongPath() {
        String wrongPath = "questSteps.json";
        Assertions.assertThrows(NullPointerException.class, () -> new JsonParserService().parseSteps(wrongPath));
    }

    @Test
    void parseStepsWithCurrentPath() {
        String currentPath = "questStepsRU.json";
        List<Step> actual = new JsonParserService().parseSteps(currentPath);
        List<Step> expected = new TestData().stepList;
        assertEquals(expected.get(1).toString(), actual.get(1).toString());
    }
}