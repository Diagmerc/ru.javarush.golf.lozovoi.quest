package golf.servletquest.service;

import golf.servletquest.TestData;
import golf.servletquest.entity.Step;
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
        List<Step> actual = new JsonParserService().parseSteps(currentPath).getList();
        List<Step> expected = new TestData().stepList;
        assertEquals(expected.get(1).toString(), actual.get(1).toString());
    }
}