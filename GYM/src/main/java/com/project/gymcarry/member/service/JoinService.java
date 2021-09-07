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
	
	
	// 멤버 회원가입
	public int memberJoin(MemberDto memberDto) {
		dao = template.getMapper(MemberDao.class);
		return dao.insertMember(memberDto);
		}
	
	// 캐리 회원가입
	public int carryJoin(CarryJoinDto carryDto) {
		dao = template.getMapper(MemberDao.class);
		return dao.insertCarry(carryDto);
	}
	
	
	public int alterjoinkey(MemberDto memberDto) {
		return template.update("alterjoinkey");
	}
	

	
	

	
}