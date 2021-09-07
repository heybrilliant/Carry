package com.project.gymcarry.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gymcarry.dao.MemberDao;
import com.project.gymcarry.member.SessionDto;

@Service
public class LoginService {
	
	@Autowired
	private SqlSessionTemplate template;
	
	private MemberDao dao;
	
	public SessionDto memberLogin(String id, String pw) {
		dao = template.getMapper(MemberDao.class);
		return dao.memberLogin(id, pw);
	}
	
	public SessionDto carryLogin(String id, String pw) {
		dao = template.getMapper(MemberDao.class);
		return dao.carryLogin(id, pw);
	}
	
	
	
}
