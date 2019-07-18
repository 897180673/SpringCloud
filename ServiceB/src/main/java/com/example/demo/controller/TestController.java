package com.example.demo.controller;

import brave.sampler.Sampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/hello2")
    public String sayHello2(){
        return "hello2";
    }

    @GetMapping("/hello")
    public String sayHello(){
        return "hello service-clientB";
    }

    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }
}
