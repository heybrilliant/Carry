package com.project.gymcarry.carry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.gymcarry.member.service.LoginService;

@Controller
public class CarryLoginController {
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/carry/login")
	public String carryLoginForm() {
		return "member/carryLoginForm";
	}
	
	// 로그인 세션 저장
	@PostMapping("/carry/carryLogin")
	public String carryLogin(
			@RequestParam("crid") String id, 
			@RequestParam("crpw") String pw,
			HttpServletRequest request,
			Model model) {
		System.out.println(id + pw);
		HttpSession session = request.getSession();
		session.setAttribute("id", id);

		boolean loginChk = loginService.carryLogin(id, pw);

		if (loginChk == true) {
			return "redirect:/index";
		} else {
			return "carry/loginForm";
		}
	}
	
	// 로그아웃 세션 삭제
	@GetMapping("carry/logOut")
	public String carryLogOut(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/index";
	}
}
