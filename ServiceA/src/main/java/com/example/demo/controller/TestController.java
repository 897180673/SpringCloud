package com.example.demo.controller;

import com.example.demo.feign.MyFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class TestController {
    @Resource
    private MyFeignClient myFeignClient;

    @GetMapping("/hello")
    public String sayHello(){
        return "hello";
    }

    @GetMapping("/feignTest")
    public String getFeignResult(){
        log.info("get request  in /feignTest ");
        String result=null;
        try {
            result= myFeignClient.getFeignResult();
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return  result;
    }
}
