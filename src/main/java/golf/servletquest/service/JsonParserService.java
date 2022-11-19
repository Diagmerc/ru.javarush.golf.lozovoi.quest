package golf.servletquest.service;

import com.google.gson.Gson;
import golf.servletquest.repository.StepRepository;

import java.io.*;

public class JsonParserService {
    public StepRepository parseSteps(String quest) {
        Gson gson = new Gson();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String file = classLoader.getResource(quest).getFile();
        StepRepository stepRepository = null;
        try (FileReader reader = new FileReader(file)) {
            stepRepository = gson.fromJson(reader, StepRepository.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stepRepository;
    }
}
