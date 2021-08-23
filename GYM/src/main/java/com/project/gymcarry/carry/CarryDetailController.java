package com.project.gymcarry.carry;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("carry/detail")
public class CarryDetailController {
	
	/*
	@RequestMapping("carry/detail")
	@CrossOrigin
	public Carry getCarry(
			@PathVariable("crIDX") int crIDX
			) {
		Carry carry = restService.getCarry(crIDX);
		System.out.println(carry);
		return carry;
	
	}
	*/

	
	@GetMapping
	public String matching() {
		System.out.println("캐리 상세페이지 진입");
		return "carry/carryDetail";
	}
	
	
}
