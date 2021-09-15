package com.project.gymcarry.member.service;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gymcarry.carry.CarryJoinDto;
import com.project.gymcarry.dao.MemberDao;
import com.project.gymcarry.member.MemberDto;
import com.project.gymcarry.member.MemberJoinDto;

@Service
public class JoinService {
	
	@Autowired
	private SqlSessionTemplate template;

	private MemberDao dao;

	// 멤버 이메일 중복 검사
	public int memberemailCheck(String mememail) throws Exception {
		dao = template.getMapper(MemberDao.class);
		return dao.memberemailCheck(mememail);
	}

	// 캐리 이메일 중복 검사
	public int carryemailCheck(String cremail) throws Exception {
		dao = template.getMapper(MemberDao.class);
		return dao.memberemailCheck(cremail);
	}

	// 멤버 회원가입
	public int memberJoin(MemberJoinDto memberJoinDto, HttpServletResponse response, HttpServletRequest request) throws Exception {
		dao = template.getMapper(MemberDao.class);
		int result = 0;
		File newFile = null;
		
		MemberDto meberDto = memberJoinDto.getMemberDto();
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		if (dao.memberemailCheck(memberJoinDto.getMememail()) == 1) {
			out.println("<script>");
			out.println("alert('사용 중인 이메일 입니다. 다른 이메일을 사용해주세요.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return result;
			
		} else {
			
			// 파일객체에 경로 지정!
			File newDir = new File(request.getSession().getServletContext().getRealPath("/uploadfile"));
			if (!newDir.exists()) {
				newDir.mkdir();
			}
			
			// db에 저장할 파일이름 !!!!!!!!
			String newFileName = memberJoinDto.getMemphoto().getOriginalFilename();
			
			// 파일객체에 경로와 중복제거한 이름 저장(newDir:경로 , newFileName:저장파일이름)!!!!
			newFile = new File(newDir, newFileName);
			
			// 파일 joinDto 저장
			memberJoinDto.getMemphoto().transferTo(newFile);
			
			// 파일 이름을  memberDto 저장! 
			meberDto.setMemphoto(newFileName);
			
			return dao.insertMember(meberDto);
		}
	}

	// 캐리 회원가입
	public int carryJoin(CarryJoinDto carryDto, HttpServletResponse response) throws IOException {
		dao = template.getMapper(MemberDao.class);

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		if (dao.carryemailCheck(carryDto.getCremail()) == 1) {
			out.println("<script>");
			out.println("alert('사용 중인 이메일 입니다. 다른 이메일을 사용해주세요.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return 0;
		} else {
			return dao.insertCarry(carryDto);
		}
	}

	public int alterjoinkey(MemberDto memberDto) {
		return template.update("alterjoinkey");
	}

}