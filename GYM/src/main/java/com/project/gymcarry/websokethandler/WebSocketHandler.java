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

public class WebSocketHandler extends TextWebSocketHandler {

	private static final Logger logger = LoggerFactory.getLogger(WebSocketHandler.class);
	// 웹 소켓 세션을 저장할 리스트
	private List<WebSocketSession> list = new ArrayList<>();
	// 사용자와 세션 저장할 맵
	private Map<String, WebSocketSession> mapList = new HashMap<String, WebSocketSession>();

	// 커넥션이 연결되었을때
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("1번" + session);
		list.add(session);
		
		
		
		// 회원, 캐리 세션 정보 가져오기
//		String chatMember = (String) session.getAttributes().get("memnick");
//		Map<String, Object> map = session.getAttributes();
//		MemberDto mem = (MemberDto) map.get("member");
		// 세션에 저장되어 있는 닉네임값을 변수에 담는다.
//		String memnick = mem.getMemnick();
		// 웹소켓 세션을 저장
//		list.add(session);
		// 사용자닉네임과 웹소켓세션을 맵에 저장한다.
//		mapList.put(memnick, session);
		
		// 세션값을 불러온
		// 0번째 중괄호에 session.getId()을 넣으라는 뜻 : 세션 닉네임 값
//		logger.info("{} 연결됨", session.getId()+ " : " + memnick);
//		System.out.println("채팅 참여자 : " + memnick);

	}

	// 사용자로 부터 받은 메세지 보내기
	//TextMessage message : 누가 보냈는지에 대한 정보 저장.
	@Override	
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println("2번 " + session + " : " + message + " : " + message.getPayload());
		String sendId = session.getId();
		for(WebSocketSession sess: list) {
			sess.sendMessage(new TextMessage(sendId + " : " + message.getPayload()));
		}
		
		
		
		
		
		
		
//		String chatMem = (String) session.getAttributes().get("member");	
		// 회원, 캐리 세션 정보 가져오기
//		Map<String, Object> map = session.getAttributes();
//		MemberDto mem = (MemberDto) map.get("member");
//		System.out.println(mem + ":" + message.getPayload());
//		logger.info("{}로 부터 {}를 전달 받았습니다.", mem, message.getPayload());
//		Gson gson = new Gson();
//		Message msg = gson.fromJson(message.getPayload(), Message.class);
//		System.out.println(msg);
//		Iterator<String> itr = mapList.keySet().iterator();
//		String sessionId = "";
//		while(itr.hasNext()) {
//			sessionId = itr.next();
//			mapList.get(sessionId).sendMessage(new TextMessage("echo:" +  message.getPayload()));
//			session.sendMessage(new TextMessage("echo:" +  message.getPayload()));
//		}
//		for (WebSocketSession sess : list) {
//			sess.sendMessage(message);
//		}
	}

	// 클로즈 될때.
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
//		System.out.println("3번" + session + ":" + status);
//		// list 삭제
//		list.remove(session);
//		
//		// map 삭제
//		mapList.remove(session.getId());
//		
//		logger.info("{}연결 끊김", session.getId());
//		
//		System.out.println("채팅방 퇴장한사람 : " + session.getPrincipal().getName());

	}

}
