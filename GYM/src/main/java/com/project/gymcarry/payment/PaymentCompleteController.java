package com.project.gymcarry.payment;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("payment/complete")
public class PaymentCompleteController {
	
	@GetMapping
	public String matching() {
		System.out.println("결제완료 페이지 진입");
		return "payment/paymentComplete";
	}
	
	
}
