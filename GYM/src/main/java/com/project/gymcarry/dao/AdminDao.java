package com.project.gymcarry.dao;

import java.util.List;

import com.project.gymcarry.admin.AdminSessionDto;
import com.project.gymcarry.carry.CarryDto;
import com.project.gymcarry.carry.CarryListDto2;
import com.project.gymcarry.member.MemberListDto;
import com.project.gymcarry.place.PlaceDto;
import com.project.gymcarry.place.PlaceListDto;

public interface AdminDao {

	// 관리자 로그인
	AdminSessionDto adminLogin(String id, String pw);
	
	// 전체 회원 리스트
	List<MemberListDto> selectAllMemberList();
	// 전체 캐리 리스트
	List<CarryListDto2> selectAllCarryList();
	
	// 전체 플레이스 리스트
	List<PlaceListDto> selectAllPlaceList();
	// 플레이스 추가
	int registerPlace(PlaceDto placeDto);
	// 플레이스 기존 정보 호출 : 수정폼
	PlaceDto getPlaceOriginal(int placeidx);
	
	// 플레이스 수정
//	PlaceDto updatePlace(int placeidx);
	
	// 회원 탈퇴 처리
	public void deleteMember(int memidx);
	// 캐리 탈퇴 처리
	public void deleteCarry(int cridx);

}
