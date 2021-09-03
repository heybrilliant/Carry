package com.project.gymcarry.carry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.gymcarry.carry.CarryCertiDto;
import com.project.gymcarry.carry.CarryDto;
import com.project.gymcarry.carry.CarryPriceDto;
import com.project.gymcarry.carry.CarryReviewDto;
import com.project.gymcarry.carry.service.CarryInfoService;
import com.project.gymcarry.place.PlaceDto;

@Controller
@RequestMapping
public class CarryDetailController {

	@Autowired
	private CarryInfoService carryInfoService;

	// 캐리 상세 페이지
	@GetMapping("/carry/detail")
	public String carryDetail(
			CarryPriceDto priceDto, 
			@RequestParam("cridx") int cridx, 
			Model model
			) {

		CarryDto carryDetail = carryInfoService.getCarryDetail(cridx);
		List<CarryPriceDto> price = carryInfoService.getCarryPriceList(cridx);
		CarryCertiDto carryCerti = carryInfoService.getCarryCerti(cridx);
		PlaceDto carryPlaceInfo = carryInfoService.getCarryPlaceInfo(cridx);

		System.out.println("캐리IDX:" + cridx + " => 상세페이지로 진입");
		System.out.println(price);
		System.out.println(carryCerti);
		System.out.println(carryPlaceInfo);

		model.addAttribute("carryDetail", carryDetail);
		model.addAttribute("price", price);
		model.addAttribute("carryCerti", carryCerti);
		model.addAttribute("carryPlaceInfo", carryPlaceInfo);

		return "carry/carryDetail";
	}

	
	
	// 캐리 리뷰 등록
	@PostMapping("/carry/add")
	@ResponseBody
	public String addCarryReview(CarryReviewDto reviewDto) {
		
		System.out.println(reviewDto);
		
		int result = carryInfoService.addCarryReview(reviewDto);
		
		if (result == 1) {
			System.out.println("리뷰 등록 성공");
		}
		
		return "carry/carryDetail";
	}


	
	// 캐리 리뷰 리스트 출력
	@PostMapping("carry/list")
	@ResponseBody
	public List<CarryReviewDto> reviewList(
			Model model,
			@RequestParam("cridx") int cridx
			
			){
		
		List<CarryReviewDto> carryReviewList = carryInfoService.getCarryReviewList(cridx);
		
		return carryReviewList;
	}
	
	

/*	
	// 캐리 리뷰 리스트 출력
	@PostMapping("/carry/list")
	@ResponseBody
	public HashMap<String, Object> reviewList(
			Model model,
			@RequestParam("cridx") int cridx
			) {

		HashMap<String, Object> result = new HashMap<String, Object>();

		CarryReviewDto carryReviewDto = new CarryReviewDto();
		carryReviewDto.setCridx(cridx);

		List<CarryReviewDto> carryReviewList = carryInfoService.getCarryReviewList(cridx);

		if (carryReviewList.isEmpty()) {
			String Msg = "작성된 리뷰가 없습니다.";
			String Code = "1";

			result.put("Msg", Msg);
			result.put("Code", Code);

			return result;

		} else {
			String Msg = "성공";
			String Code = "0";

			result.put("Msg", Msg);
			result.put("Code", Code);
			result.put("data", carryReviewList);

			return result;
		}
	}
*/
	
	
	
/*
		// 캐리 리뷰 리스트 출력  (페이징처리)
		@PostMapping("/carry/list2")
		@ResponseBody
		public String reviewList2(
				Criteria cri,
				Model model, 
				@RequestParam("cridx") int cridx
				) {

			// 전체 게시글 개수
			int ReviewCnt = carryInfoService.reviewCnt();
			
			// 페이징 객체
			Paging paging = new Paging();
			paging.setCri(cri);
			paging.setTotalCount(ReviewCnt);
			// TotalCount에 SQL count(*)문을 통해 얻은 리뷰의 개수를 세팅
			
			List<Map<String, Object>> pagingReviewList = carryInfoService.pagingReviewList(cri);
			
			model.addAttribute("pagingReviewList", pagingReviewList);
			model.addAttribute("paging", paging);
			
			return "reviewList";
		}
		
*/
		
}
