package com.project.gymcarry.chatting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.gymcarry.chatting.ChatListDto;
import com.project.gymcarry.chatting.ChatRoomDto;
import com.project.gymcarry.chatting.service.ChatListService;

@Controller
public class UserChatController {
	
	@Autowired
	private ChatListService chatListService;
	
	@RequestMapping("chatting/chat")
	public String matching(ChatListDto chatListDto, Model model) {
		List<ChatListDto> list = chatListService.getChatList();
		model.addAttribute("chatList", list);
		return "chatting/userChat";
	}
	
	@GetMapping("chatting/dochat")
	@ResponseBody
	public List<ChatRoomDto> chatList(@RequestParam("chatidx") int chatidx) {
		System.out.println(chatidx);
		List<ChatRoomDto> chatList = chatListService.getChatIdx(chatidx);
		System.out.println(chatList);
		return chatList;
	}
	
	
}
