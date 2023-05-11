package com.api.demorestapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class Controller {

    @GetMapping("/greet")
    public static  String greet(){
        return "Hello Hi , from greeting from rest-api services...";
    }
}
