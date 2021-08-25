package com.project.gymcarry.chatting.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.gymcarry.chatting.ChatListDto;
import com.project.gymcarry.chatting.ChatRoomDto;
import com.project.gymcarry.chatting.service.MatchingAddChatRoomService;
import com.project.gymcarry.chatting.service.MatchingListService;

@Controller
public class UserChatController {
	
	@Autowired
	private MatchingListService matchingListService;
	
	@Autowired
	private MatchingAddChatRoomService matchingAddChatRoomService; 
	
	@GetMapping("chatting/chat")
	public String chatList() {
		return "chatting/userChat";
	}
	
	// 채팅 룸 생성 및 중복
	@PostMapping("chatting/chatInquire")
	public String chatInquire(
			@RequestParam("cridx") int cridx, 
			@RequestParam("memidx") int memidx) {
		// 캐리와의 중복룸이 있는지 확인하기위한 list
		List<ChatListDto> list = matchingAddChatRoomService.getByChatRoom(cridx);
		// 캐리닉네임으로 방이 있으면 생성하지않고 채팅으로 이동
		for (int i = 0; i < list.size(); i++) {
			if(cridx == list.get(i).getCridx()) {
				return "redirect:/chatting/chatList";
			}
		}
		// 캐리와의 중복 방이없을경우 채팅방생성
		int result = matchingAddChatRoomService.getAddChatRoom(cridx, memidx);
		if(result == 1) {
			System.out.println(cridx + "carry채팅방생성");
		}
		return "chatting/userChat";
	}
	
	// 채팅룸 리스트
	@GetMapping("chatting/chatList")
	public String matching(ChatListDto chatListDto, Model model) {
		List<ChatListDto> list = matchingListService.getChatList();
		model.addAttribute("chatList", list);
		return "chatting/userChat";
	}	
	
	// 채팅 대화리스트
	@GetMapping("chatting/dochat")
	@ResponseBody
	public List<ChatRoomDto> chatList(@RequestParam("chatidx") int chatidx) {
		System.out.println(chatidx);
		List<ChatRoomDto> chatList = matchingListService.getChatIdx(chatidx);
		System.out.println(chatList);
		return chatList;
	}
	
	
}
