package philharmonic.service.spring.service;

import java.util.List;
import philharmonic.service.spring.model.Order;
import philharmonic.service.spring.model.ShoppingCart;
import philharmonic.service.spring.model.User;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
