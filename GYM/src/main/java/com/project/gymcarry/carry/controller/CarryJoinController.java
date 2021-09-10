package com.project.gymcarry.carry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.gymcarry.carry.CarryJoinDto;
import com.project.gymcarry.member.service.JoinService;
import com.project.gymcarry.member.service.memSha256;

@Controller
@RequestMapping("carry/join")
public class CarryJoinController {

	@Autowired
	JoinService joinservice;

	@GetMapping
	public String carryJoinForm() {
		return "carry/carryJoinForm";
	}

	@PostMapping
	public String carryJoin(@ModelAttribute CarryJoinDto carryDto) {

		// 암호 확인
		System.out.println("첫번째 암호 : " + carryDto.getCrpw());
		// 비밀번호 암호화(SHA256)
		String encryPassword = memSha256.encrypt(carryDto.getCrpw());
		carryDto.setCrpw(encryPassword);
		System.out.println("두번째:" + carryDto.getCrpw());

		System.out.println("캐리정보 : " + carryDto.toString());
		int result = joinservice.carryJoin(carryDto);
		if (result == 1) {
			System.out.println("캐리 회원가입 성공");
		}
		return "redirect:/carry/login";
	}

}
