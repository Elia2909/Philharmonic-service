package philharmonic.service.spring.service;

import philharmonic.service.spring.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
