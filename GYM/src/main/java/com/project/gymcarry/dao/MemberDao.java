package com.project.gymcarry.dao;

import com.project.gymcarry.carry.CarryDto;
<<<<<<< HEAD
=======
import com.project.gymcarry.carry.CarryJoinDto;
>>>>>>> origin/E3
import com.project.gymcarry.member.MemberDto;
import com.project.gymcarry.member.SessionDto;

public interface MemberDao {
	
	// 멤버 로그인
	SessionDto memberLogin(String id, String pw);
	// 멤버 회원가입
	int insertMember(MemberDto memberDto);
	// 케리회원가입
	int insertCarry(CarryDto carryDto);
	// 케리로그인
	SessionDto carryLogin(String id, String pw);
}
