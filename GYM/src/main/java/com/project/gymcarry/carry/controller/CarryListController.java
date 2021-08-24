package com.project.gymcarry.carry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.gymcarry.carry.CarryDto;
import com.project.gymcarry.chatting.service.MatchingListService;

@Controller
public class CarryListController {
	
	@Autowired
	private MatchingListService matchingListService;
	
	@GetMapping("chatting/carryLists")
	public String chatRoomList(CarryDto carryDto, Model model) {
		List<CarryDto> list = matchingListService.getCarryList();
		model.addAttribute("carryList", list);
		return "chatting/carryList";
	}

}
