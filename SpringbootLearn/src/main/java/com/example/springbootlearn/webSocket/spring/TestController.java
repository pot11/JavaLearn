package com.example.springbootlearn.webSocket.spring;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TestController {
    @GetMapping("/test")
    public String test() {
        return "IPv6测试服务 - 连接成功! 时间: " + new java.util.Date();
    }

    @GetMapping("/info")
    public String info(@RequestHeader(value = "User-Agent", required = false) String userAgent) {
        return String.format(
                "连接信息:\n" +
                        "- 服务状态: 运行中\n" +
                        "- 时间: %s\n" +
                        "- 客户端: %s\n" +
                        "- 消息: IPv6连接测试成功!",
                new java.util.Date(),
                userAgent != null ? userAgent : "未知"
        );
    }

    @GetMapping("/echo/{message}")
    public String echo(@PathVariable String message) {
        return "回声: " + message + " (接收时间: " + new java.util.Date() + ")";
    }

    @PostMapping("/chat")
    public String chat(@RequestBody String message) {
        return "服务器回复: 收到您的消息 - '" + message + "'";
    }

}
