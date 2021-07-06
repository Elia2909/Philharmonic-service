package philharmonic.service.spring.dao.impl;

import philharmonic.service.spring.dao.AbstractDao;
import philharmonic.service.spring.dao.ShoppingCartDao;
import philharmonic.service.spring.exception.DataProcessingException;
import philharmonic.service.spring.model.ShoppingCart;
import philharmonic.service.spring.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ShoppingCartDaoImpl extends AbstractDao<ShoppingCart> implements ShoppingCartDao {
    public ShoppingCartDaoImpl(SessionFactory factory) {
        super(factory, ShoppingCart.class);
    }

    @Override
    public ShoppingCart getByUser(User user) {
        try (Session session = factory.openSession()) {
            Query<ShoppingCart> getByUser = session.createQuery(
                    "SELECT DISTINCT sc FROM ShoppingCart sc "
                            + "left join fetch sc.tickets t "
                            + "left join fetch t.ConcertSession ms "
                            + "left join fetch ms.Stage "
                            + "left join fetch ms.Concert "
                            + "WHERE sc.user = :user", ShoppingCart.class);
            getByUser.setParameter("user", user);
            return getByUser.getSingleResult();
        } catch (Exception e) {
            throw new DataProcessingException("Not found shopping cart for user " + user, e);
        }
    }
}
