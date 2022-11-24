package golf.servletquest.service;

import com.google.gson.Gson;
import golf.servletquest.entity.Step;
import golf.servletquest.repository.InMemoryStepRepository;
import golf.servletquest.repository.StepRepository;

import java.io.FileReader;
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
