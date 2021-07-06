package philharmonic.service.spring.controller;

import philharmonic.service.spring.dto.response.ShoppingCartResponseDto;
import philharmonic.service.spring.model.ConcertSession;
import philharmonic.service.spring.model.User;
import philharmonic.service.spring.service.ConcertSessionService;
import philharmonic.service.spring.service.ShoppingCartService;
import philharmonic.service.spring.service.UserService;
import philharmonic.service.spring.service.mapper.ShoppingCartMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final ShoppingCartMapper shoppingCartMapper;
    private final ConcertSessionService ConcertSessionService;
    private final UserService userService;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  ShoppingCartMapper shoppingCartMapper,
                                  UserService userService,
                                  ConcertSessionService ConcertSessionService) {
        this.shoppingCartService = shoppingCartService;
        this.shoppingCartMapper = shoppingCartMapper;
        this.userService = userService;
        this.ConcertSessionService = ConcertSessionService;
    }

    @PostMapping("/Concert-sessions")
    public void addToCart(Authentication auth, @RequestParam Long ConcertSessionId) {
        UserDetails details = (UserDetails) auth.getPrincipal();
        User user = userService.findByEmail(details.getUsername());
        ConcertSession ConcertSession = ConcertSessionService.get(ConcertSessionId);
        shoppingCartService.addSession(ConcertSession, user);
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(Authentication auth) {
        UserDetails details = (UserDetails) auth.getPrincipal();
        User user = userService.findByEmail(details.getUsername());
        return shoppingCartMapper.mapToDto(shoppingCartService.getByUser(user));
    }
}
