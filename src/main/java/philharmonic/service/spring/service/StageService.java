package philharmonic.service.spring.service;

import java.util.List;
import philharmonic.service.spring.model.Stage;

public interface StageService {
    Stage add(Stage stage);

    Stage get(Long id);

    List<Stage> getAll();
}
