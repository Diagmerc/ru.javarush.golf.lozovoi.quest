package golf.servletquest.repository;

import golf.servletquest.entity.Step;

import java.util.List;

public interface StepRepository {
    List<Step> getAllSteps();

    List<Step> getByNextId(int next);

    List<Step> getFirstAnswers();

    Step getQuestionById(int current);

    Step getFirstQuestion();
}
