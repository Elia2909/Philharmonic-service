package philharmonic.service.spring.dao;

import philharmonic.service.spring.model.Stage;

import java.util.List;
import java.util.Optional;

public interface StageDao {
    Stage add(Stage Stage);

    Optional<Stage> get(Long id);

    List<Stage> getAll();
}
