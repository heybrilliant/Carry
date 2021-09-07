package com.project.gymcarry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class IndexController {

	@RequestMapping("/index")
	public void index(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.invalidate();
		System.out.println("관리자 로그아웃 : 세션 강제 소멸");
	}

	@RequestMapping("/")
	public String index1() {
		System.out.println("/ 진입");
		return "redirect:/index";
	}

}
