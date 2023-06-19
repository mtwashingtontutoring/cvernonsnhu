package calvin.demo.webcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import calvin.demo.dto.UserRegistrationDto;
import calvin.demo.models.User;
import calvin.demo.services.UserService;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
    
    private UserService userService;
    
    public UserRegistrationController(UserService userService) {
        super();
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("registrationInfo", new UserRegistrationDto());
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(
        Model model,
        @ModelAttribute("registrationInfo") UserRegistrationDto registrationDto
    ) throws Exception {
        boolean valid = true;
        String email = registrationDto.getUsername();
        String password = registrationDto.getPassword();
        String passwordVerify = registrationDto.getPasswordVerify();

        if(email == null || email.length() == 0) {
            valid = false;
        }

        if(password == null || password.length() == 0) {
            valid = false;
        }

        if(password != null && !password.equals(passwordVerify)) {
            valid = false;
        }


        if(valid){
            User registeredUser = userService.register(registrationDto);
            if(registeredUser != null) {
                return "redirect:/home?success";
            }
        }
        
        return showRegistrationForm(model);
    }
}
