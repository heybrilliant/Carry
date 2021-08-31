package com.project.gymcarry.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.gymcarry.payment.PaymentDto;
import com.project.gymcarry.payment.service.PaymentService;

@Controller
@RequestMapping
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	  @PostMapping("payment/pay")
	  public String paymentPrice(
			  @RequestParam("cridx") int cridx,
			  @RequestParam("crname") String crname,
			  @RequestParam("paynum") int paynum,
			  @RequestParam("payprice") int payprice,
			  Model model
			  ) {
		
		  model.addAttribute("cridx", cridx);
		  model.addAttribute("crname", crname);
		  model.addAttribute("paynum", paynum);
		  model.addAttribute("payprice", payprice);
	  
		  return "payment/payment";
		  
	  }
	
	  
	  @PostMapping("payment/complete")
	  public String savePayment(PaymentDto paymentDto) {
		  int result = paymentService.savePayment(paymentDto);
		  if(result == 1) {
			  	System.out.println(paymentDto + "결제 정보 저장 성공");
			}
		  return "payment/paymentComplete";
		}
	  
}

