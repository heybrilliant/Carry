package com.project.gymcarry.admin.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gymcarry.admin.AdminSessionDto;
import com.project.gymcarry.carry.CarryListDto2;
import com.project.gymcarry.dao.AdminDao;
import com.project.gymcarry.member.MemberListDto;

@Service
public class adminService {
	
	@Autowired
	private SqlSessionTemplate template;
	private AdminDao dao;
	
	// 관리자 로그인
	public AdminSessionDto adminLogin(String id, String pw) {
		dao = template.getMapper(AdminDao.class);
		return dao.adminLogin(id, pw);
	}
	
	
	
	// 회원 관리 : 전체 회원 리스트
	public List<MemberListDto> allMemberList() {
		dao = template.getMapper(AdminDao.class);
		return dao.selectAllMemberList();
	}
	
	// 회원 관리 : 전체 캐리 리스트
	public List<CarryListDto2> allCarryList() {
		dao = template.getMapper(AdminDao.class);
		return dao.selectAllCarryList();
	}
	
	
	
	// 회원 관리 : 회원 탈퇴 처리
	public void deleteMemberReview(int memidx) {
		dao.deleteMemberReview(memidx);
	}
	public void deleteMemberChatList(int memidx) {
		dao.deleteMemberReview(memidx);
	}
	public void deleteMemberChatRoom(int memidx) {
		dao.deleteMemberReview(memidx);
	}
	public void deleteMemberPayment(int memidx) {
		dao.deleteMemberReview(memidx);
	}
	public void deleteMemberBodyInfo(int memidx) {
		dao.deleteMemberReview(memidx);
	}
	public void deleteMemberLikeList(int memidx) {
		dao.deleteMemberReview(memidx);
	}
	public void deleteMember(int memidx) {
		dao.deleteMember(memidx);
	}
	
	
	// 캐리 관리 : 캐리 탈퇴 처리
	public void deleteCarryReview(int cridx) {
		dao.deleteCarryReview(cridx);
	}
	public void deleteCarryChatList(int cridx) {
		dao.deleteCarryReview(cridx);
	}
	public void deleteCarryChatRoom(int cridx) {
		dao.deleteCarryReview(cridx);
	}
	public void deleteCarryPayment(int cridx) {
		dao.deleteCarryReview(cridx);
	}
	public void deleteCarryCerti(int cridx) {
		dao.deleteCarryReview(cridx);
	}
	public void deleteCarryPrice(int cridx) {
		dao.deleteCarryReview(cridx);
	}
	public void deleteCarryLikeList(int cridx) {
		dao.deleteCarryReview(cridx);
	}
	public void deleteCarry(int cridx) {
		dao.deleteCarry(cridx);
	}

}
