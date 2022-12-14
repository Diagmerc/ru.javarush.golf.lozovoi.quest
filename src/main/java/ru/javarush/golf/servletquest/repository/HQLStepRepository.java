package ru.javarush.golf.servletquest.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ru.javarush.golf.servletquest.entity.Step;

import java.util.List;
import java.util.Properties;

public class HQLStepRepository implements StepRepository {
    public SessionFactory sessionFactory;
    private Properties properties;

    public static void main(String[] args) {
        HQLStepRepository hqlStepRepository = new HQLStepRepository();
        hqlStepRepository.getQuestionById(2);

    }

    public HQLStepRepository() {
//        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        sessionFactory = new Configuration().buildSessionFactory();
//        properties = new Properties();
//        properties.put(Environment.DRIVER, "org.postgresql.Driver");
//        properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/postgres");
//        properties.put(Environment.USER, "testuser");
//        properties.put(Environment.PASS, "testuser");
//
//        sessionFactory = new Configuration()
//                .setProperties(properties)
//                .buildSessionFactory();
    }

    @Override
    public List<Step> getAllSteps() {
        try (Session session = sessionFactory.openSession()) {
            Query<Step> query = session.createQuery("from Step", Step.class);
            return query.list();
        }
    }

    @Override
    public List<Step> getByNextId(int next) {
        String hql = "select Step where id=:id";
        try (Session session = sessionFactory.openSession()) {
            Query<Step> query = session.createQuery(hql, Step.class);
            query.setParameter("id", next);
            return query.list();
        }
    }

    @Override
    public List<Step> getFirstAnswers() {
        return getByNextId(1);
    }

    @Override
    public Step getQuestionById(int current) {
        try (Session session = sessionFactory.openSession()) {
            Step step = session.get(Step.class, current);
            return step;
        }
    }

    @Override
    public Step getFirstQuestion() {
        return getQuestionById(1);
    }
}
