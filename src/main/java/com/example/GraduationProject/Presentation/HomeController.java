package com.example.GraduationProject.Presentation;

import com.example.GraduationProject.Business.BeaHandService;
import com.example.GraduationProject.Business.Entity.Donor;
import com.example.GraduationProject.Business.Entity.FoodItem;
import com.example.GraduationProject.Business.Entity.Taker;
import com.example.GraduationProject.Business.Entity.Volunteers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class HomeController
{

    @Autowired
    BeaHandService service;

    @GetMapping("/")
    public String home()
    {
        return "home";
    }

    @GetMapping("taker")
    public String takerGet(Model model)
    {
        model.addAttribute("taker", new Taker());
        return "taker";
    }

    @PostMapping("/taker")
    public String takerPost(@Valid @ModelAttribute Taker taker, BindingResult bindingresult, Model model)
    {
        if(bindingresult.hasErrors())
            return "taker";

        service.addTaker(taker);
        return "home";
    }

    @GetMapping("foodItem")
    public String foodItemGet(Model model)
    {
        model.addAttribute("foodItem", new FoodItem());
        return "foodItem";
    }

    @PostMapping("/foodItem")
    public String foodItemPost(@Valid @ModelAttribute FoodItem foodItem, BindingResult bindingresult, Model model)
    {
        if(bindingresult.hasErrors())
            return "foodItem";

        service.addFoodItem(foodItem);
        return "home";
    }

    @GetMapping("volunteers")
    public String volunteersGet(Model model)
    {
        model.addAttribute("volunteers", new Volunteers());
        return "volunteers";
    }

    @PostMapping("/volunteers")
    public String volunteersPost(@Valid @ModelAttribute Volunteers volunteers, BindingResult bindingresult, Model model)
    {
        if(bindingresult.hasErrors())
            return "volunteers";

        service.addVolunteers(volunteers);
        return "home";
    }


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

        service.addDonor(donor);
        return "home";
    }
}
