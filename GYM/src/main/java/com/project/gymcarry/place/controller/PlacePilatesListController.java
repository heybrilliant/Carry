package com.project.gymcarry.place.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.gymcarry.place.PlaceDto;
import com.project.gymcarry.place.service.PlacePilatesService;

@Controller
@RequestMapping
public class PlacePilatesListController {
	
	@Autowired
	private PlacePilatesService PlacePilatesService;

	// place 리스트 
	@GetMapping("/place/pilates")
	public String placeList (
			//@RequestParam("placenum") int placenum,
			Model model
			) {

		// 필라테스 업체 리스트
		List<PlaceDto> placePilatesList = PlacePilatesService.getPilatesPlaceList();

		model.addAttribute("placePilatesList", placePilatesList);

		return "place/placePilatesList";
	}
	
	
}