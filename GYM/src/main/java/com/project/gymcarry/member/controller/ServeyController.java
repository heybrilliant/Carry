package com.project.gymcarry.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member/servey")
public class ServeyController {

	@GetMapping
	public String survey() {
		System.out.println("설문조사 진입");
		return "member/surveyForm";
	}
}
