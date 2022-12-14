package ru.javarush.golf.servletquest.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Step {
    @Id
    @Column(name = "id")
    private final Integer id;
    @Column(name = "nextid")
    private final Integer nextId;
    @Column(name = "answer")
    private final String answer;
    @Column(name = "question")
    private final String question;

    public Step(Integer id, Integer nextId, String answer, String question) {
        this.id = id;
        this.nextId = nextId;
        this.answer = answer;
        this.question = question;
    }

    public Step() {
        this.id = null;
        this.nextId = null;
        this.answer = null;
        this.question = null;
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
