package com.project.gymcarry.mypage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.gymcarry.carry.CarryJoinDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.gymcarry.carry.CarryDto;
import com.project.gymcarry.carry.CarryToJoinDto;
import com.project.gymcarry.member.SessionDto;
import com.project.gymcarry.member.service.memSha256;
import com.project.gymcarry.mypage.service.CarryMyPageService;

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

	// 캐리 정보 수정 페이지
	@GetMapping("/mypage/carrymodify")
	public String updateCarryModifyView() throws Exception{

		return "/mypage/carrymypage/modifycarryinfo";
	}

	// 캐리 정보 수정
	@PostMapping("/mypage/update")
	public String updateCarryModify(CarryDto carryDto, @RequestParam("proprice1") int proprice1
			, @RequestParam("proprice2") int proprice2, @RequestParam("proprice3") int proprice3,
									@RequestParam("proprice4") int proprice4,
									HttpSession session) throws Exception {


		service.updateCarryModify(carryDto);
		service.updateCarryPrice(proprice1, proprice2, proprice3, proprice4, carryDto.getCridx());
		
		return "/mypage/carrymypage/carrymypage";
	}


	// 캐리 기본 정보 수정
	@GetMapping("/carry/modify")
	public String carryBasicModify(HttpServletRequest request ,Model model) throws Exception {

		HttpSession session = request.getSession();
		int cridx = (int) session.getAttribute("cridx");

		CarryJoinDto carry = service.selectCarryBasicInfo(cridx);
		model.addAttribute("carry", carry);
		System.out.println(carry.toString());
		return "/mypage/carrymypage/modifycarrybasicinfo";
	}


	// 캐리 기본 정보 수정 내용 전송
	@PostMapping("/carry/modify")
	public String carryBasicInfoUpdate(@ModelAttribute CarryToJoinDto carryDto, HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 암호 확인
		System.out.println("첫번째 암호 : " + carryDto.getCrpw());
		// 비밀번호 암호화(SHA256)
		String encryPassword = memSha256.encrypt(carryDto.getCrpw());
		carryDto.setCrpw(encryPassword);
		System.out.println("두번째:" + carryDto.getCrpw());

		int result = service.updateCarryBasicInfo(carryDto, response, request);
		System.out.println(carryDto.toString());
		System.out.println("result = " + result);
		if (result == 1) {
			System.out.println("캐리 회원가입 성공");
		} else {
			System.out.println("실패");
		}

		return "/mypage/carrymypage/carrymypage";
	}

	
	// 내 회원 리스트
	@GetMapping("/mymember")
	public String myMemberList(Model model) {
		return "/mypage/carrymypage/carry_mymemberlist";
	}
	
}