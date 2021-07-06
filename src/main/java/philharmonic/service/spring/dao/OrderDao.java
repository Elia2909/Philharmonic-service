package philharmonic.service.spring.dao;

import java.util.List;
import philharmonic.service.spring.model.Order;
import philharmonic.service.spring.model.User;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrdersHistory(User user);
}
