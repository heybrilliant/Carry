package com.project.gymcarry.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.gymcarry.admin.AdminBoardDto;
import com.project.gymcarry.admin.service.AdminBoardService;

@Controller
@RequestMapping
public class AdminBoardController {

		@Autowired
		private AdminBoardService adminBoardService;
	
	
		// 공지사항 게시판 페이지로 이동
		@GetMapping("admin/board")
		public String noticeBoard(Model model) {
			
			List<AdminBoardDto> AdminBoardList = adminBoardService.AdminBoardList();
			model.addAttribute("BoardList", AdminBoardList);
			
			System.out.println("관리자 게시판 리스트 출력");
			
			return "admin/adminBoard";
		}
		
		
}
