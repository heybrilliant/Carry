package com.project.gymcarry.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.project.gymcarry.carry.CarryJoinDto;
import com.project.gymcarry.chatting.ChatListDto;
import com.project.gymcarry.chatting.ChatRoomDto;

// matching DAO
public interface MatchingDao {
	
	// 채팅 리스트
	List<ChatRoomDto> selectChattingList(int chatidx);
	// 유저 채팅방 리스트
	List<ChatListDto> selectChatList(int memidx);
	// 캐리 채팅방 리스트
	List<ChatListDto> selectCarryChatList(int cridx);
	// 매칭캐리리스트
	List<CarryJoinDto> selectCarryList();
	// 채팅방 생성
	int insertAddChatRoom(@Param("cridx") int cridx, @Param("memidx") int memidx);
	// 채팅방 중복확인
	List<ChatListDto> selectByChatRoom(int crnick);
	// 채팅방 찾기
	ChatListDto selectChatRoom(int chatidx);
	// 대화내용 insert
	int insertChatContent(ChatRoomDto chatRoom);
}
