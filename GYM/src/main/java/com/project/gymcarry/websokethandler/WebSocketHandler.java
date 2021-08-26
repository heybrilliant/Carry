package com.project.gymcarry.websokethandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.project.gymcarry.member.MemberDto;

public class WebSocketHandler extends TextWebSocketHandler {

	private static final Logger logger = LoggerFactory.getLogger(WebSocketHandler.class);
	// 웹 소켓 세션을 저장할 리스트
	private List<WebSocketSession> list = new ArrayList<>();
	// 사용자와 세션 저장할 맵
	private Map<String, WebSocketSession> mapList = new HashMap<String, WebSocketSession>();

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		
		// 회원, 캐리 세션 정보 가져오기
		Map<String, Object> map = session.getAttributes();
		MemberDto mem = (MemberDto) map.get("member");
		// 세션에 저장되어 있는 닉네임값을 변수에 담는다.
		String memnick = mem.getMemnick();
		
		// 웹소켓 세션을 저장
		list.add(session);
		// 사용자닉네임과 웹소켓세션을 맵에 저장한다.
		mapList.put(memnick, session);
		
		logger.info("채팅방 연결 성공 !!" + session.getId()+ " : " + memnick);

	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println(session + ":" + status);
	}

}
