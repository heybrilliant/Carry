package com.project.gymcarry.chatting.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gymcarry.carrylike.CarryLikeDto;
import com.project.gymcarry.chatting.ChatListDto;
import com.project.gymcarry.chatting.ChatRoomDto;
import com.project.gymcarry.chatting.MessageDto;
import com.project.gymcarry.dao.MatchingDao;

@Service
public class MatchingChatRoomService {

	@Autowired
	private SqlSessionTemplate template;

	private MatchingDao dao;

	// 멤버 채팅방 리스트
	public List<ChatListDto> getChatList(int memIdx) {
		dao = template.getMapper(MatchingDao.class);
		List<ChatListDto> list = dao.selectChatList(memIdx);
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getMemposition() == 2) {
				list = dao.selectReChatList(memIdx);
			}
		}
		return list;
	}

	// 캐리 채팅방 리스트
	public List<ChatListDto> getChatLists(int cridx) {
		dao = template.getMapper(MatchingDao.class);
		List<ChatListDto> list = dao.selectCarryChatList(cridx);
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getMemposition() == 2) {
				list = dao.selectReCarryChatList(cridx);
			}
		}
		return list;
	}

	// 대화 리스트
	public List<ChatRoomDto> getChatIdx(int chatidx) {
		dao = template.getMapper(MatchingDao.class);
		// 나갓다 들어온방이 아닐 경우 출력
		List<ChatRoomDto> list = dao.selectChattingList(chatidx);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getMemposition() == 2 || list.get(i).getCarryposition() == 2) {
				// 방나갓다 다시들어 왔을 경우 새로입력한 메세지 입력한 date 이후 출력
				list = dao.selectReChattingList(chatidx);
				return list;
			}
		}
		return list;
	}

	// 채팅방 생성
	public int getAddChatRoom(int cridx, int memidx) {
		dao = template.getMapper(MatchingDao.class);
		return dao.insertAddChatRoom(cridx, memidx);
	}

	// 사용자 아이디로 채팅룸 가져오기
	public ChatListDto getByChatRoom(int cridx, int memidx) {
		dao = template.getMapper(MatchingDao.class);
		return dao.selectByChatRoom(cridx, memidx);
	}

	// 채팅룸 중복확인
	public int getByChatIdx(int chatidx) {
		dao = template.getMapper(MatchingDao.class);
		return dao.selectByChatIdx(chatidx);
	}

	// 대화내용 저장
	public int insertChatContent(MessageDto messageDto) {
		dao = template.getMapper(MatchingDao.class);
		return dao.insertChatContent(messageDto);
	}

	// 읽음 안읽음 여부
	public int getChatRead(int chatidx) {
		dao = template.getMapper(MatchingDao.class);
		return dao.updateChatRead(chatidx);
	}

	// 하트체크
	public CarryLikeDto getCheckLike(int memidx, int cridx) {
		dao = template.getMapper(MatchingDao.class);
		return dao.selectLike(memidx, cridx);
	}

	// 하트최초생성
	public int getChatLike(int memidx, int cridx, int likecheck) {
		dao = template.getMapper(MatchingDao.class);
		return dao.insertLike(memidx, cridx, likecheck);
	}

	// 하트생성 & 취소
	public int updateChatLike(int likecheck, int memidx, int cridx) {
		dao = template.getMapper(MatchingDao.class);
		return dao.updateLike(likecheck, memidx, cridx);
	}

	// 멤버 나간방 다시 들어가기
	public int getInChatRoom(int chatidx) {
		dao = template.getMapper(MatchingDao.class);
		return dao.updateInChat(chatidx);
	}
	
	// 캐리 나간방 사용자가 메세지입력하면 다시 들어와짐
	public int getInCaryChatRoom(int chatidx) {
		dao = template.getMapper(MatchingDao.class);
		return dao.updateInCarryChat(chatidx);
	}

	// 멤버 방나가기
	public int getOutChatRoom(int chatidx) {
		dao = template.getMapper(MatchingDao.class);
		return dao.updateOutChat(chatidx);
	}

	// 캐리 방나가기
	public int getOutCarryChatRoom(int chatidx) {
		dao = template.getMapper(MatchingDao.class);
		return dao.updateCarryOutChat(chatidx);
	}
	
	// 멤버 & 캐리 둘다 나가면 방&대화내용 삭제
	public int deleteChatRoom(int chatidx) {
		dao = template.getMapper(MatchingDao.class);
		ChatListDto dto = dao.selectRoomPosition(chatidx);
		int result = 0;
		if (chatidx == dto.getChatidx() && dto.getMemposition() == 1 && dto.getCarryposition() == 1) {
			result = dao.deleteChatRoom(chatidx);
		}
		return result;
	}
	
	// 나감안나감 확인용
	public ChatListDto selectRoomPosition(int chatidx) {
		dao = template.getMapper(MatchingDao.class);
		return dao.selectRoomPosition(chatidx);
	}
	
}
