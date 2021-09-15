package com.project.gymcarry.find;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.gymcarry.find.service.FindPassword;

//@RequestMapping(value="/findpassword", method=RequestMethod.GET)
//public String findPWForm(HttpSession session) {
//	System.out.println("컨트롤러 : 패스워드찾기 페이지 진입");
//		
//	return "find/findpassword";
//}