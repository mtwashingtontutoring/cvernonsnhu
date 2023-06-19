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
@RequestMapping("/login")
public class LoginController {
    
    private UserService userService;
    
    public LoginController(UserService userService) {
        super();
        this.userService = userService;
    }

    @ModelAttribute("loginInfo")
    public UserRegistrationDto userRegistrationDto() {
        UserRegistrationDto regDto = new UserRegistrationDto();

        //regDto.setUsername("testuser");
        //regDto.setPassword("password");
        return regDto;
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        //model.addAttribute("loginInfo", new UserRegistrationDto());
        return "login";
    }

    @PostMapping
    public String registerUserAccount(
        Model model,
        @ModelAttribute("loginInfo") UserRegistrationDto registrationDto
    ) throws Exception {
        User authenticatedUser = userService.login(registrationDto);
        if(authenticatedUser != null) {
            return "redirect:/home?success";
        }
        
        return showRegistrationForm(model);
    }
}
