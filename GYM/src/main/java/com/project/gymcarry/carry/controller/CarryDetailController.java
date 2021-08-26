package com.project.gymcarry.carry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.gymcarry.carry.CarryCertiDto;
import com.project.gymcarry.carry.CarryDto;
import com.project.gymcarry.carry.CarryPriceDto;
import com.project.gymcarry.carry.CarryReviewDto;
import com.project.gymcarry.carry.service.CarryInfoService;
import com.project.gymcarry.place.PlaceDto;

@Controller
public class CarryDetailController {

	@Autowired
	private CarryInfoService carryInfoService;

	// 캐리 상세 페이지
	@GetMapping("/carry/detail")
	public String carryDetail(@RequestParam("cridx") int cridx, Model model) {
		
		CarryDto carryDetail = carryInfoService.getCarryDetail(cridx);
		List<CarryReviewDto> carryReviewList = carryInfoService.getCarryReviewList(cridx);
		CarryPriceDto carryPrice = carryInfoService.getCarryPrice(cridx);
		CarryCertiDto carryCerti = carryInfoService.getCarryCerti(cridx);
		PlaceDto carryPlaceInfo = carryInfoService.getCarryPlaceInfo(cridx);
		
		System.out.println("캐리IDX:" + cridx + " => 상세페이지로 진입");
		System.out.println(carryReviewList);
		System.out.println(carryPrice);
		System.out.println(carryCerti);
		System.out.println(carryPlaceInfo);
		
		model.addAttribute("carryDetail", carryDetail);
		model.addAttribute("carryReviewList", carryReviewList);
		model.addAttribute("carryPrice", carryPrice);
		model.addAttribute("carryCerti", carryCerti);
		model.addAttribute("carryPlaceInfo", carryPlaceInfo);
		
		return "carry/carryDetail";	
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
