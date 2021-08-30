package com.project.gymcarry.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.gymcarry.payment.PaymentDto;
import com.project.gymcarry.payment.service.PaymentService;

@Controller
@RequestMapping
public class PaymentCompleteController {
	
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping("payment/complete")
	public String savePayment(PaymentDto paymentDto) {
		
		int result = paymentService.SavePayment(paymentDto);
		if(result == 1) {
			System.out.println("결제 정보 저장 완료");
		}
		return "payment/paymentComplete";
	}
	

}
