package philharmonic.service.spring.service.impl;

import philharmonic.service.spring.dao.ShoppingCartDao;
import philharmonic.service.spring.dao.TicketDao;
import philharmonic.service.spring.model.ConcertSession;
import philharmonic.service.spring.model.ShoppingCart;
import philharmonic.service.spring.model.Ticket;
import philharmonic.service.spring.model.User;
import philharmonic.service.spring.service.ShoppingCartService;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartDao shoppingCartDao;
    private final TicketDao ticketDao;

    public ShoppingCartServiceImpl(ShoppingCartDao shoppingCartDao, TicketDao ticketDao) {
        this.shoppingCartDao = shoppingCartDao;
        this.ticketDao = ticketDao;
    }

    @Override
    public void addSession(ConcertSession ConcertSession, User user) {
        Ticket ticket = new Ticket();
        ticket.setConcertSession(ConcertSession);
        ticket.setUser(user);
        ShoppingCart shoppingCart = shoppingCartDao.getByUser(user);
        ticketDao.add(ticket);
        shoppingCart.getTickets().add(ticket);
        shoppingCartDao.update(shoppingCart);
    }

    @Override
    public ShoppingCart getByUser(User user) {
        return shoppingCartDao.getByUser(user);
    }

    @Override
    public void registerNewShoppingCart(User user) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
        shoppingCartDao.add(shoppingCart);
    }

    @Override
    public void clear(ShoppingCart shoppingCart) {
        shoppingCart.setTickets(null);
        shoppingCartDao.update(shoppingCart);
    }
}
