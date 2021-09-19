package com.project.gymcarry.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.gymcarry.member.MemberDto;
import com.project.gymcarry.member.SessionDto;
import com.project.gymcarry.member.service.LoginService;
import com.project.gymcarry.member.service.memSha256;


@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@GetMapping("member/login")
	public String loginForm() {
		return "member/loginForm";
	}

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	// 로그인 세션 저장
	@PostMapping("/member/memberLogin")
	public String login(
			@RequestParam("mememail") String id, 
			@RequestParam("mempw") String pw,
			MemberDto memberjoinkeycheck,
			SessionDto memberLogin,
			HttpServletRequest request, 
			HttpServletResponse response, 
			HttpSession session) throws IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		System.out.println("멤버 로그인 프로세스 입장>>");
		String password = memSha256.encrypt(pw);
		System.out.println(password);
		MemberDto memberDto = loginService.memberjoinkeycheck(id, password);
		
		if(memberDto != null) {
			
			if(memberDto.getJoinkey_status().equals("1")) {
				
				SessionDto sessionDto = new SessionDto();
				sessionDto.setMemidx(memberDto.getMemidx());
				sessionDto.setMemname(memberDto.getMemname());
				sessionDto.setMemnick(memberDto.getMemnick());
				String chatNick = sessionDto.getMemnick();
				
				out.println("<script>");
				out.println("alert('로그인 되었습니다!'); location.href='/gym/index';");
				out.println("</script>");
				out.close();
			
				System.out.println("로그인 성공");
				session.setAttribute("loginSession", sessionDto);
				session.setAttribute("chatSession", chatNick);
				
				System.out.println("sessionDto : " + sessionDto);
				System.out.println("chatNick : " + chatNick);
				
				return "redirect:/index"; 
				
			} else {
				
				out.println("<script>");
				out.println("alert('[!] 이메일 인증 후 로그인해주세요.');");
				out.println("history.go(-1);");
				out.println("</script>");
				out.close();
				System.out.println("이메일 미인증 상태!");  
			}
			
		} else {
			
			out.println("<script>");
			out.println("alert('[!] 이메일 혹은 비밀번호를 확인해주세요.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			System.out.println("입력 오류 상태!"); 
			
		}
		
		return "redirect:/index";
	}
		

	// 로그아웃 세션 삭제
	@GetMapping("member/logOut")
	public String memberLogOut(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		System.out.println("로그아웃");
		return "redirect:/index";
	}
	
	
	@PostMapping("member/kakaologin")
	@ResponseBody
	public int memberKakaoLogin(MemberDto memberDto, HttpSession session) {
		SessionDto sessionDto = loginService.memberLoginCheck(memberDto.getMemnick());
		String chatNick = sessionDto.getMemnick();
		int result = 0;
		if(!sessionDto.getMemnick().equals(memberDto.getMemnick())) {
			result = loginService.insertKaKaoJoin(memberDto);
		} else {
			result = 2;
		}
		session.setAttribute("loginSession", sessionDto);
		session.setAttribute("chatSession", chatNick);
		return result;
	}
	
	@GetMapping("member/snsjoin")
	public String snsJoinForm() {
		return "member/SNSjoinForm";
	}


}
