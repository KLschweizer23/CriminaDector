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
        
        model.addAttribute("title", "Home");

        return mv;
    }

}
