package com.project.gymcarry.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.gymcarry.member.MemberDto;
import com.project.gymcarry.member.service.JoinService;
import com.project.gymcarry.member.service.MailSenderService;

@Controller
@RequestMapping("member/join")
public class JoinController {

	@Autowired
	JoinService joinservice;
	@Autowired
	private MailSenderService mailsenderservice;

	@GetMapping
	public String memberJoinForm() {
		return "member/joinForm";
	}

	@PostMapping
	public String memberJoin(@ModelAttribute MemberDto memberDto, HttpServletRequest request, HttpServletResponse response) throws IOException {

		// 멤버 회원가입 성공
		System.out.println("입력 정보 : " + memberDto.toString());
		int result = joinservice.memberJoin(memberDto);
		if (result == 1) {
			System.out.println("멤버 회원가입 성공");
		}

		// 인증메일 보내기 메소드
		String result2 = mailsenderservice.send_mail(memberDto.getMememail(), memberDto.getMemname());
		if (result2 != null) {
			System.out.println("이메일 보내기 성공");
			System.out.println("memberDto.getMememail = "+ memberDto.getMememail());
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println();
		
		return "redirect:/index";
	}

	@RequestMapping(value = "/alterjoinkey", method = RequestMethod.POST)
	public String alterjoinkey_Check(@ModelAttribute MemberDto memberDto) {
		mailsenderservice.alterjoinkey_service(memberDto.getMememail(), memberDto.getJoinkey());
		System.out.println("조인키 서비스!");
		System.out.println("mememail=" + memberDto.getMememail());
		System.out.println("joinkey=" + memberDto.getJoinkey());
		
		
		return "redirect:/index";

	}

}

//@RequestMapping(value = "/alterjoinkey", method = RequestMethod.POST)
//public void alterjoinkey(MemberDto memberDto, HttpServletResponse response) {
//	joinservice.alterjoinkey(memberDto);
//}

//model.addAttribute("msg", "회원가입 인증 이메일이 발송되었습니다!<br>이메일을 확인해주세요."); 
//model.addAttribute("url", "/member/join"); 

//	// DB에 기본정보 insert
//	joinservice.memberJoin(memberDto);
//
//	// 임의 조인키 생성 + 이메일 발송
//	String joinkey = mailsenderservice.send_mail(memberDto);
//	memberDto.setJoinkey(joinkey);
//
//	Map<String, String> map = new HashMap<String, String>();
//	map.put("mememail", memberDto.getMememail());
//	map.put("joinkey", memberDto.getJoinkey());
//	System.out.println(map);
//
//	// DB에 authKey 업데이트
//	joinservice.updatecreate_joinkey(map);

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
