package philharmonic.service.spring.dao;

import philharmonic.service.spring.model.Concert;

import java.util.List;
import java.util.Optional;

public interface ConcertDao {
    Concert add(Concert Concert);

    Optional<Concert> get(Long id);

    List<Concert> getAll();
}
