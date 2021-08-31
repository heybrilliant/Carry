package com.project.gymcarry.chatting.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gymcarry.chatting.ChatListDto;
import com.project.gymcarry.chatting.MessageDto;
import com.project.gymcarry.dao.MatchingDao;

@Service
public class MatchingChatRoomService {

	@Autowired
	private SqlSessionTemplate template;

	private MatchingDao dao;

	// 채팅방 생성
	public int getAddChatRoom(int cridx, int memidx) {
		dao = template.getMapper(MatchingDao.class);
		return dao.insertAddChatRoom(cridx, memidx);
	}

	// 채팅방 중복 확인
	public List<ChatListDto> getByChatRoom(int memidx) {
		dao = template.getMapper(MatchingDao.class);
		return dao.selectByChatRoom(memidx);
	}

	// 채팅방 찾기
	public ChatListDto getChatRoom(int chatidx) {
		dao = template.getMapper(MatchingDao.class);
		return dao.selectChatRoom(chatidx);
	}

	// 대화내용 저장
	public int insertChatContent(MessageDto messageDto) {
		dao = template.getMapper(MatchingDao.class);
		return dao.insertChatContent(messageDto);
	}
//	public int insertChatContent(int chatidx, String chatContent, int cridx, int memidx, int contenttype) {
//		dao = template.getMapper(MatchingDao.class);
//		return dao.insertChatContent(chatidx, chatContent, cridx, memidx, contenttype);
//	}

}
