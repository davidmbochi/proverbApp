package com.spring.proverbApp.controller;

import com.spring.proverbApp.entity.Proverbs;
import com.spring.proverbApp.service.proverbAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class proverbAppController {

    @Autowired
    private proverbAppService proverbAppService;

    @GetMapping("/")
    public String showHomePage(){
        return "homepage";
    }
    @GetMapping("/showProverbForm")
    public String showProverbForm(){
        return "proverbForm";
    }

    @PostMapping("/saveProverb")
    public String saveProverb(@ModelAttribute("theproverb") Proverbs proverbs){

        proverbAppService.saveProverb(proverbs);

        return "redirect:/showProverbForm";
    }
}
