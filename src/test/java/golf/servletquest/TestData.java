package golf.servletquest;

import golf.servletquest.entity.Step;

import java.util.Arrays;
import java.util.List;

public class TestData {
    public final List<Step> stepList = Arrays.asList(
            new Step(1, 2, "answer1", "question1"),
            new Step(1, 3, "answer2", "question1"),
            new Step(3, 4, "answer3", "question2"),
            new Step(3, 5, "answer4", "question2")
    );
}