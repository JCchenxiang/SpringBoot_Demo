package com.xchen.service;

import org.apache.skywalking.apm.toolkit.trace.ActiveSpan;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Trace
    public String testTrace() {
        String traceId = TraceContext.traceId();
        ActiveSpan.tag("traceId", TraceContext.traceId());
        int sum = 5/0;
        return "I am Service！";
    }

}
