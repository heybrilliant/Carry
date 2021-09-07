package com.project.gymcarry.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("community/community")
public class CommunityController {
	
	@GetMapping
	public String matching() {
		System.out.println("커뮤니티 진입");
		return "community/community";
	}
	
	
}
