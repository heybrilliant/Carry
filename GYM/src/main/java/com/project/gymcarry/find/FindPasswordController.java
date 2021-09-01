package com.project.gymcarry.find;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.gymcarry.find.service.FindPassword;

@Controller
@RequestMapping("find/findpassword")
public class FindPasswordController {

	@Autowired
	private FindPassword findpassword;
	
	@GetMapping
	public String findpassword() {
		return "find/findpassword";
	}
}
