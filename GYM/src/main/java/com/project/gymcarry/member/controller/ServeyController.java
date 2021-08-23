package com.project.gymcarry.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServeyController {
	
	// 설문조사 나열  
	@GetMapping("survey/servey")
	public String survey1() {
		return "survey/surveyForm1";
	}
	
	@GetMapping("survey/servey2")
	public String survey2() {
		return "survey/surveyForm2";
	}
	
	@GetMapping("survey/servey3")
	public String survey3() {
		return "survey/surveyForm3";
	}
	
	@GetMapping("survey/servey4")
	public String survey4() {
		return "survey/surveyForm4";
	}
	
	@GetMapping("survey/servey5")
	public String survey5() {
		return "survey/surveyForm5";
	}
}
