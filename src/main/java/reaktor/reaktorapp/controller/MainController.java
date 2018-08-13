package reaktor.reaktorapp.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import reaktor.reaktorapp.model.entity.Contact;
import reaktor.reaktorapp.service.AutoMailingService;
import reaktor.reaktorapp.service.ContactService;

import javax.validation.Valid;

@Controller
public class MainController {

    ContactService contactService;
    AutoMailingService autoMailingService;

    @GetMapping("/")
    public String home (Model model, Authentication auth){
        return "homepage";
    }

    @GetMapping("/logowanie")
    public String login(Model model, Authentication auth){
        return "loginPage";
    }

    @GetMapping("/contact")
    public String contact(Model model, Authentication auth){
        return "contactPage";
    }

    @GetMapping("/register")
    public String register(Model model, Authentication auth){
        return "registerPage";
    }

    @PostMapping("/contact")
    public String contact(@ModelAttribute @Valid Contact contact, BindingResult bindingResult, Model model){

        String info="";
        if (bindingResult.hasErrors()){
            info = "Występują błędy formularza";
            model.addAttribute("info",info );
            return "contactForm";
        }
        // zapis do DB poprzez ContactService
        contactService.createContact(contact);

        //auto-email
        autoMailingService.sendSimpleMessage(contact.getEmail(), "Potwierdzenie wysłania formularza","Dzjękujemy za kontakt. Niezwłocznie się do Ciebie odezwiemy" );

        contact.setSubject("");
        contact.setEmail("");
        contact.setMessage("");
        info = "Wysłano wiadomość";
        model.addAttribute("info",info );
        return "contactForm";
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