package com.project.gymcarry.carry;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("carry/detail")
public class CarryDetailController {
	
	@GetMapping
	public String matching() {
		return "carry/carryDetail";
	}
	
	
}
