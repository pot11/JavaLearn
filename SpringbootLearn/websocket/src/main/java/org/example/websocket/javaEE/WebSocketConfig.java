//package com.example.springbootlearn.webSocket.javaEE;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
//import org.springframework.web.socket.server.standard.ServerEndpointExporter;
//
//@Configuration
//public class WebSocketConfig {
//
//    /**
//     * 注册 @ServerEndpoint 注解的端点（springboot环境下）
//     * 将 Java EE 标准的 @ServerEndpoint 注解类注册到 Spring 的 WebSocket 运行时环境中，使得标准的 Java EE WebSocket 端点能够在 Spring Boot 应用中正常工作。
//     * 问题背景：
//     * Java EE WebSocket：使用 @ServerEndpoint 注解，是 Java EE 标准
//     * Spring Boot：有自己的 IoC 容器和组件管理机制
//     * 冲突：Spring 无法自动发现和管理非 Spring 组件（纯 Java EE 注解类）
//     * 解决方案：
//     * ServerEndpointExporter 会：
//     * 扫描 Spring 容器中所有带有 @ServerEndpoint 注解的类
//     * 注册 这些端点到底层的 WebSocket 容器中
//     * 管理 这些端点的生命周期，使其能够接收 WebSocket 连接
//     * @return
//     */
//    @Bean
//    public ServerEndpointExporter serverEndpointExporter() {
//        ServerEndpointExporter exporter = new ServerEndpointExporter();
//        System.out.println("ServerEndpointExporter 已初始化，将注册 @ServerEndpoint 注解的端点");
//        return exporter;
//    }
//}
