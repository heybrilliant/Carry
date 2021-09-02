package com.project.gymcarry.websokethandler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import com.project.gymcarry.chatting.MessageDto;
import com.project.gymcarry.chatting.service.MatchingChatRoomService;
import com.project.gymcarry.member.SessionDto;

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
	private Map<Integer, WebSocketSession> mapList = new HashMap<Integer, WebSocketSession>();

	// 커넥션이 연결되었을때
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("1번" + session.getId());

		// 회원, 캐리 세션 정보 가져오기
		int chatNick = ((SessionDto) session.getAttributes().get("loginSession")).getMemidx();
		if (chatNick == 0) {
			chatNick = ((SessionDto) session.getAttributes().get("loginSession")).getCridx();
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
		int chatNick = ((SessionDto) session.getAttributes().get("loginSession")).getMemidx();
		if (chatNick == 0) {
			chatNick = ((SessionDto) session.getAttributes().get("loginSession")).getCridx();
			++contenttype;
		}
		logger.info("{}로 부터 {}를 전달 받았습니다.", chatNick, message.getPayload());
		
		SimpleDateFormat format = new SimpleDateFormat ("HH:mm a");
		Date time = new Date();
		String date = format.format(time);

		// json객체 -> java객체
		Gson gson = new Gson();
		MessageDto messageDto = gson.fromJson(message.getPayload(), MessageDto.class);
		messageDto.setContenttype(contenttype);
		messageDto.setChatdate(date);
		// 뷰딴에 보낼 메세지
		TextMessage sendMsg = new TextMessage(gson.toJson(messageDto));

		// 전달 메세지
		if (chatNick == messageDto.getCridx()) {
			int to = messageDto.getMemidx();
			WebSocketSession toSession = mapList.get(to);
			System.out.println(toSession);
			if (toSession != null) {
				toSession.sendMessage(sendMsg);
				session.sendMessage(sendMsg);
			} else {
				session.sendMessage(sendMsg);
			}
			matchingChatRoomService.insertChatContent(messageDto);
		} else if (chatNick == messageDto.getMemidx()) {
			int st = messageDto.getCridx();
			WebSocketSession toSession = mapList.get(st);
			System.out.println(toSession);
			if (toSession != null) {
				toSession.sendMessage(sendMsg);
				session.sendMessage(sendMsg);
			} else {
				session.sendMessage(sendMsg);
			}
			matchingChatRoomService.insertChatContent(messageDto);
		}
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
