package com.criminaldetector.criminadector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.criminaldetector.criminadector.repositories.CriminalRepository;
import com.criminaldetector.criminadector.objects.person.Criminal;

@RestController
public class AppController {
    
    @Autowired
    CriminalRepository criminalRepository;

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

    @GetMapping("/profile/{id}")
    public ModelAndView profilePage(Model model){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("profile.html"); 
        
        Criminal currentCriminal = criminalRepository.findById(1L).get();

        System.out.println(currentCriminal.getName());

        model.addAttribute("title", "CriminaDector | Profile");
        model.addAttribute("criminal", currentCriminal);

        return mv;
    }
}
