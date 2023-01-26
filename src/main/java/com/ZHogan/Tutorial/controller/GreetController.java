package com.ZHogan.Tutorial.controller;

import com.ZHogan.Tutorial.model.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GreetController {
    @GetMapping("/greeting")
    public String greetForm(Model model){
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit (@ModelAttribute Greeting greeting, Model model){
        model.addAttribute("greeting", greeting);
        return "result";
    }
}
