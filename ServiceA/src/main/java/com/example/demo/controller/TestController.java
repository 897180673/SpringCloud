package com.example.demo.controller;

import brave.sampler.Sampler;
import com.example.demo.feign.MyFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
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
        log.info("get request  in /feignTest");
        String result=null;
        try {
            result= myFeignClient.getFeignResult();
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return  result;
    }

    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }

    @Bean(name = "hystrixRegistrationBean")
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean registration = new ServletRegistrationBean(
                new HystrixMetricsStreamServlet(), "/hystrix.stream");
        registration.setName("hystrixServlet");
        registration.setLoadOnStartup(1);
        return registration;
    }

}
