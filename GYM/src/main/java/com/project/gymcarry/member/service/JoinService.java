package com.project.gymcarry.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gymcarry.carry.CarryJoinDto;
import com.project.gymcarry.dao.MemberDao;
import com.project.gymcarry.member.MemberDto;
@Service
public class JoinService {
	
	@Autowired
	private SqlSessionTemplate template;
	
	private MemberDao dao;
	
	public int memberJoin(MemberDto memberDto) {
		dao = template.getMapper(MemberDao.class);
		return dao.insertMember(memberDto);
	}
	
	public int carryJoin(CarryJoinDto carryDto) {
		dao = template.getMapper(MemberDao.class);
		return dao.insertCarry(carryDto);
	}

	
}
