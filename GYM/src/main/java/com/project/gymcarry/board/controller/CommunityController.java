package com.project.gymcarry.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/community")
public class CommunityController {

	@GetMapping("/community")
	// 실행할 메서드 만든기
	public String list() {
		System.out.println("커뮤니티 컨트롤러 진입");
		return "community/community";
	}


}
