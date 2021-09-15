package com.project.gymcarry.mypage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.gymcarry.board.Pagination;
import com.project.gymcarry.board.service.BoardService;
import com.project.gymcarry.carry.CarryListDto;

import com.project.gymcarry.member.SessionDto;
import com.project.gymcarry.mypage.MypageMemberDto;
import com.project.gymcarry.mypage.MypagePaymentDto;
import com.project.gymcarry.mypage.service.MypageSubService;

@Controller

public class MypageSubController {

	@Autowired
	private MypageSubService mypService;

	@RequestMapping(value = "/mypage/myinfo")
	public String memberList(HttpSession session, Model model) throws Exception {

		SessionDto sdt = (SessionDto) session.getAttribute("loginSession");
		System.out.println("세션 변수" + sdt.getMemidx());

		List<MypageMemberDto> memberList = mypService.selectmember(sdt.getMemidx());
		System.out.println(memberList);

		model.addAttribute("memberList", memberList);

		System.out.println("인포수정 페이지 진입");

		return "/mypage/myinfo";
	}

	@PostMapping(value = "/mypage/myinfoUpdate")
	public String memberListchange(HttpSession session, MypageMemberDto memberList
			) {

		SessionDto sdt = (SessionDto) session.getAttribute("loginSession");
		System.out.println("세션 변수" + sdt.getMemidx());

		mypService.memberUpdate(sdt.getMemidx());

		System.out.println("인포수정");

		return "/mypage/myinfo";
	}

	@GetMapping("/mypage/mymemo")
	public String info(HttpSession session, Model model) {

		System.out.println("/ 진입");

		return "/mypage/mymemo";
	}

	@GetMapping("/mypage/mycash")
	public String cash(HttpSession session, Model model) {

		SessionDto sdt = (SessionDto) session.getAttribute("loginSession");
		session.setAttribute("memidx", sdt.getMemidx());
		List<MypagePaymentDto> paymentList = mypService.selectpayment(sdt.getMemidx());
		System.out.println(paymentList);
		model.addAttribute("paymentList", paymentList);
		System.out.println("/ 진입");

		return "/mypage/mycash";
	}

	// 전체 캐리 리스트 출력 (nav - 1:1 MATCHING 클릭시 이동)
	@GetMapping("/mypage/mycarry")
	public String allCarryList(HttpSession session, Model model) {

		SessionDto sdt = (SessionDto) session.getAttribute("loginSession");
		session.setAttribute("memidx", sdt.getMemidx());
		List<CarryListDto> alist = mypService.getMyCarryList(sdt.getMemidx());
		model.addAttribute("allList", alist);

		System.out.println("좋아요 캐리 리스트 출력");

		return "/mypage/mycarry";
	}

	@RequestMapping("mypage/mycommunity")
	public String regForm(HttpSession session, Model model,
			@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "1") int range) throws Exception {

		SessionDto sdt = (SessionDto) session.getAttribute("loginSession");
		System.out.println("세션 변수" + sdt.getMemidx());
		session.setAttribute("idx", sdt.getMemidx());

		int listCnt = mypService.getBoardListCnt(sdt.getMemidx());

		int memidx = sdt.getMemidx();
		// Pagination 객체 생성
		Pagination arg0 = new Pagination();
		arg0.pageInfo2(page, range, listCnt,sdt.getMemidx());
		
		System.out.println(arg0);
		model.addAttribute("pagination", arg0);
		model.addAttribute("boardList", mypService.getBoardList(arg0));

		return "/mypage/mycommunity";
	}

}