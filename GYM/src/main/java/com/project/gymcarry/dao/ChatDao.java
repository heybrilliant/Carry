package com.project.gymcarry.dao;

import java.util.List;

import com.project.gymcarry.chatroom.ChatDto;

// 채팅 DAO
public interface ChatDao {
	
	// 채팅방 리스트
	List<ChatDto> selectRoomList();
	
}
