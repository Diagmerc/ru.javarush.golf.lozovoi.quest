package golf.servletquest.repository;

import golf.servletquest.TestData;
import golf.servletquest.entity.Step;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StepRepositoryTest {
    List<Step> stepList = new TestData().stepList;
    List<Step> actual = Arrays.asList(
            new Step(1, 2, "answer1", "question1"),
            new Step(1, 3, "answer2", "question1"),
            new Step(3, 4, "answer3", "question2"),
            new Step(3, 5, "answer4", "question2"));


    @Test
    void getByNextId() {
        List<Step> expected = new StepRepository(stepList).getByNextId(3);
        assertEquals(expected.get(0).toString(), actual.get(2).toString());
        assertEquals(expected.get(1).toString(), actual.get(3).toString());
    }

    @Test
    void getByNextWithWrongId() {
        List<Step> actual = new StepRepository(stepList).getByNextId(5);
        assertEquals(null, actual);
    }

    @Test
    void getFirstAnswers() {
        List<Step> expected = new StepRepository(stepList).getFirstAnswers();
        assertEquals(expected.get(0).toString(), actual.get(0).toString());
        assertEquals(expected.get(1).toString(), actual.get(1).toString());
    }

    @Test
    void getQuestionById() {
        Step expected = new StepRepository(stepList).getQuestionById(3);
        assertEquals(expected.toString(), actual.get(2).toString());
    }

    @Test
    void getQuestionWithWrongId() {
        assertEquals(null, new StepRepository(stepList).getQuestionById(7));
    }

    @Test
    void getFirstQuestion() {
        Step expected = new StepRepository(stepList).getFirstQuestion();
        assertEquals(expected.toString(), actual.get(0).toString());
    }
}