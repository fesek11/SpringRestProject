package ua.fesenko.spring.FirstSecurityApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.fesenko.spring.FirstSecurityApp.models.Person;
import ua.fesenko.spring.FirstSecurityApp.servicies.RegistrationService;
import ua.fesenko.spring.FirstSecurityApp.util.PersonValidator;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private final PersonValidator personValidator;
    private final RegistrationService registrationService;

    @Autowired
    public AuthController(PersonValidator personValidator, RegistrationService registrationService) {
        this.personValidator = personValidator;
        this.registrationService = registrationService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "/auth/login";
    }
    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("person") Person person) {
        return "/auth/registration";
    }

    @PostMapping("/registration")
    public String doRegistration(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        personValidator.validate(person, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/auth/registration";
        }
        registrationService.register(person);
        return "redirect:/auth/login";
    }


}
