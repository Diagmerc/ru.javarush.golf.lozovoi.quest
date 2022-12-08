package ru.javarush.golf.servletquest.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Step {
    private final Integer id;

    private final Integer nextId;

    private final String answer;

    private final String question;

    public Step(Integer id, Integer nextId, String answer, String question) {
        this.id = id;
        this.nextId = nextId;
        this.answer = answer;
        this.question = question;
    }

    @Override
    public String toString() {
        return "Step{" +
                "currentId=" + id +
                ", nextId=" + nextId +
                ", text='" + answer + '\'' +
                ", question='" + question + '\'' +
                '}';
    }
}
