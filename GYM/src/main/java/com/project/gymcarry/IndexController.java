package com.project.gymcarry;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	// 메인화면시작
	@RequestMapping("/index")
	public String index() {
		System.out.println("메인화면 진입");
		return "index";	
	}
	
}
