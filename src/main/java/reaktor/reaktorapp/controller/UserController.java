package reaktor.reaktorapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
}
