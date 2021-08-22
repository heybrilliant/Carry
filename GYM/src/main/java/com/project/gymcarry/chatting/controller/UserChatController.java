package com.project.gymcarry.chatting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.gymcarry.chatting.ChatListDto;
import com.project.gymcarry.chatting.ChatRoomDto;
import com.project.gymcarry.chatting.service.ChatListService;

@Controller
@RequestMapping("chatting/chat")
public class UserChatController {
	
	@Autowired
	private ChatListService chatListService;
	
	@GetMapping
	public String matching(
			ChatListDto chatListDto,
			Model model
			) {
		List<ChatListDto> list = chatListService.getChatList();
		model.addAttribute("chatList", list);
		return "chatting/userChat";
	}
	
	@GetMapping("/chat/d/{chatidx}")
	public List<ChatRoomDto> chatList(
			@PathVariable("chatidx") int chatidx
			) {
		List<ChatRoomDto> chatList = chatListService.getChatIdx(chatidx);
		return chatList;
	}
	
}
