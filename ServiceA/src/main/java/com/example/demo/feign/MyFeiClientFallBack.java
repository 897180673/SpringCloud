package com.example.demo.feign;

import org.springframework.stereotype.Component;

@Component
public class MyFeiClientFallBack implements MyFeignClient {
    @Override
    public String getFeignResult()  {

        return "sorry the application is down or the network is not good";
    }
}
