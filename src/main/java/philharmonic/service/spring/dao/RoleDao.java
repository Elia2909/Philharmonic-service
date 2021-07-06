package philharmonic.service.spring.dao;

import java.util.Optional;
import philharmonic.service.spring.model.Role;

public interface RoleDao {
    Role add(Role role);

    Optional<Role> getRoleByName(Role.RoleName roleName);
}
