package org.example.xxljob;

public class MyJobHandler {
    @XxlJob("demoJobHandler")
    public void execute() throws Exception {
        XxlJobFileAppender.appendLog("text.txt","XXL-JOB, Hello World.");
        System.out.println("XXL-JOB, Hello World.");
    }
}
