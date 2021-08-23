package com.project.gymcarry.dao;

import java.util.List;

import com.project.gymcarry.carry.CarryDto;
import com.project.gymcarry.chatting.ChatListDto;
import com.project.gymcarry.chatting.ChatRoomDto;

// matching DAO
public interface MatchingDao {
	
	// 채팅 리스트
	List<ChatRoomDto> selectChattingList(int chatidx);
	// 채팅방 리스트
	List<ChatListDto> selectChatList();
	// 매칭캐리리스트
	List<CarryDto> selectCarryList();
}
