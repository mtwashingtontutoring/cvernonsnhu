package calvin.demo.services;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import calvin.demo.dto.UserRegistrationDto;
import calvin.demo.models.Role;
import calvin.demo.models.User;
import calvin.demo.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
   
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository =  userRepository;
    }

    @Override
    public User findByUsername(String username) throws Exception {
        return this.userRepository.findByUsername(username).orElse(null)   ;
    }

    @Override
    public User register(UserRegistrationDto registrationDto) {
        if(userRepository.existsByUsername(registrationDto.getUsername())) {
            return null;
        }
        User user =  new User(registrationDto.getFirstName(),
                 registrationDto.getLastName(), registrationDto.getUsername(),
                 registrationDto.getPassword(), Arrays.asList(new Role("ROLE_USER")));
         
        return userRepository.save(user);
    }

    @Override
    public User login(UserRegistrationDto loginDto) {
        User existingUser = userRepository.findByUsername(loginDto.getUsername()).orElse(null);
        if(existingUser != null && existingUser.getPassword().equals(loginDto.getPassword())) {
            return existingUser;
        }
        return null;
    }
}