package com.project.gymcarry.chatting.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gymcarry.chatting.ChatListDto;
import com.project.gymcarry.chatting.ChatRoomDto;
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

	// 사용자 아이디로 채팅룸 가져오기
	public ChatListDto getByChatRoom(int cridx, int memidx) {
		dao = template.getMapper(MatchingDao.class);
		return dao.selectByChatRoom(cridx, memidx);
	}
	
	// 채팅룸 중복확인
	public int getByChatIdx(int chatidx) {
		dao = template.getMapper(MatchingDao.class);
		return dao.selectByChatIdx(chatidx);
	}

	// 대화내용 저장
	public int insertChatContent(MessageDto messageDto) {
		dao = template.getMapper(MatchingDao.class);
		return dao.insertChatContent(messageDto);
	}
	
	// 읽음 안읽음 여부
	public int getChatRead(int chatidx) {
		dao = template.getMapper(MatchingDao.class);
		return dao.updateChatRead(chatidx);
	}
	

}
