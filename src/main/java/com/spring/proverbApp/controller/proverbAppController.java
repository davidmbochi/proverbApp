package com.spring.proverbApp.controller;

import com.spring.proverbApp.entity.Proverbs;
import com.spring.proverbApp.service.proverbAppService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class proverbAppController {

    @Autowired
    private proverbAppService proverbAppService;

    @RequestMapping("/")
    public String showHomePage(){
        return "homepage";
    }
    @RequestMapping("/showProverbForm")
    public String showProverbForm(){
        return "proverbForm";
    }

    @RequestMapping(path = "/saveProverb",method = RequestMethod.POST)
    public void saveProverb(@Valid @ModelAttribute("proverbs") Proverbs theProverb){

    }
}
