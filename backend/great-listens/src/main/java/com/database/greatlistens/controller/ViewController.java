package com.database.greatlistens.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String mainPage() {
        
        return "main_page";
    }

    @GetMapping("/login")
    public String loginPage() {
        
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboardPage() {
        
        return "dashboard";
    }

    
}
