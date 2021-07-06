package philharmonic.service.spring.dao;

import philharmonic.service.spring.model.ConcertSession;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ConcertSessionDao {
    ConcertSession add(ConcertSession ConcertSession);

    Optional<ConcertSession> get(Long id);

    List<ConcertSession> findAvailableSessions(Long ConcertId, LocalDate date);

    ConcertSession update(ConcertSession ConcertSession);

    void delete(Long id);
}
