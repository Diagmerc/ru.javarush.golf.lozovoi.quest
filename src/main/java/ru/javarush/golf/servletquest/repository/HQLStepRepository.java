package ru.javarush.golf.servletquest.repository;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import ru.javarush.golf.servletquest.entity.Step;

import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class HQLStepRepository implements StepRepository {
    public SessionFactory sessionFactory;

    public HQLStepRepository() {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Step.class).buildSessionFactory();
    }

    @Override
    public List<Step> getAllSteps() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query<Step> query = session.createQuery("from Step", Step.class);
            session.getTransaction().commit();
            return query.list();
        }
    }

    @Override
    public List<Step> getByNextId(int next) {
        List<Step> collect = getAllSteps().stream().filter(step -> step.getId() == next).collect(Collectors.toList());
        return collect.size() < 2 ? null : collect;
    }

    @Override
    public List<Step> getFirstAnswers() {
        return getAllSteps().stream().filter(step -> step.getId() == 1).collect(Collectors.toList());
    }

    @Override
    public Step getQuestionById(int current) {
        return getAllSteps().stream()
                .filter(step -> step.getId() == current)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Step getFirstQuestion() {
        return getAllSteps().stream()
                .filter(step -> step.getId() == 1)
                .findFirst()
                .orElse(null);
    }
}
