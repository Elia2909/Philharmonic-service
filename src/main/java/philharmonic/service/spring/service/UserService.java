package philharmonic.service.spring.service;

import philharmonic.service.spring.model.User;

public interface UserService {
    User add(User user);

    User get(Long id);

    User findByEmail(String email);
}
