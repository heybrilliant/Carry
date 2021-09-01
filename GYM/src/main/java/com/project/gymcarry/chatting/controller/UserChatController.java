package com.project.gymcarry.chatting.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
			RedirectAttributes redirectAttributes
			) {
		// 방번호 가져오기
		ChatListDto chatDto = matchingChatRoomService.getByChatRoom(cridx, memidx);
		if(chatDto != null) {
			int chatidx = matchingChatRoomService.getByChatIdx(chatDto.getChatidx());
			if(chatidx == 1) {
				redirectAttributes.addAttribute("chatidx", chatDto.getChatidx());
				return "redirect:/chatting/chatList";
			} 
		}
		// 방이 있으면 생성하지않고 채팅으로 이동
		// 캐리와의 중복 방이없을경우 채팅방생성
		matchingChatRoomService.getAddChatRoom(cridx, memidx);
		return "redirect:/chatting/chatList";
	}
	
	// 채팅룸 리스트
	@GetMapping("chatting/chatList")
	public String matching(@RequestParam("chatidx") int chatidx,Model model,HttpSession session) {
		SessionDto dto = (SessionDto) session.getAttribute("loginSession");
		List<ChatListDto> list = matchingListService.getChatList(dto.getMemidx());
		model.addAttribute("chatList", list);
		List<ChatListDto> lists = matchingListService.getChatLists(dto.getCridx());
		model.addAttribute("carryChatList", lists);
		System.out.println(chatidx);
		ChatRoomDto chatRoomDto = matchingChatRoomService.getByChatContent(chatidx);
		model.addAttribute("chat", chatRoomDto);
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
