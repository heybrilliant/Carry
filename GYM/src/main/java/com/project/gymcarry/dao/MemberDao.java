package com.project.gymcarry.dao;

import org.apache.ibatis.annotations.Param;

import com.project.gymcarry.carry.CarryDto;
import com.project.gymcarry.carry.CarryJoinDto;
import com.project.gymcarry.member.MemberDto;
import com.project.gymcarry.member.SessionDto;

public interface MemberDao {
	
	// 멤버 로그인
	SessionDto memberLogin(String id, String pw);
	// 캐리로그인
	SessionDto carryLogin(String id, String pw);
	
	// 멤버 회원가입
	int insertMember(MemberDto memberDto);
	// 캐리회원가입
	int insertCarry(CarryJoinDto carryDto);

	// 멤버 회원가입시 이메일,닉네임 중복 체크
	int memberemailCheck(String mememail);
	int memberNickCheck(String memnick);

	// 캐리 회원가입시 이메일, 닉네임 중복 체크
	int carryemailCheck(String cremail);
	int carryNickCheck(String crNick);
	
	// 멤버 회원가입 이메일 인증
	int GetJoinkey(String mememail, String joinkey_status);
	// 캐리 회원가입 이메일 인증 
	int cr_GetJoinkey(String cremail, String joinkey_status);
	
	// 멤버 인증키 변경 
	int alterjoinkey(String mememail, String joinkey);
	// 캐리 인증키 변경 
	int cr_alterjoinkey(String cremail, String joinkey);
	
	// 멤버 로그인시 joinkey_status 확인
	public MemberDto memberjoinkeycheck(String id, String pw);
	// 캐리 로그인시 joinkey_status 확인
	public CarryDto carryjoinkeycheck(String id, String pw);
	
	// 멤버 아이디 찾기
	public String findmemberid(@Param("memname") String memname, @Param("memphone") String memphone);
	// 캐리 아이디 찾기
	public String findcarryid(@Param("crname") String crname, @Param("crphone") String crphone);
	
	// 멤버 비밀번호 찾기 
	public String findPassword(@Param("memname") String memname,@Param("mememail") String mememail);
	
	// 멤버 비밀번호 찾기(임시발급)
	int setpassword(String mempw, String memname, String mememail);

	
}