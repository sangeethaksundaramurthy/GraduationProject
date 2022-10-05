package com.example.GraduationProject.Presentation;

import com.example.GraduationProject.Business.BeaHandService;
import com.example.GraduationProject.Business.Entity.Taker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController
{

    @Autowired
    BeaHandService service;

    @GetMapping("/") public String home()
    {
        return "home";
    }

    @GetMapping("taker") public String takerGet(Model model)
    {
        model.addAttribute("taker", new Taker());
        return "taker";
    }

    @PostMapping("/taker") public void takerPost(@ModelAttribute Taker taker, Model model)
    {
        service.addTaker(taker);
    }
}
