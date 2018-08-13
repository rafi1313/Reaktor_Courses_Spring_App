package reaktor.reaktorapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import reaktor.reaktorapp.model.entity.User;
import reaktor.reaktorapp.service.AutoMailingService;
import reaktor.reaktorapp.service.UserService;

@Controller
public class UserController {
    UserService userService;
    AutoMailingService autoMailingService;

    @Autowired
    public UserController(UserService userService, AutoMailingService autoMailingService) {
        this.userService = userService;
        this.autoMailingService = autoMailingService;
    }

    @GetMapping("/userProfile")
    public String userProfile(Model model, Authentication auth){

        return "userProfile";
    }



}
