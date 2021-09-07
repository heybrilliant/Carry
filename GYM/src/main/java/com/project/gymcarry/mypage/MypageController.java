package com.project.gymcarry.mypage;

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

import com.project.gymcarry.carry.CarryReviewDto;
import com.project.gymcarry.member.SessionDto;

@Controller
@RequestMapping("/mypage/mypage")
public class MypageController {

	@Autowired
	private MypageService mypService;

	@GetMapping
	public String regFor(HttpSession session) {

		SessionDto sdt = (SessionDto) session.getAttribute("loginSession");
		session.setAttribute("name", sdt.getMemname());
		session.setAttribute("memidx", sdt.getMemidx());

		System.out.println("세션 -> " + sdt + "-> 마이페이지 진입");

		return "/mypage/mypage";
	}

	// 메모 등록
	@PostMapping
	public String addMembermemo(MypageDto mypdto) {

		System.out.println(mypdto);
		int result = mypService.memberMemo(mypdto);

		return "redirect:/mypage/mypage";
	}

}