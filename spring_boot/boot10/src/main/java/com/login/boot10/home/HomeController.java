package com.login.boot10.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "redirect:/items";
    }
    
}
