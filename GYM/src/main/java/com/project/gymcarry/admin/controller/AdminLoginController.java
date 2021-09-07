package com.project.gymcarry.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.gymcarry.admin.AdminSessionDto;
import com.project.gymcarry.admin.service.adminService;

@Controller
@RequestMapping
public class AdminLoginController {

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

	
}
