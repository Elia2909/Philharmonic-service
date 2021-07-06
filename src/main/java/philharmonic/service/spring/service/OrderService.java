package philharmonic.service.spring.service;

import philharmonic.service.spring.model.Order;
import philharmonic.service.spring.model.ShoppingCart;
import philharmonic.service.spring.model.User;

import java.util.List;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
