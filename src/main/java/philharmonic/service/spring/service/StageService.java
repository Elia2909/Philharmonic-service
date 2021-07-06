package philharmonic.service.spring.service;

import philharmonic.service.spring.model.Stage;

import java.util.List;

public interface StageService {
    Stage add(Stage Stage);

    Stage get(Long id);

    List<Stage> getAll();
}
