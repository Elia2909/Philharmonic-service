package philharmonic.service.spring.dao.impl;

import philharmonic.service.spring.dao.AbstractDao;
import philharmonic.service.spring.dao.ConcertDao;
import philharmonic.service.spring.model.Concert;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ConcertDaoImpl extends AbstractDao<Concert> implements ConcertDao {
    public ConcertDaoImpl(SessionFactory factory) {
        super(factory, Concert.class);
    }
}
