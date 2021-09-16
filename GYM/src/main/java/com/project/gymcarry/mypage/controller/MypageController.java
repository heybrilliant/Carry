package com.project.gymcarry.mypage.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.gymcarry.carry.CarryListDto;
import com.project.gymcarry.carry.CarryReviewDto;
import com.project.gymcarry.member.SessionDto;
import com.project.gymcarry.mypage.MypageDto;
import com.project.gymcarry.mypage.MypageDto2;
import com.project.gymcarry.mypage.service.MypageService;

@Controller
@RequestMapping("/mypage/mypage")
public class MypageController {

	@Autowired
	private MypageService mypService;

	@GetMapping
	public String regFor(HttpSession session, Model model, MypageDto2 mypdto) {

		SessionDto sdt = (SessionDto) session.getAttribute("loginSession");

		// 현재 날짜 구하기
		LocalDate now = LocalDate.now();
		// 포맷 정의
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
		// 포맷 적용
		String formatedNow = now.format(formatter);

		System.out.println(formatedNow);
		System.out.println(sdt.getMemidx());

		List<MypageDto2> list2 = mypService.loadMemo2(sdt.getMemidx(), formatedNow);

		System.out.println(list2);
		model.addAttribute("list2", list2);

		session.setAttribute("memidx", sdt.getMemidx());
		session.setAttribute("name", sdt.getMemname());
		System.out.println("세션 -> " + sdt + "-> 마이페이지 진입");

		return "/mypage/mypage";
	}

	// 메모 등록
	@PostMapping
	public String addMembermemo(MypageDto mypdto, Model model) {

		String arg0 = mypdto.getMemidx();
		String arg1 = mypdto.getInfodate();
		String arg2 = mypdto.getInfotype();

		List<MypageDto> list1 = mypService.selectMemo(arg0, arg1, arg2);

		if (list1.isEmpty()) {
			mypService.memberMemo(mypdto);
			System.out.println("인설트로 가쟈");
			List<MypageDto> list2 = mypService.loadMemo(arg0, arg1);
			model.addAttribute("list2", list2);
			return "mypage/mypage";

		} else {
			mypService.updateMemo(mypdto);
			System.out.println("업데이트 가쟈");
			List<MypageDto> list2 = mypService.loadMemo(arg0, arg1);
			System.out.println(list2);
			return "mypage/mypage";
		}

	}

}