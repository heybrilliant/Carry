package com.project.gymcarry.chatting.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gymcarry.carrylike.CarryLikeDto;
import com.project.gymcarry.chatting.ChatListDto;
import com.project.gymcarry.chatting.MessageDto;
import com.project.gymcarry.dao.MatchingDao;

@Service
public class MatchingChatRoomService {

	@Autowired
	private SqlSessionTemplate template;

	private MatchingDao dao;

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

}
