package com.database.greatlistens.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class TestController {
	
	@GetMapping("/")
    @ResponseBody
    public String sayHello() {
        return "Hello";
    }
}


