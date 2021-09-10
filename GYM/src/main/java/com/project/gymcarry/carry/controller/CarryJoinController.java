package com.project.gymcarry.carry.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.crypto.EncryptedPrivateKeyInfo;

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

import com.project.gymcarry.carry.CarryJoinDto;
import com.project.gymcarry.member.service.JoinService;
import com.project.gymcarry.member.service.MailSenderService;
import com.project.gymcarry.member.service.memSha256;

@Controller
@RequestMapping
public class CarryJoinController {

	@Autowired
	JoinService joinservice;
	@Autowired
	private MailSenderService mailsenderservice;
	
	@GetMapping("carry/join")
	public String carryJoinForm() {
		return "carry/carryJoinForm";
	}

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping("carry/join")
	public String carryJoin(@ModelAttribute  CarryJoinDto carryDto, HttpServletRequest request, HttpServletResponse response) throws IOException {

		// 암호 확인
		System.out.println("첫번째 암호 : " + carryDto.getCrpw());
		// 비밀번호 암호화(SHA256)
		String encryPassword = memSha256.encrypt(carryDto.getCrpw());
		carryDto.setCrpw(encryPassword);
		System.out.println("두번째:" + carryDto.getCrpw());

		// 캐리 회원가입 성공
		System.out.println("캐리정보 : " + carryDto.toString());
		int result = joinservice.carryJoin(carryDto, response);
		if (result == 1) {
			System.out.println("캐리 회원가입 성공");
		}
		
		// 인증메일 보내기 메소드 
		String result2 = mailsenderservice.crsend_mail(carryDto.getCremail(), carryDto.getCrname());
		if (result2 != null) {
			System.out.println("이메일 보내기 성공");
			System.out.println("carryDto.getCremail = " + carryDto.getCremail());
		}
		
		return "redirect:/index";
	}
	
	// 이메일 중복 체크 컨트롤러 
	@PostMapping("/carryemailCheck")
	@ResponseBody
	public int emailCheck(@RequestBody String cremail) throws Exception {
		return joinservice.carryemailCheck(cremail);
	}

	@RequestMapping(value = "carry/join/cr_alterjoinkey", method = RequestMethod.POST)
	public String cr_alterjoinkey_Check(@ModelAttribute CarryJoinDto carryjoinDto) {
		mailsenderservice.cr_alterjoinkey_service(carryjoinDto.getCremail(), carryjoinDto.getJoinkey());
		System.out.println("조인키 서비스!");
		System.out.println("cremail=" + carryjoinDto.getCremail());
		System.out.println("joinkey=" + carryjoinDto.getJoinkey());

		return "redirect:/index";
	}

}
