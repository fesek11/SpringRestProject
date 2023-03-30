package ua.fesenko.spring.FirstSecurityApp.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ua.fesenko.spring.FirstSecurityApp.security.PersonDetails;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "hello";
    }

    @GetMapping("/showUserInfo")
    public String showUserInfo() {
        Authentication a = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) a.getPrincipal();
        System.out.println(personDetails.getPerson());
        return "hello";
    }
}
