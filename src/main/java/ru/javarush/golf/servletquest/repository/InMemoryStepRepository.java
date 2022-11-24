package ru.javarush.golf.servletquest.repository;

import ru.javarush.golf.servletquest.entity.Step;

import java.util.List;
import java.util.stream.Collectors;

public class InMemoryStepRepository implements StepRepository {
    private final List<Step> steps;

    public InMemoryStepRepository(List<Step> stepsList) {
        this.steps = stepsList;
    }

    @Override
    public List<Step> getAllSteps() {
        return steps;
    }

    @Override
    public List<Step> getByNextId(int next) {
        List<Step> collect = steps.stream().filter(step -> step.getId() == next).collect(Collectors.toList());
        return collect.size() < 2 ? null : collect;
    }

    @Override
    public List<Step> getFirstAnswers() {
        return steps.stream().filter(step -> step.getId() == 1).collect(Collectors.toList());
    }

    @Override
    public Step getQuestionById(int current) {
        return steps.stream()
                .filter(step -> step.getId() == current)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Step getFirstQuestion() {
        return steps.stream()
                .filter(step -> step.getId() == 1)
                .findFirst()
                .orElse(null);
    }
}
