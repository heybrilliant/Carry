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
	
	// place 리스트
	@GetMapping("/place/list")
	public String placeList(
				@RequestParam("placenum") int placenum,
				Model model
			) {
		List<PlaceDto> placeList = placeHealthService.getHealthPlaceList(placenum);
		System.out.println("placenum : " + placenum);
		
		model.addAttribute("placeList", placeList);
		
		
		return "place/placeList";
	}
	
	
}
