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
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.Gson;
import com.project.gymcarry.chatting.MessageDto;
import com.project.gymcarry.chatting.service.MatchingChatRoomServiceImpl;

public class WebSocketHandler extends TextWebSocketHandler {

	@Autowired
	private MatchingChatRoomServiceImpl matchingChatRoomService;

	private static final Logger logger = LoggerFactory.getLogger(WebSocketHandler.class);
	// 웹 소켓 세션을 저장할 리스트
	private List<WebSocketSession> list = new ArrayList<>();

	// 사용자와 세션 저장할 맵
	private Map<String, WebSocketSession> mapList = new HashMap<String, WebSocketSession>();
	// room session 저장 상대방이 방에 나갓는지 있는지 체크
	private Map<WebSocketSession, String> roomList = new HashMap<WebSocketSession, String>();
	// 룸번호 저장
	private Map<Integer, Object> roomIdx = new HashMap<Integer, Object>();
	
	// 커넥션이 연결되었을때
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("1번" + session.getId());

		// 회원, 캐리 세션 정보 가져오기
		String chatNick = (String) session.getAttributes().get("chatSession");

		// 로그인햇으면 닉네임이고 - 로그인이안되있으면 세션아이디
		// chatNick:닉네임저장 - session:웹소켓세션저장
		mapList.put(chatNick, session);
		roomList.put(session, chatNick);
		
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
		// 유저가 보낸메세지 0, 캐리가보낸메세지 1 (읽음 안읽음 처리)
		int chatRead = 0;
		// 자기가보낸 메세지 읽음 처리
		String chatNick = (String) session.getAttributes().get("chatSession");
		logger.info("{}로 부터 {}를 전달 받았습니다.", chatNick, message.getPayload());

		SimpleDateFormat format = new SimpleDateFormat("h:mm a");
		Date time = new Date();
		String date = format.format(time);

		// json객체 -> java객체
		Gson gson = new Gson();
		MessageDto messageDto = gson.fromJson(message.getPayload(), MessageDto.class);
		messageDto.setChatdate(date);
		if (chatNick.equals(messageDto.getCrnick())) {
			messageDto.setContenttype(++contenttype);
			messageDto.setChatread(++chatRead);
		}

		// 뷰딴에 보낼 메세지
		TextMessage sendMsg = new TextMessage(gson.toJson(messageDto));

		int result = 0;
		String to = messageDto.getTo();
		WebSocketSession toSession = mapList.get(to);
		
		if (toSession != null && roomList.size() >= 2) {
			toSession.sendMessage(sendMsg);
			session.sendMessage(sendMsg);
			result = matchingChatRoomService.insertChatContent(messageDto);
			if (result == 1) {
				// 방에 서로 있으면 메세지 보낼때 읽음 처리
				matchingChatRoomService.getChatRead(messageDto.getChatidx());
			}
		} else {
			session.sendMessage(sendMsg);
			matchingChatRoomService.insertChatContent(messageDto);
		}
		
		
	}

	// 클로즈 될때.
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		String chatNick = (String) session.getAttributes().get("chatSession");
		
		list.remove(session);
		mapList.remove(session.getId());
		roomList.remove(session);
		logger.info("{}연결 끊김", session.getId() + chatNick);
		System.out.println("채팅방 퇴장한사람 : " + session.getId() + chatNick);
		
		
	}

}
