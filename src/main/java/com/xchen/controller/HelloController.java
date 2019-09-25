package com.xchen.controller;


import com.xchen.service.TestService;
import org.apache.log4j.Logger;
import org.apache.skywalking.apm.toolkit.trace.ActiveSpan;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloController {

    @Autowired
    private TestService testService;

    private static Logger logger = Logger.getLogger(HelloController.class);


    @RequestMapping("/index")
    public String hello(String username, String password, Model model) {
        return "index";
    }


    @RequestMapping("/test")
    @ResponseBody
    @Trace
    public String testTraceId(Model model) {
        model.addAttribute("traceId", TraceContext.traceId());
        ActiveSpan.tag("traceId", TraceContext.traceId());
        //logger.info("traceId3:" + TraceContext.traceId());
        return testService.testTrace();
    }

    @RequestMapping("/login")
    public String login() {
        logger.info("traceId-test" + TraceContext.traceId());
        return "login";
    }
}
