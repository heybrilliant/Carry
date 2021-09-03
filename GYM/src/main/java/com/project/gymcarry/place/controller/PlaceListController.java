package com.project.gymcarry.place.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/place/list")
public class PlaceListController {
	
	@GetMapping
	public String matching() {
		System.out.println("place 전체 진입");
		return "/place/placeList";
	}
	
	
}