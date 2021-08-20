package com.project.gymcarry.chatroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatTestController {
	
	@Autowired
	private ChatTestService testService;
	
	@RequestMapping("/tests/tests")
	public String getList(Model model) {
		
		List<Chat> list = testService.getChatList();
		System.out.println(list);
		model.addAttribute("testList", list);
		return "test/test";
	}
	
}
