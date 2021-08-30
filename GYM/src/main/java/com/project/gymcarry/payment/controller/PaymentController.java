package com.project.gymcarry.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.gymcarry.carry.CarryPriceDto;
import com.project.gymcarry.carry.service.CarryInfoService;

@Controller
@RequestMapping
public class PaymentController {

	@Autowired
	private CarryInfoService carryInfoService;

	// 결제 페이지 정보 출력 - 1회

	@GetMapping("/payment/pay")
	public String carryPrice(
			CarryPriceDto priceDto,
			Model model
			) {

		CarryPriceDto carryPrice = carryInfoService.getCarryPrice(priceDto);
		
		model.addAttribute("carryPrice", carryPrice);
		
		return "payment/payment";
	}
	
}
