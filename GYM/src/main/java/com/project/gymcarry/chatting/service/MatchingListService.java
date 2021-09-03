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
	
	// 멤버 채팅방 리스트
	public List<ChatListDto> getChatList(int memIdx){
		dao = template.getMapper(MatchingDao.class);
		
		List<ChatListDto> list =  dao.selectChatList(memIdx);
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getMessageidx() != 0) {
				return list;
			}
		}
		return dao.selectNotChatList(memIdx);
	}
	// 캐리 채팅방 리스트
	public List<ChatListDto> getChatLists(int cridx){
		dao = template.getMapper(MatchingDao.class);
		return dao.selectCarryChatList(cridx);
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
