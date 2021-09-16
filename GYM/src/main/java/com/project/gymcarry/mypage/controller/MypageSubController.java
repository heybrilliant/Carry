package com.project.gymcarry.mypage.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.gymcarry.board.Pagination;
import com.project.gymcarry.board.service.BoardService;
import com.project.gymcarry.carry.CarryListDto;

import com.project.gymcarry.member.SessionDto;
import com.project.gymcarry.mypage.MypageDto;
import com.project.gymcarry.mypage.MypageDto2;
import com.project.gymcarry.mypage.MypageMemberDto;
import com.project.gymcarry.mypage.MypagePaymentDto;
import com.project.gymcarry.mypage.service.MypageService;
import com.project.gymcarry.mypage.service.MypageSubService;

@Controller

public class MypageSubController {

	@Autowired
	private MypageSubService mypService;

	@Autowired
	private MypageService mypService2;

	@RequestMapping(value = "/mypage/myinfo")
	public String memberList(HttpSession session, Model model) throws Exception {

		SessionDto sdt = (SessionDto) session.getAttribute("loginSession");
		System.out.println("세션 변수" + sdt.getMemidx());

		List<MypageMemberDto> memberList = mypService.selectmember(sdt.getMemidx());
		System.out.println(memberList);

		model.addAttribute("memberList", memberList);

		model.addAttribute("MDTO", mypService.selectmember(sdt.getMemidx()));

		System.out.println("인포수정 페이지 진입");

		return "/mypage/myinfo";
	}

	@RequestMapping(value = "/mypage/myinfoUpdate", method = RequestMethod.POST)
	public String memberListchange(HttpSession session, MypageMemberDto MDTO) {

		SessionDto sdt = (SessionDto) session.getAttribute("loginSession");
		System.out.println("세션 변수" + sdt.getMemidx());

		mypService.memberUpdate(MDTO);

		System.out.println("인포수정");

		return "redirect:/mypage/mypage";
	}

	@PostMapping("/mypage/mymemo")
	public String info(HttpSession session, Model model, MypageDto2 mypdto) {

		SessionDto sdt = (SessionDto) session.getAttribute("loginSession");

		session.setAttribute("memidx", sdt.getMemidx());
		session.setAttribute("name", sdt.getMemname());

		// 현재 날짜 구하기
		LocalDate now = LocalDate.now();
		// 포맷 정의
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
		// 포맷 적용
		String formatedNow = now.format(formatter);

		List<MypageDto2> list2 = mypService2.loadMemo2(sdt.getMemidx(), formatedNow);

		if (list2.size() != 0) {

			for (int i = 0; i < list2.size(); i++) {
				if (list2.get(i).getInfotype().equals("food")) {
					System.out.println(i + "번째 가 푸드다!");
					System.out.println(list2.get(i).getInfocontent() + " 이거다 ! 이걸  모델에 !");
					model.addAttribute("list", list2.get(i).getInfocontent());
				} else {
					System.out.println("빈값");
				}
				if (list2.get(i).getInfotype().equals("memo")) {
					System.out.println(i + "번째 가 메모다!");
					System.out.println(list2.get(i).getInfocontent() + " 이거다 ! 이걸  모델에 !");
					model.addAttribute("list2", list2.get(i).getInfocontent());
				} else {
					System.out.println("빈값");
				}
				if (list2.get(i).getInfotype().equals("kg")) {
					System.out.println(i + "번째 가 kg다!");
					System.out.println(list2.get(i).getInfocontent() + " 이거다 ! 이걸  모델에 !");
					model.addAttribute("list3", list2.get(i).getInfocontent());
				} else {
					System.out.println("빈값");
				}
				if (list2.get(i).getInfotype().equals("photo")) {
					System.out.println(i + "번째 가 사진이다!");
					System.out.println(list2.get(i).getInfocontent() + " 이거다 ! 이걸  모델에 !");
					model.addAttribute("list4", list2.get(i).getInfocontent());
					
				} else {
					System.out.println("빈값");
					
				}
			}
		}

		return "/mypage/mymemo";
	}

	@PostMapping("/mypage/mycash")
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
		arg0.pageInfo2(page, range, listCnt, sdt.getMemidx());

		System.out.println(arg0);
		model.addAttribute("pagination", arg0);
		model.addAttribute("boardList", mypService.getBoardList(arg0));

		return "/mypage/mycommunity";
	}

}