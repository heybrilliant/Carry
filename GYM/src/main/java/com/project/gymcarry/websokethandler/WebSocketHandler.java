package com.project.gymcarry.websokethandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.Gson;
import com.project.gymcarry.chatting.ChatRoomDto;

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
		// 1.회원, 캐리 세션 정보 가져오기
		String chatNick = (String) session.getAttributes().get("nick");
		
		// 2.로그인햇으면 닉네임이고 - 로그인이안되있으면 세션아이디
		// 	 chatNick:닉네임저장 - session:웹소켓세션저장
		mapList.put(chatNick, session);
		
		// 3.세션이 객체일 경우 맵형식으로 가져 올수 있다.
//		Map<String, Object> map = session.getAttributes();
//		MemberDto mem = (MemberDto) map.get("member");
		// 세션에 저장되어 있는 닉네임값을 변수에 담는다.
//		String memnick = mem.getMemnick();
		
		// 4.웹소켓 세션을 저장
		//   map, list 둘중 하나만 해도된다.
		list.add(session);
		// 사용자닉네임과 웹소켓세션을 맵에 저장한다.
//		mapList.put(memnick, session);
		
		// 세션값을 불러온 0번째 중괄호에 session.getId()을 넣으라는 뜻 : 세션 닉네임 값
		logger.info("{} 연결됨", session.getId()+ " : " + chatNick);
		System.out.println("채팅 참여자 : " + chatNick);

	}

	// 사용자로 부터 받은 메세지 보내기
	// TextMessage message : 누가 보냈는지에 대한 정보 저장.
	@Override	
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println("2번 " + session + " : " + message + " : " + message.getPayload());
		
		String chatNick = (String) session.getAttributes().get("nick");
		logger.info("{}로 부터 {}를 전달 받았습니다.", chatNick, message.getPayload());
		
		// json 형태로 짤라 보내준다.
		// json 안쓰면 배열 split으로 보내야한다.(json짱!)
		Gson gson = new Gson();
		ChatRoomDto chatRoom = gson.fromJson(message.getPayload(), ChatRoomDto.class);
		
		Iterator<String> itr = mapList.keySet().iterator();
		while(itr.hasNext()) {
			String nickSession = (String) itr.next();
			if(nickSession.equals(chatRoom.getCrnick())) {
				WebSocketSession ws = mapList.get(chatRoom.getCrnick());
				
				// String이아닌 josn을 TextMessage 객체에 담아 메세지를 보낸다.
				TextMessage sendMsg = new TextMessage(gson.toJson(chatRoom));
				
				// 상대방에게 메세지전달
				ws.sendMessage(sendMsg);
				// 자신에게 메세지 전달
				session.sendMessage(sendMsg);
				
			}
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
		System.out.println("3번" + session + ":" + status);
		// list 세션삭제
		list.remove(session);
		// map 세션삭제
		mapList.remove(session.getId());
		
		logger.info("{}연결 끊김", session.getId());
		
		System.out.println("채팅방 퇴장한사람 : " + session.getPrincipal().getName());

	}

}
