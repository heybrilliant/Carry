package com.project.gymcarry.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.gymcarry.admin.AdminSessionDto;
import com.project.gymcarry.admin.service.adminService;
import com.project.gymcarry.carry.CarryListDto2;
import com.project.gymcarry.member.MemberListDto;

@Controller
@RequestMapping
public class adminController {

		@Autowired
		private adminService adminService;
		
		
		@GetMapping("admin/adminLogin")
		public String loginForm() {
			System.out.println("관리자 로그인 페이지 진입");
			return "admin/adminLogin";
		}
		
		
		// 관리자 로그인
		@PostMapping("admin/login")
		public String adminLogin(
				@RequestParam("adminid") String id,
				@RequestParam("adminpw") String pw,
				HttpServletRequest request,
				HttpServletResponse response,
				HttpSession session
				) throws IOException {
			
			AdminSessionDto adminSessionDto = adminService.adminLogin(id, pw);
			if (adminSessionDto != null) {
				
				session.setAttribute("loginSession", adminSessionDto);
				System.out.println("관리자 로그인 완료 : 세션 저장");
				
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('관리자 로그인 완료');");
				out.println("location.href='/gym/admin/member';</script>");
				out.close();
				
				return "";
				// return "redirect:/admin/member";
				
			} else {
				
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('아이디 혹은 비밀번호가 일치하지 않습니다.');");
				out.println("location.href='/gym/admin/adminLogin';</script>");
				out.close();
				
				return "";
			}
		} 
		
		
		// 로그아웃 세션 삭제
		@GetMapping("admin/logout")
		public String adminLogout(
				HttpServletRequest request,
				HttpServletResponse response) throws IOException {
			HttpSession session = request.getSession();
			session.invalidate();
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('관리자 계정이 로그아웃 되었습니다.');");
			out.println("location.href='/gym/admin/adminLogin';</script>");
			out.close();
			
			System.out.println("관리자 로그아웃 완료 : 세션 소멸");
			return "";
		}

		
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
			
			adminService.deleteMemberReview(memidx);
			adminService.deleteMemberChatRoom(memidx);
			adminService.deleteMemberChatList(memidx);
			adminService.deleteMemberPayment(memidx);
			adminService.deleteMemberBodyInfo(memidx);
			adminService.deleteMemberLikeList(memidx);
			adminService.deleteMember(memidx);
		
			return "redirect:/admin/member";
		}
		
		
		// 캐리 탈퇴 처리
		@GetMapping("admin/deleteCarry")
		public String carryDelete(
				@RequestParam("cridx") int cridx,
				Model model) {
			
			adminService.deleteCarryReview(cridx);
			adminService.deleteCarryChatRoom(cridx);
			adminService.deleteCarryChatList(cridx);
			adminService.deleteCarryPayment(cridx);
			adminService.deleteCarryCerti(cridx);
			adminService.deleteCarryPrice(cridx);
			adminService.deleteCarryLikeList(cridx);
			adminService.deleteCarry(cridx);
			
			return "redirect:/admin/carry";
		}
		
	
}
