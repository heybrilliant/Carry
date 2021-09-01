package com.project.gymcarry.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.project.gymcarry.chatting.ChatListDto;
import com.project.gymcarry.chatting.ChatRoomDto;
import com.project.gymcarry.chatting.MessageDto;

// matching DAO
public interface MatchingDao {

	// 채팅 리스트
	List<ChatRoomDto> selectChattingList(int chatidx);

	// 유저 채팅방 리스트
	List<ChatListDto> selectChatList(int memidx);

	// 캐리 채팅방 리스트
	List<ChatListDto> selectCarryChatList(int cridx);


	// 사용자 채팅방 가져오기
	ChatListDto selectByChatRoom(@Param("cridx") int cridx, @Param("memidx") int memidx);

	// 채팅방 중복확인 
	int selectByChatIdx(int chatidx);
	
	// 채팅방 생성
	int insertAddChatRoom(@Param("cridx") int cridx, @Param("memidx") int memidx);

	// 대화내용 insert
	int insertChatContent(MessageDto messageDto);
}
