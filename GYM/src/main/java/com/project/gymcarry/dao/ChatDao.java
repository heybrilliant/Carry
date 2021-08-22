package com.project.gymcarry.dao;

import java.util.List;

import com.project.gymcarry.chatting.ChatListDto;
import com.project.gymcarry.chatting.ChatRoomDto;

// 채팅 DAO
public interface ChatDao {
	
	// 채팅 리스트
	List<ChatRoomDto> selectChattingList(int chatidx);
	// 채팅방 리스트
	List<ChatListDto> selectChatList();
	
}
