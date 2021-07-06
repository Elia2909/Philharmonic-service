package philharmonic.service.spring.service.impl;

import philharmonic.service.spring.model.Role;
import philharmonic.service.spring.model.User;
import philharmonic.service.spring.service.AuthenticationService;
import philharmonic.service.spring.service.RoleService;
import philharmonic.service.spring.service.ShoppingCartService;
import philharmonic.service.spring.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final RoleService roleService;

    public AuthenticationServiceImpl(UserService userService,
                                     ShoppingCartService shoppingCartService,
                                     RoleService roleService) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.roleService = roleService;
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setRoles(Set.of(roleService.getRoleByName(Role.RoleName.USER)));
        userService.add(user);
        shoppingCartService.registerNewShoppingCart(user);
        return user;
    }
}
