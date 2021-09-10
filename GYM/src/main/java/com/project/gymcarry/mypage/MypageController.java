package com.project.gymcarry.mypage;

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

		String arg0 = mypdto.getMemidx();
		String arg1 = mypdto.getInfodate();
		String arg2 = mypdto.getInfotype();

		List<MypageDto> list1 = mypService.selectMemo(arg0, arg1, arg2);

		if (list1.isEmpty()) {
			mypService.memberMemo(mypdto);
			System.out.println("인설트로 가쟈");
		} else {
			mypService.updateMemo(mypdto);
			System.out.println("업데이트 가쟈");
		}

		return "mypage/mypage";
	}

}