package philharmonic.service.spring.service;

import philharmonic.service.spring.model.Role;

public interface RoleService {
    void add(Role role);

    Role getRoleByName(Role.RoleName roleName);
}
