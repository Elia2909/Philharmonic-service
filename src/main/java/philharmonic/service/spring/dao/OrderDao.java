package philharmonic.service.spring.dao;

import philharmonic.service.spring.model.Order;
import philharmonic.service.spring.model.User;

import java.util.List;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrdersHistory(User user);
}
