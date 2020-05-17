package com.spring.proverbApp.controller;

import com.spring.proverbApp.entity.ProverbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

public class registrationController {
    @Autowired
    private UserDetailsManager userDetailsManager;

    private PasswordEncoder passwordEncoder= new BCryptPasswordEncoder();

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);

    }
    @GetMapping("/showRegisterProverbUser")
    public String showRegisterProverbUser(Model model){

        model.addAttribute("proverbUser", new ProverbUser());

        return "registerProverbUser";

    }
    @PostMapping("/saveProverbUser")
    public String saveProverbUser(@Valid @ModelAttribute("proverbUser") ProverbUser proverbUser,
                                  BindingResult bindingResult,
                                  Model model){
        String userName= proverbUser.getUsername();
        String passWord= proverbUser.getPassword();
        String firstName=proverbUser.getFirstName();
        String lastName= proverbUser.getLastName();
        String email = proverbUser.getEmail();

        if(bindingResult.hasErrors()){
            model.addAttribute("proverbUser", new ProverbUser());

            return "registerProverbUser";
        }
        boolean userExists = doesUserExist(userName);

        if(userExists){
            model.addAttribute("proverbUser", new ProverbUser());
            model.addAttribute("registrationError","username already exists");
            return "registerProverbUser";
        }else{
            String encodedPassword = passwordEncoder.encode(passWord);
            encodedPassword = "{bcrypt}"+encodedPassword;
            List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_EMPLOYEE");
            User tempUser = new User(userName,encodedPassword,authorities);
            userDetailsManager.createUser(tempUser);
            return "userRegistered";
        }


    }

    private boolean doesUserExist(String userName) {
        boolean exists = userDetailsManager.userExists(userName);

        return exists;
    }
}
