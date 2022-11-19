package golf.servletquest.repository;

import golf.servletquest.entity.Step;

import java.util.List;
import java.util.stream.Collectors;

public class StepRepository {
    private List<Step> list;

    public StepRepository(List<Step> stepList) {
        this.list = stepList;
    }

    public List<Step> getList() {
        return list;
    }

    public List<Step> getByNextId(int next) {
        List<Step> collect = list.stream().filter(step -> step.getId() == next).collect(Collectors.toList());
        return collect.size() < 2 ? null : collect;
    }

    public List<Step> getFirstAnswers() {
        return list.stream().filter(step -> step.getId() == 1).collect(Collectors.toList());
    }

    public Step getQuestionById(int current) {
        return list.stream()
                .filter(step -> step.getId() == current)
                .findFirst()
                .orElse(null);
    }

    public Step getFirstQuestion() {
        return list.stream()
                .filter(step -> step.getId() == 1)
                .findFirst()
                .orElse(null);
    }
}
