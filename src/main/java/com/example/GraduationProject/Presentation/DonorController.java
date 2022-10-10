package com.example.GraduationProject.Presentation;

import com.example.GraduationProject.Business.DonorService;
import com.example.GraduationProject.Business.Entity.Donor;
import com.example.GraduationProject.Business.Entity.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Objects;

@Controller
public class DonorController
{

    @Autowired
    DonorService service;

    @GetMapping("donor")
    public ModelAndView donor()
    {
        ModelAndView mav = new ModelAndView();
        mav.addObject("donor", new Donor());
        mav.setViewName("donor");
        return mav;
    }

    @PostMapping(value= "/addNewDonor")
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
                mav.setViewName("home");
            else
            {
                mav.setViewName("redirect:/donor");
            }
        }
        return mav;
    }
    @PostMapping("/signInDonor")
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

    @GetMapping(value = "/donateFood", params = "makeADonation")
    public ModelAndView donateFood_makeADonation()
    {
        ModelAndView mav = new ModelAndView();
        mav.addObject("food", new Food());
        mav.setViewName("donateFood");
        return mav;
    }

    @GetMapping(value = "/donateFood", params = "recentDonations")
    public ModelAndView donateFood_recentDonations()
    {
        ModelAndView mav = new ModelAndView();

        return mav;
    }
}
