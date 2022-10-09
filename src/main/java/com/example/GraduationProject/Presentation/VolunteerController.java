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

    @GetMapping("volunteer")
    public String volunteerGet(Model model)
    {
        model.addAttribute("volunteer", new Volunteer());
        return "volunteer";
    }

    @PostMapping("/volunteer")
    public String volunteerPost(@Valid @ModelAttribute Volunteer volunteer, BindingResult bindingresult, Model model)
    {
        if(bindingresult.hasErrors())
            return "volunteer";
        else
        {
            service.save(volunteer);
            return "home";
        }

    }
    @PostMapping("/signInVolunteer")
    public String signInVolunteer(@RequestParam String emailId, @RequestParam String password)
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
