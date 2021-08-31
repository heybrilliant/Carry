package com.project.gymcarry.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.gymcarry.carry.CarryPriceDto;
import com.project.gymcarry.carry.service.CarryInfoService;
import com.project.gymcarry.payment.PaymentDto;
import com.project.gymcarry.payment.service.PaymentService;

@Controller
@RequestMapping
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	/*

	// 결제 페이지 정보 보내기
	@PostMapping("/payment/pay")
	public String carryPrice(
			@RequestParam("cridx") int cridx,
			@RequestParam("payprice") int payprice,
			Model model
			) {
		
		System.out.println(cridx);
		PaymentDto paymentDto = paymentService.paymentPrice(cridx, payprice);
		
		
		model.addAttribute("paymentDto", paymentDto);
		
		return "payment/payment";
	}
*/
	
	
	/*
	 * @GetMapping("payment/pay") public String paymentPrice(
	 * 
	 * @RequestParam("cridx") int cridx,
	 * 
	 * @RequestParam("payprice") int payprice, Model model ) { PaymentDto
	 * paymentPrice = paymentService.getPaymentPrice(cridx, payprice);
	 * 
	 * System.out.println(paymentPrice);
	 * 
	 * model.addAttribute("payment", paymentPrice);
	 * 
	 * return "payment/payment"; }
	 */
	

	
	
}
