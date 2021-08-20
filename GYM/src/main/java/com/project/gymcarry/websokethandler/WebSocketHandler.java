package com.project.gymcarry.websokethandler;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebSocketHandler extends TextWebSocketHandler {
	
	// 채팅방 생성
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
	}

	// 메세지핸들러
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
	}

	// 채팅방나가기
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
	}

}
