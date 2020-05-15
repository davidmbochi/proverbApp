package com.spring.proverbApp.controller;

import com.spring.proverbApp.entity.Proverbs;
import com.spring.proverbApp.service.proverbAppService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class proverbAppController {

    @Autowired
    private proverbAppService proverbAppService;

    @GetMapping("/proverbForm")
    public String showProverbForm(Model model){
        Proverbs proverbs = new Proverbs();

        model.addAttribute("theproverb",proverbs);

        return "proverbForm";
    }

    @PostMapping("/saveProverb")
    public String saveProverb(@Valid @ModelAttribute("theproverb") Proverbs proverbs, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "proverbForm";
        }else {

            proverbAppService.saveProverb(proverbs);

            return "redirect:/";
        }
    }
    @GetMapping("/")
    public String listProverbs(Model model){
        List<Proverbs> theProverbs= proverbAppService.getProverbs();

        model.addAttribute("customers",theProverbs);

        return "listProverbs";
    }
    @GetMapping("/updateProverb")
    public String updateProverb(@RequestParam("proverbId") int theId, Model model){
        Proverbs proverbs= proverbAppService.updateProverb(theId);
        model.addAttribute("theproverb",proverbs);
        return "proverbForm";
    }
    @GetMapping("/deleteProverb")
    public String deleteProverb(@RequestParam("proverbId") int theId){
        proverbAppService.deleteProverb(theId);

        return "redirect:/";
    }
}
