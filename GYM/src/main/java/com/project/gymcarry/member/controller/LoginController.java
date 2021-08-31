package com.project.gymcarry.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.gymcarry.member.MemberDto;
import com.project.gymcarry.member.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@GetMapping("member/login")
	public String loginForm() {
		return "member/loginForm";
	}

	// 로그인 세션 저장
	@PostMapping("/member/memberLogin")
	public String login(@RequestParam("mememail") String id, @RequestParam("mempw") String pw,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberDto memDto = loginService.memberLogin(id, pw);
		if (memDto != null) {
			session.setAttribute("member", memDto);
			return "redirect:/index";
		} else {
			return "member/loginForm";
		}
	}

	// 로그아웃 세션 삭제
	@GetMapping("member/logOut")
	public String logOut(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/index";
	}

}
