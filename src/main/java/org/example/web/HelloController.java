package org.example.web;

import org.example.services.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @Autowired
    private SampleService sampleService;

    @GetMapping("/hello")
    public String hello() {
        return "hello-spring";
    }
}
