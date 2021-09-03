package com.project.gymcarry.mypage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.gymcarry.member.MemberDto;


@Controller
@RequestMapping("/mypage/mypage")
public class MypageController {

	@RequestMapping(method = RequestMethod.GET)
	public String regForm(HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession();
		MemberDto memDto = (MemberDto) session.getAttribute("member");

		System.out.println("세션 변수" + memDto.getMemname());

		session.setAttribute("name", memDto.getMemname());
		session.setAttribute("idx", memDto.getMemidx());
		System.out.println("마이페이지 진입");

		return "/mypage/mypage";
	}

	// Mypage 클릭시
	// 세션 없을 때 -> 로그인 후 이용해주세요
	// Member세션 -> 멤버 마이페이지 이동
	// Carry세션 -> 캐리 마이페이지 이동

}
