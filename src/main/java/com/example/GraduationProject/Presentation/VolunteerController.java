package com.example.GraduationProject.Presentation;

import com.example.GraduationProject.Business.Entity.Volunteer;
import com.example.GraduationProject.Business.VolunteersService;
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
public class VolunteerController
{
    @Autowired
    VolunteersService service;

    @GetMapping("volunteers")
    public String volunteersGet(Model model)
    {
        model.addAttribute("volunteers", new Volunteer());
        return "volunteers";
    }

    @PostMapping("/volunteer")
    public String volunteersPost(@Valid @ModelAttribute Volunteer volunteer, BindingResult bindingresult, Model model)
    {
        if(bindingresult.hasErrors())
            return "volunteer";

        service.save(volunteer);
        return "home";
    }
    @PostMapping("/signInVolunteer")
    public String loginPost(@RequestParam String emailId, @RequestParam String password)
    {
        Volunteer volunteer = service.authenticate(emailId, password);
        if(volunteer == null)
        {
            System.out.println("redirect");
            return "redirect:/volunteer";
        }
        else
            return "home";
    }
}
