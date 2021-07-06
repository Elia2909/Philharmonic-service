package philharmonic.service.spring.service.impl;

import philharmonic.service.spring.dao.OrderDao;
import philharmonic.service.spring.model.Order;
import philharmonic.service.spring.model.ShoppingCart;
import philharmonic.service.spring.model.User;
import philharmonic.service.spring.service.OrderService;
import philharmonic.service.spring.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderDao orderDao;
    private final ShoppingCartService shoppingCartService;

    public OrderServiceImpl(OrderDao orderDao, ShoppingCartService shoppingCartService) {
        this.orderDao = orderDao;
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public Order completeOrder(ShoppingCart shoppingCart) {
        Order order = new Order();
        order.setOrderTime(LocalDateTime.now());
        order.setTickets(shoppingCart.getTickets());
        order.setUser(shoppingCart.getUser());
        orderDao.add(order);
        shoppingCartService.clear(shoppingCart);
        return order;
    }

    @Override
    public List<Order> getOrdersHistory(User user) {
        return orderDao.getOrdersHistory(user);
    }
}
