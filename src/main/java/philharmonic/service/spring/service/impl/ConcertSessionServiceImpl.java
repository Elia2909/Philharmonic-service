package philharmonic.service.spring.service.impl;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import philharmonic.service.spring.dao.ConcertSessionDao;
import philharmonic.service.spring.exception.DataProcessingException;
import philharmonic.service.spring.model.ConcertSession;
import philharmonic.service.spring.service.ConcertSessionService;

@Service
public class ConcertSessionServiceImpl implements ConcertSessionService {
    private final ConcertSessionDao concertSessionDao;

    public ConcertSessionServiceImpl(ConcertSessionDao concertSessionDao) {
        this.concertSessionDao = concertSessionDao;
    }

    @Override
    public List<ConcertSession> findAvailableSessions(Long concertId, LocalDate date) {
        return concertSessionDao.findAvailableSessions(concertId, date);
    }

    @Override
    public ConcertSession add(ConcertSession session) {
        return concertSessionDao.add(session);
    }

    @Override
    public ConcertSession get(Long id) {
        return concertSessionDao.get(id).orElseThrow(
                () -> new DataProcessingException("Session with id " + id + " not found"));
    }

    @Override
    public ConcertSession update(ConcertSession concertSession) {
        return concertSessionDao.update(concertSession);
    }

    @Override
    public void delete(Long id) {
        concertSessionDao.delete(id);
    }
}
