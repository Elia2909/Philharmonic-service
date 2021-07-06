package philharmonic.service.spring.service.impl;

import philharmonic.service.spring.dao.RoleDao;
import philharmonic.service.spring.exception.DataProcessingException;
import philharmonic.service.spring.model.Role;
import philharmonic.service.spring.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void add(Role role) {
        roleDao.add(role);
    }

    @Override
    public Role getRoleByName(Role.RoleName roleName) {
        return roleDao.getRoleByName(roleName)
                .orElseThrow(() -> new DataProcessingException("Role Name "
                        + roleName + " not found"));
    }

}