package ru.javarush.golf.servletquest.db_values_injector;

import ru.javarush.golf.servletquest.entity.Step;
import ru.javarush.golf.servletquest.service.JsonParserService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class InjectValuesToDB {

    public static void main(String[] args) throws SQLException {
        new InjectValuesToDB().insertValuesToDB();
    }
    public void insertValuesToDB() throws SQLException {
        List<Step> stepRepository = new JsonParserService().parseSteps("questStepsRU.json");
        Connection connection  = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres",
                "testuser", "testuser");
        String sqlInsert = ("INSERT INTO quest (id, nextid, answer, question) VALUES (?,?,?,?)");
        PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);

        for (Step step : stepRepository) {
            preparedStatement.setInt(1,step.getId());
            preparedStatement.setInt(2,step.getId());
            preparedStatement.setString(3, step.getAnswer());
            preparedStatement.setString(4, step.getQuestion());
            preparedStatement.executeUpdate();
        }
        connection.close();
    }
}
