package com.project.gymcarry.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.gymcarry.member.MemberDto;
import com.project.gymcarry.member.service.JoinService;

@Controller
@RequestMapping("member/join")
public class JoinController {
	
	@Autowired
	JoinService joinservice;
	
	@GetMapping
	public String memberJoinForm() {
		return "member/joinForm";
	}
	
	@PostMapping
	public String memberJoin(MemberDto memberDto, HttpSession session) {
		int result = joinservice.memberJoin(memberDto);
		if(result == 1) {
			System.out.println("멤버회원가입성공");
		}
		return "redirect:/member/login";
	}
	
}
