package com.janwee.resource.service.impl;

import com.janwee.resource.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloServiceImpl implements HelloService {
    @GetMapping
    public String sayHello() {
        return "Hello!";
    }
}
