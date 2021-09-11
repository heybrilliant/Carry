package com.project.gymcarry.admin.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.gymcarry.admin.AllSalesDto;
import com.project.gymcarry.admin.DashTableAddDto;
import com.project.gymcarry.admin.DashTableDto;
import com.project.gymcarry.admin.service.AdminDashBoardService;

@Controller
public class AdminDashBoardController {
	
	@Autowired
	private AdminDashBoardService adminDashBoardService;

	// 대쉬보드 페이지로 이동
	@GetMapping("admin/dashboard")
	public String getAllDashTable(Model model) {
		List<DashTableDto> list = adminDashBoardService.getAllDasghTable();
		model.addAttribute("allDashTable", list);
		SimpleDateFormat format = new SimpleDateFormat("MM");
		Date time = new Date();
		String date = format.format(time);
		model.addAttribute("date", date);
		return "admin/dashboard";
	}

	// 전체매출 디폴트
	@GetMapping("admin/allSales")
	public String getAllSalesDash() {
		return "admin/dashAllSales";
	}

	// 대쉬보드 전체매출
	@GetMapping("/admin/allSaleMan")
	@ResponseBody
	public Map<String, Object> allSalesDash(@RequestParam("month") int month) {
		List<AllSalesDto> list = adminDashBoardService.getAllSales(month);
		List<AllSalesDto> monthList = adminDashBoardService.getMonthSales();
		List<AllSalesDto> dayList = adminDashBoardService.getDaySales(month);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("kingSales", list);
		map.put("monthSales", monthList);
		map.put("daySales", dayList);
		return map;
	}

	@GetMapping("/admin/dash")
	@ResponseBody
	public Map<String, Object> getDashBoard() {
		List<AllSalesDto> monthList = adminDashBoardService.getMonthSales();
		List<AllSalesDto> rankList = adminDashBoardService.getMonthRank();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("monthDash", monthList);
		map.put("rankDash", rankList);
		return map;
	}
	
	@GetMapping("/admin/daylist")
	@ResponseBody
	public List<DashTableAddDto> getDayList(@RequestParam("month") int month){
		List<DashTableAddDto> list = adminDashBoardService.getDayTable(month);
		return list;
	}
	

	

}
