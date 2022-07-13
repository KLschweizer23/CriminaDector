package com.criminaldetector.criminadector;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AppController {
    
    @GetMapping("")
    public ModelAndView homePage(Model model){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index.html");
        
        model.addAttribute("title", "CriminaDector | Home");

        return mv;
    }

    @GetMapping("/dashboard")
    public ModelAndView dashPage(Model model){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("dashboard.html");
        
        model.addAttribute("title", "CriminaDector | Dashboard");

        return mv;
    }

    @GetMapping("/profile")
    public ModelAndView profilePage(Model model){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("profile.html");
        
        model.addAttribute("title", "CriminaDector | Profile");

        return mv;
    }
}
