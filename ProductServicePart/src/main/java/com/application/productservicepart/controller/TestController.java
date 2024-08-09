package com.application.productservicepart.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {
    int i =0;
    @GetMapping
    public String test() {
        System.out.println("ok");
        System.out.println(i++);
        return "Hello World";
    }
}
