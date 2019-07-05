package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${value}")
    private String value;


    @GetMapping("/getValue")
    public String getValue(){

        return value;
    }

}
