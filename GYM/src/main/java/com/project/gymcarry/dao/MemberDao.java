package com.project.gymcarry.dao;

import com.project.gymcarry.carry.CarryAllDto;
import com.project.gymcarry.member.MemberDto;

public interface MemberDao {
	
	// 멤버로그인
	MemberDto login(String id, String pw);
	// 멤버회원가입
	int insertMember(MemberDto memberDto);
	// 케리회원가입
	int insertCarry(CarryAllDto carryDto);
	// 케리로그인
	CarryAllDto carryLogin(String id, String pw);
	
}
