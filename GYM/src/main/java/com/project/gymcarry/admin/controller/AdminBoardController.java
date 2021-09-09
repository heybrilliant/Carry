package com.project.gymcarry.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.gymcarry.admin.AdminBoardDto;
import com.project.gymcarry.admin.service.AdminBoardService;

@Controller
@RequestMapping
public class AdminBoardController {

		@Autowired
		private AdminBoardService adminBoardService;
	
	
		// 관리자 게시판 리스트 페이지로 이동
		@GetMapping("admin/board")
		public String noticeBoard(Model model) {
			
			List<AdminBoardDto> AdminBoardList = adminBoardService.AdminBoardList();
			model.addAttribute("BoardList", AdminBoardList);
			
			System.out.println("관리자 게시판 리스트 출력");
			
			return "admin/adminBoard";
		}
		
		
		// 관리자 게시판 작성 페이지로 이동
		@GetMapping("admin/board/writeForm")
		public String noticeBoardWrite() {
			return "admin/adminBoardWrite";
		}
		
		
		// 관리자 게시판 작성
		@PostMapping("admin/board/write")
		public void writeAdminBoard(
				AdminBoardDto adminBoardDto,
				HttpServletResponse reponse,
				Model model
				) {
			
			int result = adminBoardService.writeAdminBoard(adminBoardDto);
			
			if(result == 1) {
				System.out.println("관리자 게시판 작성 완료");
			}
			
		}
		
		
		
		
}
