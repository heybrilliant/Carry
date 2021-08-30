package com.project.gymcarry.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gymcarry.carry.CarryJoinDto;
import com.project.gymcarry.dao.MemberDao;
import com.project.gymcarry.member.MemberDto;

@Service
public class LoginService {
	
	@Autowired
	private SqlSessionTemplate template;
	
	private MemberDao dao;
	
	public MemberDto memberLogin(String id, String pw) {
		dao = template.getMapper(MemberDao.class);
		return dao.login(id, pw);
	}
	
	public MemberDto carryLogin(String id, String pw) {
		dao = template.getMapper(MemberDao.class);
		return dao.carryLogin(id, pw);
	}
	
	
	
}
