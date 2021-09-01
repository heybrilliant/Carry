package com.project.gymcarry.mypage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.gymcarry.member.SessionDto;

@Controller

public class MypageController {

	@RequestMapping("/mypage/mypage")
	public String regForm(HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession();
		SessionDto sdt = (SessionDto) session.getAttribute("loginSession");

		System.out.println("세션 변수" + sdt.getMemidx());
		System.out.println("세션 변수" + sdt.getMemname());
		System.out.println("세션 변수" + sdt.getMemnick());

		session.setAttribute("name", sdt.getMemname());

		System.out.println("마이페이지 진입");

		return "/mypage/mypage";
	}

	@GetMapping("/mypage/info")
	public String info() {
		System.out.println("/ 진입");
		return "/mypage/info";
	}

	@GetMapping("/mypage/mycash")
	public String cash() {
		System.out.println("/ 진입");
		return "/mypage/mycash";
	}

}