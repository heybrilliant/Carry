package com.project.gymcarry.websokethandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.Gson;
import com.project.gymcarry.chatting.ChatRoomDto;
import com.project.gymcarry.chatting.service.MatchingChatRoomService;
import com.project.gymcarry.member.MemberDto;

@Controller
public class WebSocketHandler extends TextWebSocketHandler {

	@Autowired
	private MatchingChatRoomService matchingChatRoomService;

	private static final Logger logger = LoggerFactory.getLogger(WebSocketHandler.class);
	// 방법 1 : 전체 채팅
	// 웹 소켓 세션을 저장할 리스트
	private List<WebSocketSession> list = new ArrayList<>();

	// 방법2 : 1:1 채팅
	// 사용자와 세션 저장할 맵
	private Map<String, WebSocketSession> mapList = new HashMap<String, WebSocketSession>();

	// 커넥션이 연결되었을때
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("1번" + session.getId());

		// 회원, 캐리 세션 정보 가져오기
		String chatNick = ((MemberDto) session.getAttributes().get("member")).getMemnick();
		if (chatNick == null) {
			chatNick = ((MemberDto) session.getAttributes().get("member")).getCrnick();
		}

		// 로그인햇으면 닉네임이고 - 로그인이안되있으면 세션아이디
		// chatNick:닉네임저장 - session:웹소켓세션저장
		mapList.put(chatNick, session);

		// 웹소켓 세션을 저장
		// map, list 둘중 하나만 해도된다.
		list.add(session);

		// 세션값을 불러온 0번째 중괄호에 session.getId()을 넣으라는 뜻 : 세션 닉네임 값
		logger.info("세션추가 : " + session.getId() + " 접속자닉네임 : " + chatNick);
		System.out.println("채팅 참여자 : " + chatNick);

	}

	// 사용자로 부터 받은 메세지 보내기
	// TextMessage message : 누가 보냈는지에 대한 정보 저장.
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println("2번 " + session + " : " + message + " : " + message.getPayload());

		// 누가보냇는지 메세지타입 (mem=0 , carry=1)
		int contenttype = 0;
		String chatNick = ((MemberDto) session.getAttributes().get("member")).getMemnick();

		if (chatNick == null) {
			chatNick = ((MemberDto) session.getAttributes().get("member")).getCrnick();
			contenttype = 1;
		}
		logger.info("{}로 부터 {}를 전달 받았습니다.", chatNick, message.getPayload());

		// json객체 -> java객체
		Gson gson = new Gson();
		ChatRoomDto chatRoom = gson.fromJson(message.getPayload(), ChatRoomDto.class);

		// chatRoom에 담긴 chatidx로 해당 채팅방을 찾는다. (지우기 ㄴㄴ)
		// ChatListDto chatListDto =
		// matchingChatRoomService.getChatRoom(chatRoom.getChatidx());

		// 전달 메세지
		TextMessage sendMsg = new TextMessage(gson.toJson(chatRoom));
		Iterator<String> itr = mapList.keySet().iterator(); // 기존에 저장된 접속자 명단을 가져옴
		while (itr.hasNext()) {
			String nickSession = (String) itr.next();
			WebSocketSession ws = mapList.get(nickSession);
			// 상대방에게 메세지전달
			ws.sendMessage(sendMsg);
		}

		int result = matchingChatRoomService.insertChatContent(chatRoom.getChatidx(), chatRoom.getChatcontent(),
				chatRoom.getCridx(), chatRoom.getMemidx(), contenttype);
		System.out.println(result + "저장");

//		if (chatNick.equals(chatRoom.getMemnick())) {
//			String to = chatRoom.getMemnick();
//			WebSocketSession toSession = mapList.get(to);
//			if (toSession != null) {
//				toSession.sendMessage(sendMsg);
//			}
//		}
//		if (chatNick.equals(chatRoom.getCrnick())) {
//			String to = chatRoom.getCrnick();
//			WebSocketSession toSession = mapList.get(to);
//			if (toSession != null) {
//				toSession.sendMessage(sendMsg);
//
//			}
//		}

	}

	// 클로즈 될때.
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("3번" + session + ":" + status);
		list.remove(session);
		mapList.remove(session.getId());
		logger.info("{}연결 끊김", session.getId());
		System.out.println("채팅방 퇴장한사람 : " + session.getPrincipal().getName());

	}

}
