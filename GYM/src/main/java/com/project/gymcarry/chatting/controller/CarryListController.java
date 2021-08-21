package com.project.gymcarry.chatting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("chatting/carryLists")
public class CarryListController {

	@GetMapping
	public String chatRoomList(
			) {
		return "chatting/carryList";
	}
	
}
