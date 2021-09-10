package com.project.gymcarry.videochat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class videoChatController {

	// 화상 채팅 페이지
	@GetMapping("/videochat/chat")
	public String carryDetail() {
		return "videochat/videoChat";
	}

		
}
