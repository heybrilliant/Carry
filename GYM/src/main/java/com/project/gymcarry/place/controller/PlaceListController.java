package com.project.gymcarry.place.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.gymcarry.place.PlaceDto;
import com.project.gymcarry.place.service.PlaceHealthService;

@Controller
@RequestMapping
public class PlaceListController {
	
	@Autowired
	private PlaceHealthService placeHealthService;
	
	// 플레이스 전체보기
	@GetMapping("/place/all")
	public String placeList(
				Model model
			) {
		List<PlaceDto> placeAll = placeHealthService.getAllPlaceList();
		model.addAttribute("placeAll", placeAll);
		
		return "place/placeList";
	}
}