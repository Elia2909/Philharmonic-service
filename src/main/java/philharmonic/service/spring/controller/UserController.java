package philharmonic.service.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import philharmonic.service.spring.dto.response.UserResponseDto;
import philharmonic.service.spring.model.User;
import philharmonic.service.spring.service.UserService;
import philharmonic.service.spring.service.mapper.UserMapper;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserMapper userMapper;
    private final UserService userService;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/by-email")
    public UserResponseDto getByEmail(@RequestParam String email) {
        User user = userService.findByEmail(email);
        return userMapper.mapToDto(user);
    }
}
