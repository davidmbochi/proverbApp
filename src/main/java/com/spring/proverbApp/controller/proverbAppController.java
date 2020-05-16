package com.spring.proverbApp.controller;

import com.spring.proverbApp.entity.Proverbs;
import com.spring.proverbApp.service.proverbAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
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
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
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
