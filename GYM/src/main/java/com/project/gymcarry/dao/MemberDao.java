package com.project.gymcarry.dao;

import com.project.gymcarry.carry.CarryDto;
import com.project.gymcarry.member.MemberDto;

public interface MemberDao {
	
	// 로그인
	MemberDto login(String id, String pw);
	// 회원가입
	int insertMember(MemberDto memberDto);
	// 케리회원가입
	int insertCarry(CarryDto carryDto);
}
