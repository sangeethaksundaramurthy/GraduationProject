package com.example.GraduationProject.Presentation;

import com.example.GraduationProject.Business.DonorService;
import com.example.GraduationProject.Business.Entity.Donor;
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
public class DonorController
{

    @Autowired
    DonorService service;

    @GetMapping("donor")
    public String donorGet(Model model)
    {
        model.addAttribute("donor", new Donor());
        return "donor";
    }

    @PostMapping("/donor")
    public String donorPost(@Valid @ModelAttribute Donor donor, BindingResult bindingresult, Model model)
    {
        if(bindingresult.hasErrors())
            return "donor";

        service.save(donor);
        return "home";
    }
    @PostMapping("/signInDonor")
    public String loginPost(@RequestParam String emailId, @RequestParam String password)
    {
        Donor donor = service.authenticate(emailId,password);
        if(donor == null)
        {
            System.out.println("redirect");
            return "redirect:/taker";
        }
        else
            return "home";
    }

}
