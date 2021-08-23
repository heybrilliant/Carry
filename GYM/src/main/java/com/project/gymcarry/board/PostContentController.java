package com.project.gymcarry.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("community/postContent")
public class PostContentController {
	
	@GetMapping
	public String matching() {
		System.out.println("글목록 진입");
		return "community/postContent";
	}
	
	
}
