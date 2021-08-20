package com.project.gymcarry.place;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("place/detail")
public class PlaceDetailController {
	
	@GetMapping
	public String matching() {
		return "place/placeDetail";
	}
	
	
}
