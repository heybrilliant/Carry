package com.project.gymcarry.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String memberJoin(@ModelAttribute MemberDto memberDto) {
		System.out.println("입력 정보 : "+ memberDto.toString());
		int result = joinservice.memberJoin(memberDto);
		if (result == 1) {
			System.out.println("멤버 회원가입 성공");
		}
		return "redirect:/member/login";
	}

	// 이메일 중복 체크 컨트롤러
//	@RequestMapping(value = "/member/emailCheck", method = RequestMethod.GET)
//	@ResponseBody
//	public int emailCheck(@RequestParam("mememail") String mememail) {
//		if(emailCheck(mememail) == 1) {
//			System.out.println("이메일 중복");
//		} else {
//			System.out.println("노중복");
//		}
//		return joinservice.memEmailCheck(mememail);
//	}
	
}
