package com.example.springbootlearn.xxlJob;

import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobFileAppender;
import org.springframework.stereotype.Component;

@Component
public class MyJobHandler {

    @XxlJob("demoJobHandler")
    public void execute() throws Exception {
        XxlJobFileAppender.appendLog("text.txt","XXL-JOB, Hello World.");
        System.out.println("XXL-JOB, Hello World.");
    }
}
