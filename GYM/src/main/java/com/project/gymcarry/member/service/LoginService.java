package com.project.gymcarry.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gymcarry.dao.MemberDao;
import com.project.gymcarry.member.MemberDto;

@Service
public class LoginService {
	
	@Autowired
	private SqlSessionTemplate template;
	
	private MemberDao dao;
	
	public boolean login(String id, String pw) {
		boolean loginChk = false;
		dao = template.getMapper(MemberDao.class);
		MemberDto member = dao.login(id, pw);
		if(member != null) {
			loginChk = true;
		}
		return loginChk;
	}
	
}
