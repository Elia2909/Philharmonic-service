package philharmonic.service.spring.dao.impl;

import philharmonic.service.spring.dao.AbstractDao;
import philharmonic.service.spring.dao.ConcertSessionDao;
import philharmonic.service.spring.exception.DataProcessingException;
import philharmonic.service.spring.model.ConcertSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class ConcertSessionDaoImpl extends AbstractDao<ConcertSession> implements ConcertSessionDao {
    public ConcertSessionDaoImpl(SessionFactory factory) {
        super(factory, ConcertSession.class);
    }

    @Override
    public List<ConcertSession> findAvailableSessions(Long ConcertId, LocalDate date) {
        try (Session session = factory.openSession()) {
            Query<ConcertSession> getAvailableSessions = session.createQuery(
                    "FROM ConcertSession WHERE id = :id "
                            + "AND DATE_FORMAT(showTime, '%Y-%m-%d') = :date", ConcertSession.class);
            getAvailableSessions.setParameter("id", ConcertId);
            getAvailableSessions.setParameter("date", date.toString());
            return getAvailableSessions.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Session for Concert with id "
                    + ConcertId + " and show date " + date + " not found", e);
        }
    }
}
