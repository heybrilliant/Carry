package com.project.gymcarry.payment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.gymcarry.payment.PaymentDto;

@Controller
public class PaymentCompleteController {

	@GetMapping("payment/complete")
	public String savePayment() {
		return "payment/paymentComplete";
	}

}
