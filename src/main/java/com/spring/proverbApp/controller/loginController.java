package com.spring.proverbApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginController {
    @GetMapping("/showLoginForm")
    public String showLoginForm(){
        return "proverbLogin";
    }
    @GetMapping("/access-denied")
    public String accessDenied(){
        return "access-denied";
    }
}
