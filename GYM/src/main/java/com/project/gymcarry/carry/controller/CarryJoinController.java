package com.project.gymcarry.carry.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.gymcarry.carry.CarryInfoDto;
import com.project.gymcarry.carry.CarryJoinDto;
import com.project.gymcarry.carry.CarryToInfoDto;
import com.project.gymcarry.carry.CarryToJoinDto;
import com.project.gymcarry.member.service.JoinService;
import com.project.gymcarry.member.service.MailSenderService;
import com.project.gymcarry.member.service.memSha256;

@Controller
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
	@ResponseBody
	public String carryJoin(
				@ModelAttribute CarryToJoinDto carryDto, 
				HttpServletRequest request, 
				HttpServletResponse response, 
				@RequestParam("cridx") String cridx) throws Exception {

		// 암호 확인
		System.out.println("첫번째 암호 : " + carryDto.getCrpw());
		// 비밀번호 암호화(SHA256)
		String encryPassword = memSha256.encrypt(carryDto.getCrpw());
		carryDto.setCrpw(encryPassword);
		System.out.println("두번째:" + carryDto.getCrpw());

		// 캐리 회원가입 성공
		System.out.println("캐리정보 : " + carryDto.toString());
		int result = joinservice.carryJoin(carryDto, response, request);
		if (result == 1) {
			System.out.println("캐리 회원가입 성공");
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 인증메일 보내기 메소드 
		String result2 = mailsenderservice.crsend_mail(carryDto.getCremail(), carryDto.getCrname());
		if (result2 != null) {
			System.out.println("이메일 보내기 성공");
			System.out.println("carryDto.getCremail = " + carryDto.getCremail());
		}

		out.println("<script>");
		out.println("alert('\n입력하신 메일주소의 인증메일을 확인해주세요!');");
		out.println("</script>");
		out.close();
		
		return "redirect:/index";
	}
	
	
	
	// 추가 캐리정보 입력 페이지로 이동
	@GetMapping("carry/join2")
	public String carryJoin2Form(@RequestParam("cridx") int cridx) {
		return "carry/carryMoreJoinForm";
	}

	
	// 추가 캐리정보 인서트
	@PostMapping("carry/join2")
	@ResponseBody
	public void carryJoin2(
				CarryToInfoDto carryToInfoDto,
				CarryInfoDto carryInfoDto,
				@RequestParam("proprice1") int proprice1, 
				@RequestParam("proprice2") int proprice2,
				@RequestParam("proprice3") int proprice3, 
				@RequestParam("proprice4") int proprice4,
				@RequestParam("cridx") int cridx
				) {
		
			int result = joinservice.insertCarryInfo(carryToInfoDto);
			int result2 = joinservice.insertCarryPrice(proprice1, proprice2, proprice3, proprice4, carryToInfoDto.getCridx());
			int result3 = joinservice.insertCarryCerti(carryInfoDto);
			
			
			if(result == 1 && result2 == 1 && result3 == 1) {
				System.out.println("캐리 추가 정보 입력 완료");
			}
		
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
