package com.project.gymcarry.carry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.gymcarry.carry.CarryDto;
import com.project.gymcarry.carry.CarryReviewDto;
import com.project.gymcarry.carry.service.CarryInfoService;

@Controller
public class CarryDetailController {

	@Autowired
	private CarryInfoService carryInfoService;

	// 캐리 상세 페이지
	@GetMapping("/carry/detail")
	public String carryDetail(@RequestParam("cridx") int cridx, Model model) {
		CarryDto carryDetail = carryInfoService.getCarryDetail(cridx);
		List<CarryReviewDto> carryReviewList = carryInfoService.getCarryReviewList(cridx);
		System.out.println("캐리IDX:" + cridx + " => 상세페이지로 진입");
		System.out.println(carryReviewList);
		model.addAttribute("carryDetail", carryDetail);
		model.addAttribute("carryReviewList", carryReviewList);

		return "carry/carryDetail";	
	}
	

	// 캐리 수업 결제 페이지
	@GetMapping("/payment/payment")
	public String payment(
			@RequestParam("cridx") int cridx,
			Model model) {
		CarryDto payment = carryInfoService.getCarryDetail(cridx);
		System.out.println("캐리IDX:" + cridx + " => 결제페이지로 진입");
		model.addAttribute("payment", payment);
		return "payment/payment";
	}

	
	
/*
	@GetMapping("carry/reviewwrite")
	@ResponseBody
	public String carryReview(
			@RequestParam("reviewcontent") String reviewcontent
			) {
		CarryReviewDto carryReview = writeReviewService.writeReveiw(memidx);
		System.out.println(carryReview);
		return null;
	}
*/
	
	

}
