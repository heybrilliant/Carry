package com.project.gymcarry.carry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.gymcarry.carry.CarryAllDto;
import com.project.gymcarry.carry.CarryReviewDto;
import com.project.gymcarry.carry.service.CarryInfoService;

@Controller
public class CarryDetailController {

	@Autowired
	private CarryInfoService carryInfoService;

	@GetMapping("/carry/detail")
	public String carryDetail(@RequestParam("cridx") int cridx, Model model) {
		CarryAllDto carryDetail = carryInfoService.getCarryDetail(cridx);
		List<CarryReviewDto> carryReviewList = carryInfoService.getCarryReviewList(cridx);
		System.out.println("캐리IDX:" + cridx + " => 상세페이지로 진입");
		model.addAttribute("carryDetail", carryDetail);
		model.addAttribute("carryReviewList", carryReviewList);

		return "carry/carryDetail";
	}

	@GetMapping("carry/reviewwrite")
	@ResponseBody
	public String carryReview(@RequestParam("reviewcontent") String reviewcontent) {
		System.out.println(reviewcontent);
		return null;
	}

}
