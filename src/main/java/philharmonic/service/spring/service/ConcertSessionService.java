package philharmonic.service.spring.service;

import philharmonic.service.spring.model.ConcertSession;

import java.time.LocalDate;
import java.util.List;

public interface ConcertSessionService {
    List<ConcertSession> findAvailableSessions(Long ConcertId, LocalDate date);

    ConcertSession add(ConcertSession session);

    ConcertSession get(Long id);

    ConcertSession update(ConcertSession ConcertSession);

    void delete(Long id);
}
