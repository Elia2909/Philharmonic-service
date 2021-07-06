package philharmonic.service.spring.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import philharmonic.service.spring.dao.ConcertDao;
import philharmonic.service.spring.exception.DataProcessingException;
import philharmonic.service.spring.model.Concert;
import philharmonic.service.spring.service.ConcertService;

@Service
public class ConcertServiceImpl implements ConcertService {
    private final ConcertDao concertDao;

    public ConcertServiceImpl(ConcertDao concertDao) {
        this.concertDao = concertDao;
    }

    @Override
    public Concert add(Concert concert) {
        return concertDao.add(concert);
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
