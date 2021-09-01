package com.project.gymcarry.find;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.gymcarry.find.service.FindId;

@Controller
@RequestMapping("find/findid")
public class FindIdController {

	@Autowired
	private FindId findid;

	@GetMapping
	public String findid() {
		return "find/findid";
	}
}
