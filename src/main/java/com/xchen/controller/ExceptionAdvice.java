package com.xchen.controller;

import org.apache.log4j.Logger;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionAdvice {
    private static Logger logger = Logger.getLogger(HelloController.class);

    @ExceptionHandler
    public ModelAndView excepetion(Exception e){
        ModelAndView mv = new ModelAndView();
        mv.addObject("exception",e);
        mv.addObject("traceId", TraceContext.traceId());
        logger.error("发生异常：",e);
        mv.setViewName("error");
        return  mv;
    }

}
