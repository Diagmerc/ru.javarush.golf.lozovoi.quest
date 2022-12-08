package ru.javarush.golf.servletquest.service;

import com.google.gson.Gson;
import ru.javarush.golf.servletquest.entity.Step;
import ru.javarush.golf.servletquest.repository.InMemoryStepRepository;
import ru.javarush.golf.servletquest.repository.StepRepository;

import java.io.FileReader;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class JsonParserService {
    private final Gson gson = new Gson();

    public List<Step> parseSteps(String quest) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String file = classLoader.getResource(quest).getFile();
        StepRepository repository = null;
        try (FileReader reader = new FileReader(file)) {
            repository = gson.fromJson(reader, InMemoryStepRepository.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Objects.requireNonNull(repository).getAllSteps();
    }
}
