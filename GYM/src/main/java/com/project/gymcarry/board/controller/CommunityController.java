package com.project.gymcarry.board.controller;

import com.project.gymcarry.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("community/community")
public class CommunityController {
	@Autowired		// 주입(심부름꾼) 명시
	private BoardService service;	// Service 호출을 위한 객체생성

	@RequestMapping(value = "community/community", method = )

}
