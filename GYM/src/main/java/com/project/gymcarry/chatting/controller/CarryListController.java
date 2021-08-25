package com.project.gymcarry.chatting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.gymcarry.carry.CarryAllDto;
import com.project.gymcarry.chatting.service.MatchingListService;

@Controller
public class CarryListController {
	
	@Autowired
	private MatchingListService matchingListService;
	
	@GetMapping("chatting/carryLists")
	public String chatRoomList(CarryAllDto carryDto, Model model) {
		List<CarryAllDto> list = matchingListService.getCarryList();
		System.out.println(list);
		model.addAttribute("carryList", list);
		return "chatting/carryList";
	}
	
}
