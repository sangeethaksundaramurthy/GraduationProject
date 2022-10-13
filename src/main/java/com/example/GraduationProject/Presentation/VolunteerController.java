package com.example.GraduationProject.Presentation;

import com.example.GraduationProject.Business.Entity.Food;
import com.example.GraduationProject.Business.Entity.Volunteer;
import com.example.GraduationProject.Business.VolunteersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Controller
public class VolunteerController
{
    @Autowired
    VolunteersService service;

    @GetMapping("volunteer")
    public ModelAndView volunteerGet()
    {
        ModelAndView mav = new ModelAndView();
        mav.addObject("volunteer", new Volunteer());
        mav.setViewName("volunteer");
        return mav;
    }

    @PostMapping("/addVolunteer")
    public ModelAndView addVolunteer(@Valid @ModelAttribute Volunteer volunteer, BindingResult bindingresult)
    {
        ModelAndView mav = new ModelAndView();
        if(bindingresult.hasErrors())
        {
            mav.setViewName("redirect:/volunteer");
        }
        else
        {
            if(Objects.equals(service.save(volunteer), "Success"))
                mav.setViewName("volunteerSignedIn");
            else
            {
                System.out.println("EmailId already exists:-(");
                mav.setViewName("redirect:/volunteer");
            }
        }
        return mav;
    }
    @PostMapping("/volunteerSI")
    public ModelAndView VolunteerSI(@RequestParam String emailId, @RequestParam String password)
    {
        ModelAndView mav = new ModelAndView();
        Volunteer volunteer = service.authenticate(emailId, password);
        if(volunteer == null)
        {
            mav.setViewName("redirect:/volunteer");
        }
        else
        {
            mav.addObject("volunteer", volunteer);
            mav.setViewName("volunteerSignedIn");
        }
            return mav;
    }

    @RequestMapping("/pickup")
    public ModelAndView pickup()
    {
        ModelAndView mav = new ModelAndView();
        List<Food> foods = service.acceptedFoodList();
        mav.addObject("foods", foods);
        mav.setViewName("viewPickup");
        return mav;
    }

    @GetMapping("/pickup/{id}")
    public ModelAndView pickup(@PathVariable Integer id)
    {
        ModelAndView mav = new ModelAndView();
        service.acceptPickup(id);
        mav.setViewName("redirect:/pickup");
        return mav;
    }

    @RequestMapping("/historyV")
    public ModelAndView history()
    {
        ModelAndView mav = new ModelAndView();
        List<Food> foods = service.volunteerHistory();
        mav.addObject("foods",foods);
        System.out.println(foods.toString());
        mav.setViewName("volunteerHistory");
        return mav;
    }

    @GetMapping("/delivered/{id}")
    public ModelAndView delivered(@PathVariable Integer id)
    {
        ModelAndView mav = new ModelAndView();
        service.delivered(id);
        mav.setViewName("viewPickup");
        return mav;
    }

    @GetMapping("/goToVolunteer")
    public ModelAndView goToVolunteer(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("volunteer", service.getVolunteer());
        mav.setViewName("volunteerSignedIn");
        return mav;
    }

}
