package reaktor.reaktorapp.controller;

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
    public String home (){
        return "homepage";
    }

    @GetMapping("/logowanie")
    public String login(){
        return "loginPage";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contactPage";
    }

    @GetMapping("/register")
    public String register(){
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
    public String add(){
        return "addEditionPage";
    }
    @GetMapping("/register")
    public String editStudentsA(){
        return "editStudentsPage";
    }
    @GetMapping("/studentsListPage")
    public String studentsListPage(){
        return "studentsListPage";
    }
    @GetMapping("/userProfile")
    public String userProfile(){
        return "userProfile";
    }


}
