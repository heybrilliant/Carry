package com.project.gymcarry.carry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.gymcarry.carry.CarryDto;
import com.project.gymcarry.carry.service.CarryInfoService;
import com.project.gymcarry.carryreview.service.CarryReviewService;

@Controller
public class CarryDetailController {

	@Autowired
	private CarryInfoService carryInfoService;
	// private CarryReviewService carryReviewService;

	@RequestMapping("/carry/detail")
	public String carryDetail(@RequestParam("crIDX") Integer crIDX, Model model) {
		CarryDto carryDetail = carryInfoService.getCarryDetail(crIDX);
		System.out.println("캐리IDX:" + crIDX + " => 상세페이지로 진입");
		System.out.println(carryDetail);
		model.addAttribute("carryDetail", carryDetail);

		return "carry/carryDetail";
	}

	
	/*
	@GetMapping("/carry/detail1")
	public String carryReviewList(
			CarryReviewDto carryReviewDto,
			@RequestParam("crIDX") Integer crIDX,
			Model model) {
		List<CarryReviewDto> carryReviewList = carryReviewService.getCarryReview(crIDX);
		System.out.println(carryReviewList);
		model.addAttribute("carryReviewList", carryReviewList);

		return "carry/carryDetail";
	}
	*/

	
}
