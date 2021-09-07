package com.project.gymcarry.place.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.gymcarry.place.PlaceDto;
import com.project.gymcarry.place.service.PlaceHealthService;

@Controller
@RequestMapping
public class PlaceDetailController {
	
	@Autowired
	private PlaceHealthService placeHealthService;
	
	// 플레이스 상세 페이지
	@GetMapping("/place/detail")
	public String placeDetail(
				@RequestParam("placeidx") int placeidx,
				Model model
			) {
		PlaceDto placeDetail = placeHealthService.getHealthPlaceInfo(placeidx);
		System.out.println("placeidx : " + placeidx);
		
		model.addAttribute("placeDetail", placeDetail);
		
		return "place/placeDetail";
	}
	
	// 플레이스 검색 후 상세 페이지
	// @RequestMapping(value = "/searchDetail", produces = "application/text; charset=UTF-8", method = RequestMethod.POST)
	@PostMapping("/place/detail/search")
	@ResponseBody
	public String placeSearchDetail(
				@RequestParam("placename") String placename,
				Model model
			) {
		PlaceDto placeSearchDetail = placeHealthService.getSearchPlaceInfo(placename);
		System.out.println("placename : " + placename);
		System.out.println(placeSearchDetail.toString());
		model.addAttribute("placeSearchDetail", placeSearchDetail);
		
		return "place/placeDetail";
	}
	
	
}