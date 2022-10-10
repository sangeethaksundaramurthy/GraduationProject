package com.example.GraduationProject.Presentation;

import com.example.GraduationProject.Business.Entity.Taker;
import com.example.GraduationProject.Business.TakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class TakerController
{
    @Autowired
    TakerService service;

    @GetMapping("taker")
    public String takerGet(Model model)
    {
        model.addAttribute("taker", new Taker());
        return "taker";
    }

    @PostMapping("/addNewTaker")
    public String takerPost(@Valid @ModelAttribute Taker taker, BindingResult bindingresult, Model model)
    {
        if(bindingresult.hasErrors())
            return "/taker";
        else
        {
            service.save(taker);
            return "home";
        }
    }
    @PostMapping("/signInTaker")
    public String signInTaker(@RequestParam String emailId, @RequestParam String password, Model model)
    {
        Taker taker = service.authenticate(emailId,password);
        if(taker == null)
        {
            System.out.println("redirect");
            return "redirect:/taker";
        }
        else
        {
            model.addAttribute("taker", taker);
            return "takerSignedIn";
        }
    }
}
