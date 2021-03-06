package philharmonic.service.spring.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import philharmonic.service.spring.dao.AbstractDao;
import philharmonic.service.spring.dao.TicketDao;
import philharmonic.service.spring.model.Ticket;

@Repository
public class TicketDaoImpl extends AbstractDao<Ticket> implements TicketDao {
    public TicketDaoImpl(SessionFactory factory) {
        super(factory, Ticket.class);
    }
}
