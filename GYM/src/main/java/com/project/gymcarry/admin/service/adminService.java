package com.project.gymcarry.admin.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gymcarry.admin.AdminSessionDto;
import com.project.gymcarry.carry.CarryDto;
import com.project.gymcarry.carry.CarryListDto2;
import com.project.gymcarry.dao.AdminDao;
import com.project.gymcarry.dao.CarryDao;
import com.project.gymcarry.member.MemberListDto;
import com.project.gymcarry.place.PlaceDto;
import com.project.gymcarry.place.PlaceListDto;

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
	
	// 컨텐츠 관리  : 전체 플레이스 리스트
	public List<PlaceListDto> allPlaceList() {
		dao = template.getMapper(AdminDao.class);
		return dao.selectAllPlaceList();
	}

	// 컨텐츠 관리 : 플레이스 등록
	public int registerPlace(PlaceDto placeDto) {
		dao = template.getMapper(AdminDao.class);
		return dao.registerPlace(placeDto);
	}
	
	// 컨텐츠 관리 : 플레이스 기본 정보 호출 - 수정페이지
	public PlaceDto getPlaceOriginal(int placeidx) {
		dao = template.getMapper(AdminDao.class);
		return dao.getPlaceOriginal(placeidx);
	}
	
//	// 컨텐츠 관리 : 플레이스 수정
//	public PlaceDto updatePlace(int placeidx) {
//		dao = template.getMapper(AdminDao.class);
//		return dao.updatePlace(placeidx);
//	}

	
	
	
	// 회원 탈퇴 처리
	public void deleteMember(int memidx) {
		dao.deleteMember(memidx);
	}
	// 캐리 탈퇴 처리
	public void deleteCarry(int cridx) {
		dao.deleteCarry(cridx);
	}

}
