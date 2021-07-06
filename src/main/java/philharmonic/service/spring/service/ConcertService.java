package philharmonic.service.spring.service;

import philharmonic.service.spring.model.Concert;

import java.util.List;

public interface ConcertService {
    Concert add(Concert Concert);

    Concert get(Long id);

    List<Concert> getAll();
}
