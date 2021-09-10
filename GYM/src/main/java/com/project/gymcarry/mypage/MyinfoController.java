package com.project.gymcarry.mypage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.gymcarry.member.MemberDto;
import com.project.gymcarry.member.SessionDto;

@Controller
@RequestMapping("/mypage/myinfo")
public class MyinfoController {

	@RequestMapping(method = RequestMethod.GET)
	public String regForm(HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession();
		SessionDto sdt = (SessionDto) session.getAttribute("loginSession");

		System.out.println("세션 변수" + sdt.getMemidx());

		session.setAttribute("idx", sdt.getMemidx());

		System.out.println("인포수정 페이지 진입");

		return "/mypage/myinfo";
	}

}