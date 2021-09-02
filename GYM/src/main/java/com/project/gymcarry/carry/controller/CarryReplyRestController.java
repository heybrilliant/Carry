package com.project.gymcarry.carry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.gymcarry.carry.CarryReviewDto;
import com.project.gymcarry.carry.service.CarryInfoService;

@RestController
public class CarryReplyRestController {

	@Autowired
	private CarryInfoService carryInfoService;

	// 캐리 리뷰 리스트 출력
	@PostMapping("/carry/review")
	public List<CarryReviewDto> reviewList(int cridx) {
		
		List<CarryReviewDto> carryReviewList = carryInfoService.getCarryReviewList(cridx);
		
		return carryReviewList;
	}

}
