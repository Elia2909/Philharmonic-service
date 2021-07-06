package philharmonic.service.spring.dao.impl;

import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import philharmonic.service.spring.dao.AbstractDao;
import philharmonic.service.spring.dao.RoleDao;
import philharmonic.service.spring.exception.DataProcessingException;
import philharmonic.service.spring.model.Role;

@Repository
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {
    public RoleDaoImpl(SessionFactory factory) {
        super(factory, Role.class);
    }

    @Override
    public Optional<Role> getRoleByName(Role.RoleName roleName) {
        try (Session session = factory.openSession()) {
            return session.createQuery("from Role WHERE name = :name", Role.class)
                    .setParameter("name", roleName)
                    .uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException(roleName + " role not found", e);
        }
    }
}
