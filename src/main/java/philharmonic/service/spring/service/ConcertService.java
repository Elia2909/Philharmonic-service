package philharmonic.service.spring.service;

import java.util.List;
import philharmonic.service.spring.model.Concert;

public interface ConcertService {
    Concert add(Concert concert);

    Concert get(Long id);

    List<Concert> getAll();
}
