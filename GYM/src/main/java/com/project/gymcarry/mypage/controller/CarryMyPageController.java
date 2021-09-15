package com.project.gymcarry.mypage.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.gymcarry.member.SessionDto;

@Controller
@RequestMapping("/mypage/carrymypage")
public class CarryMyPageController {

	@GetMapping
	public String carryMyPage(HttpSession session,Model model) {

		SessionDto sdt = (SessionDto) session.getAttribute("loginSession");

		session.setAttribute("cridx", sdt.getCridx());
		session.setAttribute("name", sdt.getCrname());
		System.out.println("세션 -> " + sdt + "-> 마이페이지 진입");
		
		
		return "/mypage/carrymypage/carrymypage";
	}

	
	// 캐리 정보 수정
	@GetMapping("/modify")
	public String carryModify(Model model) {
		return "/mypage/carrymypage/modifycarryinfo";
	}

	
	// 캐리 기본 정보 수정
	@GetMapping("/basicmodify")
	public String carryBasicModify(Model model) {
		return "/mypage/carrymypage/modifycarrybasicinfo";
	}
	
	

}