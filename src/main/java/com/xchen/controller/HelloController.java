package com.xchen.controller;

import com.xchen.entity.Student;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Trace
    @RequestMapping("/hello")
    public String testTraceId(){
        return "Hello World!";
    }
}
