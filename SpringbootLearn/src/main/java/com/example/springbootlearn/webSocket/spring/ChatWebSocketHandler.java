package com.example.springbootlearn.webSocket.spring;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

//@Component
public class ChatWebSocketHandler extends TextWebSocketHandler {

    // 存储所有活跃的WebSocket会话，线程安全
    private static final List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    /**
     * 客户端连接成功后调用
     * @param session 客户端的WebSocket会话
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // 将新连接加入会话列表
        sessions.add(session);
        // 可选：通知所有用户有新连接加入
        broadcastMessage(session, "系统：有新用户加入聊天室");
    }

    /**
     * 处理客户端发送的文本消息
     * @param session 发送消息的客户端会话
     * @param message 客户端发送的消息
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // 获取客户端发送的文本内容
        String payload = message.getPayload();

        // 这里可以添加消息处理逻辑，如解析JSON、消息路由等
        // 示例：简单地将消息广播给所有连接的用户
        broadcastMessage(session, "用户[" + session.getId() + "]说: " + payload);
    }

    /**
     * 连接关闭后调用
     * @param session 关闭的会话
     * @param status 关闭状态
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        // 从会话列表中移除关闭的连接
        sessions.remove(session);
        // 可选：通知所有用户有连接离开
        broadcastMessage(session, "系统：用户[" + session.getId() + "]已离开");
    }

    /**
     * 处理通信过程中的错误
     * @param session 发生错误的会话
     * @param exception 异常信息
     */
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        System.err.println("WebSocket通信错误，会话ID: " + session.getId());
        exception.printStackTrace();
    }

    /**
     * 向所有连接的用户广播消息（除了消息发送者自己）
     * @param senderSession 发送者的会话
     * @param message 要广播的消息内容
     */
    private void broadcastMessage(WebSocketSession senderSession, String message) {
        try {
            for (WebSocketSession session : sessions) {
                // 检查会话是否仍然开放，并且可以选择不发送给消息源
                if (session.isOpen()) {
                    // 如果需要排除发送者自己，取消下一行的注释
                    // if (!session.equals(senderSession)) {
                    session.sendMessage(new TextMessage(message));
                    // }
                }
            }
        } catch (Exception e) {
            System.err.println("广播消息时发生错误: " + e.getMessage());
        }
    }
}