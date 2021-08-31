package com.project.gymcarry.dao;

import com.project.gymcarry.carry.CarryDto;
import com.project.gymcarry.member.MemberDto;
import com.project.gymcarry.member.SessionDto;

public interface MemberDao {
	
	// 멤버로그인
	SessionDto memberLogin(String id, String pw);
	// 멤버회원가입
	int insertMember(MemberDto memberDto);
	// 케리회원가입
	int insertCarry(CarryDto carryDto);
	// 케리로그인
	SessionDto carryLogin(String id, String pw);
	
}
