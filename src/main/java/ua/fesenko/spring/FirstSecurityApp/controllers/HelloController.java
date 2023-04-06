package ua.fesenko.spring.FirstSecurityApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ua.fesenko.spring.FirstSecurityApp.security.PersonDetails;
import ua.fesenko.spring.FirstSecurityApp.servicies.AdminService;

@Controller
public class HelloController {
    private final AdminService adminService;

    @Autowired
    public HelloController(AdminService adminService) {
        this.adminService = adminService;
    }

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
    @GetMapping("/admin")
    public String adminPage() {
        adminService.doAdmin();
        return "admin";
    }
}
