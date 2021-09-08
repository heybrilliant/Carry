package com.project.gymcarry.carry.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.gymcarry.member.SessionDto;
import com.project.gymcarry.member.service.LoginService;

@Controller
public class CarryLoginController {
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/carry/login")
	public String carryLoginForm() {
		return "carry/carryLoginForm";
	}
	
	// 로그인 세션 저장
	@PostMapping("/carry/carryLogin")
	public String carryLogin(
			@RequestParam("cremail") String id, 
			@RequestParam("crpw") String pw,
			HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session
			) throws IOException {
		SessionDto sessionDto = loginService.carryLogin(id, pw);
		if (sessionDto != null) {
			session.setAttribute("loginSession", sessionDto);
			System.out.println("캐리 세션 저장");

			return "redirect:/index";
		} else {
			return "carry/loginForm";
		}
	}
	
	// 로그아웃 세션 삭제
	@GetMapping("carry/logOut")
	public String carryLogOut(
			HttpServletRequest request,
			HttpServletResponse response
			) throws IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('로그아웃 완료');</script>");
		out.flush();
		
		return "redirect:/index";
	}
}