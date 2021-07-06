package philharmonic.service.spring.service.impl;

import philharmonic.service.spring.dao.ConcertDao;
import philharmonic.service.spring.exception.DataProcessingException;
import philharmonic.service.spring.model.Concert;
import philharmonic.service.spring.service.ConcertService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConcertServiceImpl implements ConcertService {
    private final ConcertDao concertDao;

    public ConcertServiceImpl(ConcertDao ConcertDao) {
        this.concertDao = ConcertDao;
    }

    @Override
    public Concert add(Concert Concert) {
        return concertDao.add(Concert);
    }

    @Override
    public Concert get(Long id) {
        return concertDao.get(id).orElseThrow(
                () -> new DataProcessingException("Can't get Concert by id " + id));
    }

    @Override
    public List<Concert> getAll() {
        return concertDao.getAll();
    }
}
