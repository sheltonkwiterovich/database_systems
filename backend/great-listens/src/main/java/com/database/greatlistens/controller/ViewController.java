package com.database.greatlistens.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String mainPage() {
        
        return "main_page";
    }

    @GetMapping("/login1")
    public String loginPage() {
        
        return "login";
    }

   

    @GetMapping("/user")
    public String userPage() {
        
        return "user";
    }

    @GetMapping("/dashboard2")
    public String dashPage() {
        
        return "dashboard2";
    }

    @GetMapping("/rate")
    public String ratePage() {
        
        return "rate";
    }
    
    @GetMapping("/cart")
    public String cartPage() {
        
        return "cart";
    }
    
    
}
