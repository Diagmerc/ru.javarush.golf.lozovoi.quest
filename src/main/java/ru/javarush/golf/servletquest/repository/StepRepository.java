package ru.javarush.golf.servletquest.repository;

import ru.javarush.golf.servletquest.entity.Step;

import java.sql.SQLException;
import java.util.List;

public interface StepRepository {
    List<Step> getAllSteps();

    List<Step> getByNextId(int next);

    List<Step> getFirstAnswers();

    Step getQuestionById(int current);

    Step getFirstQuestion();
}
