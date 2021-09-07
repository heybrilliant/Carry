package com.project.gymcarry.dao;

import com.project.gymcarry.carry.CarryJoinDto;
import com.project.gymcarry.member.MemberDto;
import com.project.gymcarry.member.SessionDto;

public interface MemberDao {
	
	// 멤버 로그인
	SessionDto memberLogin(String id, String pw);
	// 멤버 회원가입
	int insertMember(MemberDto memberDto);
	// 캐리회원가입
	int insertCarry(CarryJoinDto carryDto);
	// 캐리로그인
	SessionDto carryLogin(String id, String pw);
	// 회원가입시 인증키 생성
	
	// 멤버 회원가입시 이메일 중복 체크
	
	// 멤버 회원가입 이메일 인증
	int GetJoinkey(String mememail, String joinkey_status);
	// 인증키 변경 
	int alterjoinkey(String mememail, String joinkey);
	// 로그인시 joinkey_status 확인
	MemberDto Memberjoinkeycheck(String id, String pw, String joinkey_status);
}