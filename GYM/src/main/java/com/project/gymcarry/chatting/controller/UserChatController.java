package com.project.gymcarry.chatting.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.gymcarry.chatting.ChatListDto;
import com.project.gymcarry.chatting.ChatRoomDto;
import com.project.gymcarry.chatting.service.MatchingChatRoomService;
import com.project.gymcarry.chatting.service.MatchingListService;
import com.project.gymcarry.member.SessionDto;

@Controller
public class UserChatController {
	
	@Autowired
	private MatchingListService matchingListService;
	
	@Autowired
	private MatchingChatRoomService matchingChatRoomService; 
	
	@GetMapping("chatting/chat")
	public String chatList() {
		return "chatting/userChat";
	}
	
	// 채팅 룸 생성 및 중복
	@GetMapping("chatting/chatInquire")
	public String chatInquire(
			@RequestParam("cridx") int cridx, 
			@RequestParam("memidx") int memidx,
			Model model
			) {
		// 캐리와의 중복룸이 있는지 확인하기위한 list
		// 수정하자
		List<ChatListDto> list = matchingChatRoomService.getByChatRoom(cridx);
		// 캐리닉네임으로 방이 있으면 생성하지않고 채팅으로 이동
		for (int i = 0; i < list.size(); i++) {
			if(cridx == list.get(i).getCridx()) {
				return "redirect:/chatting/chatList";
			}
		}
		// 캐리와의 중복 방이없을경우 채팅방생성
		int result = matchingChatRoomService.getAddChatRoom(cridx, memidx);
		model.addAttribute("result", result);
		if(result == 1) {
			System.out.println(cridx + "carry채팅방생성");
		}
		return "redirect:/chatting/chatList";
	}
	
	// 채팅룸 리스트
	@GetMapping("chatting/chatList")
	public String matching(Model model,HttpSession session) {
		SessionDto dto = (SessionDto) session.getAttribute("member");
		List<ChatListDto> list = matchingListService.getChatList(dto.getMemidx());
		model.addAttribute("chatList", list);
		List<ChatListDto> lists = matchingListService.getChatLists(dto.getCridx());
		model.addAttribute("carryChatList", lists);
		return "chatting/userChat";
	}	
	
	// 채팅 대화리스트
	@GetMapping("chatting/dochat")
	@ResponseBody
	public List<ChatRoomDto> chatList(@RequestParam("chatidx") int chatidx, Model model) {
		List<ChatRoomDto> chatList = matchingListService.getChatIdx(chatidx);
		model.addAttribute("chatidx", chatidx);
		return chatList;
	}
	

	
	
	
}
