package com.project.gymcarry.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.project.gymcarry.carry.CarryDto;
import com.project.gymcarry.carrylike.CarryLikeDto;
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

	// 매칭캐리리스트
	List<CarryDto> selectCarryList();

	// 멤버 채팅방 나갓다 들어온 리스트
	List<ChatListDto> selectReChatList(int memIdx);

	// 캐리 채팅방 나갓다 들어온 리스트
	List<ChatListDto> selectReCarryChatList(int cridx);

	// 사용자 채팅방 가져오기
	ChatListDto selectByChatRoom(@Param("cridx") int cridx, @Param("memidx") int memidx);

	// 채팅방 중복확인
	int selectByChatIdx(int chatidx);

	// 채팅방 생성
	int insertAddChatRoom(@Param("cridx") int cridx, @Param("memidx") int memidx);

	// 대화내용 insert
	int insertChatContent(MessageDto messageDto);

	// 읽음안읽음여부
	int updateChatRead(int chatidx);

	// 하트체크
	CarryLikeDto selectLike(int memidx, int cridx);

	// 하트최초생성
	int insertLike(@Param("memidx") int memidx, @Param("cridx") int cridx, @Param("likecheck") int likecheck);

	// 하트생성 & 취소
	int updateLike(int likecheck, int memidx, int cridx);

	// 멤버 나간방 다시들어가기
	int updateInChat(int chatidx);
	
	// 캐리 나간방 사용자가 메세지입력하면 다시 들어와짐
	int updateInCarryChat(int chatidx);
	
	// 멤버 방나가기
	int updateOutChat(int chatidx);

	// 캐리 방나가기
	int updateCarryOutChat(int chatidx);

	// 방나갓다 다시들어 왔을 경우 새로입력한 메세지 입력한 date 이후 출력
	List<ChatRoomDto> selectReChattingList(int chatidx);

	// 멤버 & 캐리 둘다 나가면 방&대화내용 삭제
	int deleteChatRoom(int chatidx);

	// position 가져오기
	ChatListDto selectRoomPosition(int chatidx);

}
