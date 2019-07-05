package com.example.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "service-clientB")
public interface MyFeignClient {
    @GetMapping("/hello2")
    String getFeignresult()throws Exception;
}
