package calvin.demo.services;

import calvin.demo.dto.UserRegistrationDto;
import calvin.demo.models.User;

public interface UserService {
    User findByUsername(String username) throws Exception;
    User login(UserRegistrationDto registrationDto) throws Exception;
    User register(UserRegistrationDto registrationDto) throws Exception;
}
