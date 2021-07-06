package philharmonic.service.spring.service.impl;

import philharmonic.service.spring.dao.ConcertSessionDao;
import philharmonic.service.spring.exception.DataProcessingException;
import philharmonic.service.spring.model.ConcertSession;
import philharmonic.service.spring.service.ConcertSessionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ConcertSessionServiceImpl implements ConcertSessionService {
    private final ConcertSessionDao concertSessionDao;

    public ConcertSessionServiceImpl(ConcertSessionDao ConcertSessionDao) {
        this.concertSessionDao = ConcertSessionDao;
    }

    @Override
    public List<ConcertSession> findAvailableSessions(Long ConcertId, LocalDate date) {
        return concertSessionDao.findAvailableSessions(ConcertId, date);
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
    public ConcertSession update(ConcertSession ConcertSession) {
        return concertSessionDao.update(ConcertSession);
    }

    @Override
    public void delete(Long id) {
        concertSessionDao.delete(id);
    }
}
