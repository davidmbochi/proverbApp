package com.spring.proverbApp.controller;

import com.spring.proverbApp.entity.Proverbs;
import com.spring.proverbApp.service.proverbAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class proverbAppController {

    @Autowired
    private proverbAppService proverbAppService;

    @PostMapping("/saveProverb")
    public void saveProverb(Proverbs theProverb){

    }
}
