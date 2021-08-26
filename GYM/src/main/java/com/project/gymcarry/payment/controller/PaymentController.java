package com.project.gymcarry.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.gymcarry.carry.CarryPriceDto;
import com.project.gymcarry.carry.service.CarryInfoService;
import com.project.gymcarry.payment.PaymentDto;
import com.project.gymcarry.payment.service.PaymentService;

@Controller
@RequestMapping("payment/pay")
public class PaymentController {

	@Autowired
	private CarryInfoService carryInfoService;
	PaymentService paymentService;

	// 결제 페이지
	@GetMapping
	public String carryDetail(@RequestParam("cridx") int cridx, Model model) {
		
		CarryPriceDto carryPrice = carryInfoService.getCarryPrice(cridx);
		System.out.println(carryPrice);
		model.addAttribute("carryPrice", carryPrice);
		
		return "payment/payment";
	}
	
	@PostMapping
	public String savePayment(PaymentDto paymentDto) {
		System.out.println(paymentDto);
		int result = paymentService.savePayment(paymentDto);
		if(result == 1) {
			System.out.println("결제정보 저장 완료");
		}
		return "/payment/paymentComplete";
	}

}
