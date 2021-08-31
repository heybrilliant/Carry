package com.project.gymcarry.place.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("place/pilates")
public class PlacePilatesListController {
	
	@GetMapping
	public String matching() {
		return "place/placePilatesListNaver";
	}
	
	
}
