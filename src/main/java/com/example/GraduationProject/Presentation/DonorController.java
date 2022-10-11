package com.example.GraduationProject.Presentation;

import com.example.GraduationProject.Business.DonorService;
import com.example.GraduationProject.Business.Entity.Donor;
import com.example.GraduationProject.Business.Entity.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Controller
public class DonorController
{
    @Autowired
    DonorService service;

    @GetMapping("/donor")
    public ModelAndView donor()
    {
        ModelAndView mav = new ModelAndView();
        mav.addObject("donor", new Donor());
        mav.setViewName("donor");
        return mav;
    }

    @PostMapping("/addDonor")
    public ModelAndView addNewDonor(@Valid @ModelAttribute Donor donor, BindingResult bindingresult)
    {
        ModelAndView mav = new ModelAndView();
        if(bindingresult.hasErrors())
        {
            mav.setViewName("redirect:/donor");
        }
        else
        {
            if(Objects.equals(service.save(donor), "Success"))
                mav.setViewName("donorSignedIn");
            else
            {
                System.out.println("EmailId already exists:-(");
                mav.setViewName("redirect:/donor");
            }
        }
        return mav;
    }
    @PostMapping("/DonorSI")
    public ModelAndView signInDonor(@RequestParam String emailId, @RequestParam String password)
    {
        ModelAndView mav = new ModelAndView();
        Donor donor = service.authenticate(emailId,password);
        if(donor == null)
        {
            mav.setViewName("redirect:/donor");
        }
        else
        {
            mav.addObject("donor", donor);
            mav.setViewName("donorSignedIn");
        }
        return  mav;
    }

    @RequestMapping("/food")
    public ModelAndView food_donate()
    {
        ModelAndView mav = new ModelAndView();
        mav.addObject("food", new Food());
        mav.setViewName("food");
        return mav;
    }

    @PostMapping(value = "/food", params = "submit")
    public ModelAndView donateFood_recentDonations(@Valid @ModelAttribute Food food, BindingResult bindingresult)
    {
        ModelAndView mav = new ModelAndView();
        if(bindingresult.hasErrors())
        {
            mav.setViewName("redirect:/food");
        }
        else
        {
            service.save(food);
            mav.setViewName("delivery");
        }
        return mav;
    }

    @GetMapping("/delivery")
    public ModelAndView delivery(@RequestParam("pickUp") String pickUp)
    {
        ModelAndView mav = new ModelAndView();
        service.setPickUpRequired(pickUp);
        mav.addObject("donor", service.getDonor());
        mav.setViewName("donorSignedIn");
        return mav;
    }

    @RequestMapping("/history")
    public ModelAndView history()
    {
        ModelAndView mav = new ModelAndView();
        List<Food> foods = service.donationHistory();
        mav.addObject("foods",foods);
        mav.setViewName("donationHistory");
        return mav;
    }
}
