package philharmonic.service.spring.dao;

import philharmonic.service.spring.model.Role;

import java.util.Optional;

public interface RoleDao {
    Role add(Role role);

    Optional<Role> getRoleByName(Role.RoleName roleName);
}
