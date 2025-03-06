package com.techtest.testfe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
    
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("/index");

        return view;
    }
    
}
