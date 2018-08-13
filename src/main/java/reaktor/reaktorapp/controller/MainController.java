package reaktor.reaktorapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import reaktor.reaktorapp.model.entity.Contact;
import reaktor.reaktorapp.model.entity.User;
import reaktor.reaktorapp.model.form.RegisterUserForm;
import reaktor.reaktorapp.service.AutoMailingService;
import reaktor.reaktorapp.service.ContactService;
import reaktor.reaktorapp.service.UserService;

import javax.validation.Valid;

@Controller
public class MainController {
    UserService userService;
    ContactService contactService;
    AutoMailingService autoMailingService;


    @Autowired
    public MainController(UserService userService, ContactService contactService, AutoMailingService autoMailingService) {
        this.userService = userService;
        this.contactService = contactService;
        this.autoMailingService = autoMailingService;
    }

    @GetMapping("/")
    public String home (Model model, Authentication auth){
        if(auth != null){
            UserDetails principal = (UserDetails) auth.getPrincipal();
            model.addAttribute("principal", principal);
        }
        return "homepage";
    }

    @GetMapping("/login")
    public String login(Model model, Authentication auth){
        return "loginPage";
    }


    @GetMapping("/register")
    public String register(Model model, Authentication auth){
        RegisterUserForm user = new RegisterUserForm();
        model.addAttribute("registerUserForm", user);
        if(auth != null){
            UserDetails principal = (UserDetails) auth.getPrincipal();
            model.addAttribute("principal", principal);
        }
                return "registerPage";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute @Valid RegisterUserForm registerUserForm,
                           BindingResult bindingResult,
                           Authentication auth,
                           Model model){
        if (bindingResult.hasErrors()){
            return "registerPage";
        }
        System.out.println(registerUserForm.toString());
        User user = userService.createUser(registerUserForm);
        if(auth != null){
            UserDetails principal = (UserDetails) auth.getPrincipal();
            model.addAttribute("principal", principal);
        }

        return "redirect:/";
    }


    @GetMapping("/contact")
    public String contact(Model model, Authentication auth){
            model.addAttribute("contact", new Contact());
        return "contactPage";
    }

    @PostMapping("/contact")
    public String contact(@ModelAttribute @Valid Contact contact, BindingResult bindingResult, Model model){

        String info="";
        if (bindingResult.hasErrors()){
            info = "Występują błędy formularza";
            model.addAttribute("info",info );
            return "contactPage";
        }
        // zapis do DB poprzez ContactService
        contactService.createContact(contact);

        //auto-email
//        autoMailingService.sendSimpleMessage(contact.getEmail(), "Potwierdzenie wysłania formularza","Dzjękujemy za kontakt. Niezwłocznie się do Ciebie odezwiemy" );

        contact.setSubject("");
        contact.setEmail("");
        contact.setMessage("");
        info = "Wysłano wiadomość";
        model.addAttribute("info",info);
        return "contactPage";
    }
    @GetMapping("/addEditionPage")
    public String addEditionPage(Model model, Authentication auth){
        return "addEditionPage";
    }

    @GetMapping("/studentsListPage")
    public String studentsListPage(Model model, Authentication auth){
        return "studentsListPage";
    }
    @GetMapping("/userProfile")
    public String userProfile(Model model, Authentication auth){
        return "userProfile";
    }



}

