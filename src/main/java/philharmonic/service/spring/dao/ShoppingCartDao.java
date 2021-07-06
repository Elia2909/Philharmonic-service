package philharmonic.service.spring.dao;

import philharmonic.service.spring.model.ShoppingCart;
import philharmonic.service.spring.model.User;

public interface ShoppingCartDao {
    ShoppingCart add(ShoppingCart shoppingCart);

    ShoppingCart getByUser(User user);

    ShoppingCart update(ShoppingCart shoppingCart);
}
