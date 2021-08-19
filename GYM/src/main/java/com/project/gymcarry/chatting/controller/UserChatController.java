package com.project.gymcarry.chatting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("chatting/chat")
public class UserChatController {
	
	@GetMapping
	public String matching() {
		System.out.println("채팅 진입");
		return "chatting/userChat";
	}
	
	
}
