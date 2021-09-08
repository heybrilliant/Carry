package com.project.gymcarry.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.gymcarry.admin.AdminSessionDto;
import com.project.gymcarry.admin.service.adminService;
import com.project.gymcarry.carry.CarryListDto2;
import com.project.gymcarry.member.MemberListDto;

@Controller
@RequestMapping
public class AdminSettingController {

		@Autowired
		private adminService adminService;
		
		
		// 회원 관리 : 전체 회원 리스트 출력
		@GetMapping("admin/member")
		public String memberSetting(
				HttpServletRequest request,
				HttpSession session,
				Model model) {
			
			HttpSession adminSession = request.getSession();
			AdminSessionDto adminSessionDto = (AdminSessionDto) adminSession.getAttribute("loginSession");
			session.setAttribute("idx", adminSessionDto.getAdminid());
			session.setAttribute("name", adminSessionDto.getAdminpw());
			System.out.println("세션 변수(admin) : " + adminSessionDto.getAdminid());

			List<MemberListDto> memList = adminService.allMemberList();
			model.addAttribute("memList", memList);
			
			System.out.println("회원 관리 : 전체 회원 리스트 출력");
			
			return "admin/memberSetting";
		}
		
		
		// 캐리 관리 : 전체 캐리 리스트 출력
		@GetMapping("admin/carry")
		public String carrySetting(Model model) {
			List<CarryListDto2> carryList = adminService.allCarryList();
			model.addAttribute("carryList", carryList);
			
			System.out.println("캐리 관리 : 전체 캐리 리스트 출력");
			
			return "admin/carrySetting";
		}
		
		
		// 회원 탈퇴 처리
		@GetMapping("admin/deleteMember")
		public String memberDelete(
				@RequestParam("memidx") int memidx,
				Model model) {
			
			adminService.deleteMember(memidx);
		
			return "redirect:/admin/member";
		}
		
		
		// 캐리 탈퇴 처리
		@GetMapping("admin/deleteCarry")
		public String carryDelete(
				@RequestParam("cridx") int cridx,
				Model model) {
			
			adminService.deleteCarry(cridx);
			
			return "redirect:/admin/carry";
		}
		
	
}
