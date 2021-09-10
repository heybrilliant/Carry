package com.project.gymcarry.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.gymcarry.admin.service.AdminDashBoardService;

@Controller
public class AdminDashBoardController {

	@Autowired
	private AdminDashBoardService adminDashBoardService;
	
	// 대쉬보드 페이지로 이동
	@GetMapping("admin/dashboard")
	public String dashboard() {
		return "admin/dashboard";
	}
	
	// 대쉬보드 전체매출
	@GetMapping("/admin/allSales")
	public String allSalesDash() {
		//List<AllSales> list = adminDashBoardService.getAllSales();
		return "admin/dashAllSales";
	}

}
