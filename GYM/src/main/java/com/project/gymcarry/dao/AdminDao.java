package com.project.gymcarry.dao;

import java.util.List;

import com.project.gymcarry.admin.AdminSessionDto;
import com.project.gymcarry.carry.CarryListDto2;
import com.project.gymcarry.member.MemberListDto;

public interface AdminDao {

	// 관리자 로그인
	AdminSessionDto adminLogin(String id, String pw);
	
	
	// 전체 회원 리스트
	List<MemberListDto> selectAllMemberList();
	
	// 전체 캐리 리스트
	List<CarryListDto2> selectAllCarryList();

	
	// 회원 탈퇴 처리
	public void deleteMemberReview(int memidx);
	public void deleteMemberChatList(int cridx);
	public void deleteMemberChatRoom(int cridx);
	public void deleteMemberPayment(int cridx);
	public void deleteMemberBodyInfo(int cridx);
	public void deleteMemberLikeList(int cridx);
	public void deleteMember(int memidx);
	
	// 캐리 탈퇴 처리
	public void deleteCarryReview(int cridx);
	public void deleteCarryChatList(int cridx);
	public void deleteCarryChatRoom(int cridx);
	public void deleteCarryPayment(int cridx);
	public void deleteCarryCerti(int cridx);
	public void deleteCarryPrice(int cridx);
	public void deleteCarryLikeList(int cridx);
	public void deleteCarry(int cridx);

}
