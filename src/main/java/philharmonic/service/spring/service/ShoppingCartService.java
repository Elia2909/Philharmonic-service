package philharmonic.service.spring.service;

import philharmonic.service.spring.model.ConcertSession;
import philharmonic.service.spring.model.ShoppingCart;
import philharmonic.service.spring.model.User;

public interface ShoppingCartService {
    void addSession(ConcertSession ConcertSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
