package com.example.GraduationProject.Presentation;

import com.example.GraduationProject.Business.Entity.Food;
import com.example.GraduationProject.Business.Entity.Taker;
import com.example.GraduationProject.Business.TakerService;
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

    @PostMapping("/addTaker")
    public ModelAndView takerPost(@Valid @ModelAttribute Taker taker, BindingResult bindingresult)
    {
        ModelAndView mav = new ModelAndView();
        if(bindingresult.hasErrors())
            mav.setViewName("taker");
        else
        {
            if(Objects.equals(service.save(taker), "Success"))
                mav.setViewName("takerSignedIn");
            else
            {
                System.out.println("EmailId already exists:-(");
                mav.setViewName("redirect:/taker");
            }
        }
        return mav;
    }
    @PostMapping("/TakerSI")
    public ModelAndView signInTaker(@RequestParam String emailId, @RequestParam String password)
    {
        ModelAndView mav = new ModelAndView();
        Taker taker = service.authenticate(emailId,password);
        if(taker == null)
        {
            mav.setViewName("redirect:/taker");
        }
        else
        {
            mav.addObject("taker", taker);
            mav.setViewName("takerSignedIn");
        }
        return mav;
    }

    @RequestMapping("/viewD")
    public ModelAndView viewDonations()
    {
        ModelAndView mav = new ModelAndView();
        List<Food> foods = service.viewDonations();
        mav.addObject("foods", foods);
        mav.setViewName("viewDonations");
        return mav;
    }

    @GetMapping("/accept/{id}")
    public ModelAndView acceptFood(@PathVariable Integer id)
    {
        ModelAndView mav = new ModelAndView();
        service.acceptFood(id);
        mav.setViewName("redirect:/viewD");
        return mav;
    }

    @RequestMapping("/historyT")
    public ModelAndView history()
    {
        ModelAndView mav = new ModelAndView();
        List<Food> foods = service.takerHistory();
        mav.addObject("foods",foods);
        mav.setViewName("takerHistory");
        return mav;
    }

    @GetMapping("/goToTaker")
    public ModelAndView goToTaker(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("taker", service.getTaker());
        mav.setViewName("takerSignedIn");
        return mav;
    }
}
