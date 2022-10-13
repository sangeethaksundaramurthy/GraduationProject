package com.example.GraduationProject.Presentation;

import com.example.GraduationProject.Business.DonorService;
import com.example.GraduationProject.Business.Entity.Food;
import com.example.GraduationProject.Business.Entity.Taker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class HomeController
{


   /* @RequestMapping("/")
    public String home()
    {
        return "home";
    }*/

    @GetMapping("/donateFood")
    public String donateFoodGet(Model model)
    {
        model.addAttribute("food",new Food());
        return "donateFood";
    }

    @PostMapping("/donateFood")
    public String donateFoodPost(@Valid @ModelAttribute Food food, BindingResult bindingresult, Model model)
    {
        if(bindingresult.hasErrors())
            return "dummy";
        else
        {
            return "home";
        }
    }
    @GetMapping(value ="/donor", params = "logout")
    public String donor_logout()
    {
        return "home";
    }


}


