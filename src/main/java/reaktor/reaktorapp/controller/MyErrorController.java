package reaktor.reaktorapp.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyErrorController implements ErrorController {

    @GetMapping("/error")
    public String errorLogging(){
        // operacje dla error
        return "errorLogin";
    }

    @GetMapping("/errorPage")
    public String errorLoginLogging(){
        return "errorLoginPage";
    }

    @Override
    public String getErrorPath(){
        return "/error";
    }
}
