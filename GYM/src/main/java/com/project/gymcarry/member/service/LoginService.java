package com.project.gymcarry.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gymcarry.dao.MemberDao;
import com.project.gymcarry.member.MemberDto;
import com.project.gymcarry.member.SessionDto;

@Service
public class LoginService {
	
	@Autowired
	private SqlSessionTemplate template;
	
	private MemberDao dao;
	
	public SessionDto memberLogin(String id, String pw) {
		dao = template.getMapper(MemberDao.class);
		System.out.println("로그인 서비스 : "+id);
		System.out.println("로그인 서비스 : "+pw);
		System.out.println("로그인 서비스 : "+dao.memberLogin(id, pw));

		return dao.memberLogin(id, pw);
	}
	
	public SessionDto carryLogin(String id, String pw) {
		dao = template.getMapper(MemberDao.class);
		return dao.carryLogin(id, pw);
	}
	
	//로그인 검사 
	public MemberDto memberjoinkeycheck(String id, String pw) {
		dao = template.getMapper(MemberDao.class);
		System.out.println("LoginService 내부 조인키 : " + id);
		System.out.println("LoginService 내부 조인키 : " + pw);
		System.out.println("LoginService 내부 조인키 : " + dao.memberjoinkeycheck(id, pw));
		return dao.memberjoinkeycheck(id, pw);
	}
	
}
