package calvin.demo.Security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import calvin.demo.models.User;
import calvin.demo.services.UserService;

@Service
public class CustomUserDetailService implements UserDetailsService{
    UserService userService;

    public CustomUserDetailService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            System.out.println("CustomUserDetailService.loadUserByUsername() called");
            User user = userService.findByUsername(username);

            if(user == null) {
                throw new UsernameNotFoundException(username);
            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            throw new UsernameNotFoundException(username, e);
        }
    }
}
