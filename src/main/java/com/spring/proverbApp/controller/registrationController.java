package com.spring.proverbApp.controller;

import com.spring.proverbApp.entity.ProverbUser;
import com.spring.proverbApp.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
@Controller
public class registrationController {



    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);

    }

    @GetMapping("/showRegisterProverbUser")
    public String showRegisterProverbUser(Model model) {

        model.addAttribute("proverbUser", new ProverbUser());

        return "registerProverbUser";

    }

    @PostMapping("/saveProverbUser")
    public String saveProverbUser(@Valid @ModelAttribute("proverbUser") ProverbUser proverbUser,
                                  BindingResult bindingResult,
                                  Model model) {


    }





}
