package org.example.xxljob;

import org.springframework.context.annotation.Bean;

public class XxlJobConfig {


    @Bean
    public XxlJobSpringExecutor xxlJobExecutor() {
        System.out.println(">>>>>>>>>>> xxl-job config init.");
        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
        xxlJobSpringExecutor.setAdminAddresses("http://127.0.0.1:8080/xxl-job-admin"); // 调度中心地址
        xxlJobSpringExecutor.setAppname("xxl-job-executor-sample"); // 执行器名称
        xxlJobSpringExecutor.setIp(null); // 执行器IP
        xxlJobSpringExecutor.setPort(9999); // 执行器端口
        xxlJobSpringExecutor.setAccessToken(null); // 执行器通讯令牌
        xxlJobSpringExecutor.setLogPath("/data/applogs/xxl-job/jobhandler"); // 日志路径
        xxlJobSpringExecutor.setLogRetentionDays(30); // 日志保留天数
        return xxlJobSpringExecutor;
    }
}
