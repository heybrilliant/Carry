package com.project.gymcarry.chatting.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gymcarry.chatting.ChatListDto;
import com.project.gymcarry.chatting.ChatRoomDto;
import com.project.gymcarry.dao.ChatDao;

@Service
public class ChatListService {

	@Autowired
	private SqlSessionTemplate template;
	private ChatDao dao;
	
	public List<ChatListDto> getChatList(){
		dao = template.getMapper(ChatDao.class);
		return dao.selectChatList();
	}
	
	public List<ChatRoomDto> getChatIdx(int chatidx) {
		dao = template.getMapper(ChatDao.class);
		return dao.selectChattingList(chatidx);
	}
	
}	
