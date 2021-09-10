package com.project.gymcarry.member.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

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

	// 이메일 중복 검사
		public int memberemailCheck(String mememail) throws Exception{
			dao = template.getMapper(MemberDao.class);
			return dao.memberemailCheck(mememail);
		}
	
	// 멤버 회원가입
	public int memberJoin(MemberDto memberDto, HttpServletResponse response) throws Exception {
		dao = template.getMapper(MemberDao.class);

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		if (dao.memberemailCheck(memberDto.getMememail()) == 1) {
			out.println("<script>");
			out.println("alert('사용 중인 이메일 입니다. 다른 이메일을 사용해주세요.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return 0;
		} else {
			return dao.insertMember(memberDto);
		}
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