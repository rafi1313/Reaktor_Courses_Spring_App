package reaktor.reaktorapp.controller;

import org.springframework.stereotype.Controller;
import reaktor.reaktorapp.service.AutoMailingService;
import reaktor.reaktorapp.service.ContactService;

@Controller
public class MainController {

    ContactService contactService;
    AutoMailingService autoMailingService;
}
