package com.project.gymcarry.dao;

import java.util.List;

import com.project.gymcarry.chatroom.Chat;

// 채팅 DAO
public interface ChatDao {
	
	List<Chat> selectList();
}
