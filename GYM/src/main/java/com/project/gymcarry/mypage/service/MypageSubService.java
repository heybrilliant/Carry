package com.project.gymcarry.mypage.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gymcarry.board.BoardDto;
import com.project.gymcarry.board.Pagination;
import com.project.gymcarry.carry.CarryListDto;
import com.project.gymcarry.dao.BoardDao;
import com.project.gymcarry.dao.MypageDao;
import com.project.gymcarry.mypage.MypageMemberDto;
import com.project.gymcarry.mypage.MypagePaymentDto;

@Service
public class MypageSubService {

	@Autowired
	private SqlSessionTemplate template;

	private MypageDao dao;

	public List<MypagePaymentDto> selectpayment(int i) {
		dao = template.getMapper(MypageDao.class);
		return dao.selectpayment(i);
	}

	public List<MypageMemberDto> selectmember(int i) {
		dao = template.getMapper(MypageDao.class);
		return dao.selectmember(i);
	}

	public List<CarryListDto> getMyCarryList(int i) {
		dao = template.getMapper(MypageDao.class);
		return dao.getMyCarryList(i);
	}

	public int getBoardListCnt(int i) {
		dao = template.getMapper(MypageDao.class);
		return dao.getBoardListCnt(i);
	}

	public List<BoardDto> getBoardList(Pagination pagination) throws Exception {
		
		
		dao = template.getMapper(MypageDao.class);
		return dao.getBoardList(pagination);
	}

	public void memberUpdate(int i) {

		dao.memberupdate(i);
	}
}
