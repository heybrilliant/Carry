package com.project.gymcarry.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.gymcarry.member.MemberDto;
import com.project.gymcarry.member.service.JoinService;
import com.project.gymcarry.member.service.MailSenderService;
import com.project.gymcarry.member.service.memSha256;

@Controller
@RequestMapping
public class JoinController {

	@Autowired
	JoinService joinservice;
	@Autowired
	private MailSenderService mailsenderservice;

	@GetMapping("member/join")
	public String memberJoinForm() {
		return "member/joinForm";
	}

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@PostMapping("member/join")
	public String memberJoin(@ModelAttribute MemberDto memberDto, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// 암호 확인
		System.out.println("첫번째 암호 : " + memberDto.getMempw());
		// 비밀번호 암호화(SHA256)
		String encryPassword = memSha256.encrypt(memberDto.getMempw());
		memberDto.setMempw(encryPassword);
		System.out.println("두번째 : " + memberDto.getMempw());

		// 멤버 회원가입 성공
		System.out.println("입력 정보 : " + memberDto.toString());
		int result = joinservice.memberJoin(memberDto, response);
		if (result == 1) {
			System.out.println("멤버 회원가입 성공");
		}

		// 인증메일 보내기 메소드
		String result2 = mailsenderservice.send_mail(memberDto.getMememail(), memberDto.getMemname());
		if (result2 != null) {
			System.out.println("이메일 보내기 성공");
			System.out.println("memberDto.getMememail = " + memberDto.getMememail());
		}

		return "redirect:/index";
	}

	// 이메일 중복 체크 컨트롤러
	@PostMapping("/memberemailCheck")
	@ResponseBody
	public int emailCheck(@RequestBody String mememail) throws Exception {
		return joinservice.memberemailCheck(mememail);
	}

	@RequestMapping(value = "member/join/alterjoinkey", method = RequestMethod.POST)
	public String alterjoinkey_Check(@ModelAttribute MemberDto memberDto) {
		mailsenderservice.alterjoinkey_service(memberDto.getMememail(), memberDto.getJoinkey());
		System.out.println("조인키 서비스!");
		System.out.println("mememail=" + memberDto.getMememail());
		System.out.println("joinkey=" + memberDto.getJoinkey());

		return "redirect:/index";
	}
}

