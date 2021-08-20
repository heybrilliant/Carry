package com.project.gymcarry.chatroom;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gymcarry.dao.ChatDao;

@Service
public class ChatTestService {

	@Autowired
	private SqlSessionTemplate template;
	private ChatDao dao;
	
	public List<Chat> getChatList(){
		dao = template.getMapper(ChatDao.class);
		return dao.selectList();
	}
	
}
