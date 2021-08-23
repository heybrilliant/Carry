package com.project.gymcarry.chatting.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gymcarry.carry.CarryDto;
import com.project.gymcarry.chatting.ChatListDto;
import com.project.gymcarry.chatting.ChatRoomDto;
import com.project.gymcarry.dao.MatchingDao;

@Service
public class MatchingListService {

	@Autowired
	private SqlSessionTemplate template;
	private MatchingDao dao;
	
	// 채팅방 리스트
	public List<ChatListDto> getChatList(){
		dao = template.getMapper(MatchingDao.class);
		return dao.selectChatList();
	}
	
	// 대화방 리스트
	public List<ChatRoomDto> getChatIdx(int chatidx) {
		dao = template.getMapper(MatchingDao.class);
		return dao.selectChattingList(chatidx);
	}
	
	// 매칭 캐리리스트
	public List<CarryDto> getCarryList(){
		dao = template.getMapper(MatchingDao.class);
		return dao.selectCarryList();
	}
}	
