package ru.javarush.golf.servletquest.repository;

import ru.javarush.golf.servletquest.entity.Step;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcStepRepository implements StepRepository {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private Statement statement;

    public JdbcStepRepository(String url, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        statement = connection.createStatement();
    }

    @Override
    public List<Step> getAllSteps() {
        ResultSet resultSet = null;
        List<Step> steps = new ArrayList<>();
        try {
            resultSet = statement.executeQuery("SELECT * FROM quest");
            while (resultSet.next()) {
                Step step = new Step(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                );
                steps.add(step);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return steps;
    }

    @Override
    public List<Step> getByNextId(int next) {
        List<Step> steps = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM quest WHERE id=?");
            preparedStatement.setInt(1, next);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Step step = new Step(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                );
                steps.add(step);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return steps;
    }

    @Override
    public List<Step> getFirstAnswers() {
        return getByNextId(1);
    }

    @Override
    public Step getQuestionById(int current) {
        Step step = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM quest WHERE id=?");
            preparedStatement.setInt(1, current);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                step = new Step(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return step;
    }

    @Override
    public Step getFirstQuestion() {
        return getQuestionById(1);
    }
}
