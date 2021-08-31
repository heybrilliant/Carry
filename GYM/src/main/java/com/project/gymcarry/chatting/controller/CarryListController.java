package com.project.gymcarry.chatting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.gymcarry.carry.CarryDto;
import com.project.gymcarry.chatting.service.MatchingListService;

@Controller
@RequestMapping("chatting/carryLists")
public class CarryListController {

	@Autowired
	private MatchingListService matchingListService;

	@GetMapping
	public String chatRoomList(Model model) {
		List<CarryDto> list = matchingListService.getCarryList();
		model.addAttribute("carryList", list);
		return "carry/carryList";
	}

}
