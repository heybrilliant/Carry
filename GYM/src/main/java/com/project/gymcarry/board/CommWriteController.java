package com.project.gymcarry.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("community/write")
public class CommWriteController {
	
	@GetMapping
	public String matching() {
		System.out.println("글쓰기 진입");
		return "community/commWrite";
	}
	
	
}
