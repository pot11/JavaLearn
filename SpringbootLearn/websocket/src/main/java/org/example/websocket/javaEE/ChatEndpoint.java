//package com.example.springbootlearn.webSocket.javaEE;
//
//import org.springframework.stereotype.Component;
//
//import javax.websocket.*;
//import javax.websocket.server.ServerEndpoint;
//import java.io.IOException;
//import java.util.Collections;
//import java.util.HashSet;
//import java.util.Set;
//
//@Component
//@ServerEndpoint("/chat")
//public class ChatEndpoint {
//
//    // 使用线程安全的集合管理所有会话
//    private static Set<Session> clients =
//            Collections.synchronizedSet(new HashSet<>());
//
//    @OnOpen
//    public void onOpen(Session session) {
//        clients.add(session);
//        System.out.println("WebSocket连接建立，Session ID：" + session.getId());
//
//        // 向客户端发送欢迎消息
//        try {
//            session.getBasicRemote().sendText("连接成功，欢迎加入聊天室！");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @OnMessage
//    public void onMessage(String message, Session session) {
//        System.out.println("收到来自 " + session.getId() + " 的消息: " + message);
//
//        // 广播消息给所有连接的客户端
//        broadcast(message, session);
//    }
//
//    @OnClose
//    public void onClose(Session session) {
//        clients.remove(session);
//        System.out.println("WebSocket连接关闭，Session ID：" + session.getId());
//    }
//
//    @OnError
//    public void onError(Session session, Throwable throwable) {
//        System.err.println("Session " + session.getId() + " 发生错误:");
//        throwable.printStackTrace();
//    }
//
//    // 广播消息给所有客户端（排除发送者）
//    private void broadcast(String message, Session sender) {
//        synchronized(clients) {
//            for (Session session : clients) {
//                if (session.isOpen() && !session.equals(sender)) {
//                    try {
//                        session.getBasicRemote().sendText(
//                                "用户 " + sender.getId() + ": " + message);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }
//    }
//}
