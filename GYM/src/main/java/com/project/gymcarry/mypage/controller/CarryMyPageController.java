package com.project.gymcarry.mypage.controller;

import javax.servlet.http.HttpSession;

import com.project.gymcarry.carry.CarryDto;
import com.project.gymcarry.dao.CarryMyPageDao;
import com.project.gymcarry.mypage.CarryMyPageDto;
import com.project.gymcarry.mypage.CarryMyPageDto2;
import com.project.gymcarry.mypage.service.CarryMyPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.gymcarry.member.SessionDto;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarryMyPageController {

	@Autowired
	private CarryMyPageService service;

	@GetMapping("/mypage/carrymypage")
	public String carryMyPage(HttpSession session,Model model) {

		SessionDto sdt = (SessionDto) session.getAttribute("loginSession");

		session.setAttribute("cridx", sdt.getCridx());
		session.setAttribute("name", sdt.getCrname());
		System.out.println("세션 -> " + sdt + "-> 마이페이지 진입");
		
		
		return "/mypage/carrymypage/carrymypage";
	}

	// 캐리 정보 수정
	@GetMapping("/mypage/carrymodify")
	public String updateCarryModifyView() throws Exception{

		return "/mypage/carrymypage/modifycarryinfo";
	}

	@PostMapping("/mypage/update")
	public String updateCarryModify(CarryMyPageDto2 carryDto, @RequestParam("proprice1") int proprice1
			, @RequestParam("proprice2") int proprice2, @RequestParam("proprice3") int proprice3,
									@RequestParam("proprice4") int proprice4,
									@RequestParam("cridx") int cridx,
									HttpSession session) throws Exception {

		service.updateCarryModify(carryDto);
		service.updateCarryPrice(proprice1, proprice2, proprice3, proprice4);
		System.out.println(carryDto.getCridx());
		return "/mypage/carrymypage";
	}

	
	// 캐리 기본 정보 수정
	@GetMapping("/modify")
	public String carryBasicModify(Model model) {
		return "/mypage/carrymypage/modifycarrybasicinfo";
	}



	
	
	// 내 회원 리스트
	@GetMapping("/mymember")
	public String myMemberList(Model model) {
		return "/mypage/carrymypage/carry_mymemberlist";
	}
	

}