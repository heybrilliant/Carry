package com.project.gymcarry.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/mypage/mypage")
public class MypagetController {

	@RequestMapping(method = RequestMethod.GET)
	public String regForm() {
		System.out.println("마이페이지 진입");
		return "/mypage/mypage";
	}
}