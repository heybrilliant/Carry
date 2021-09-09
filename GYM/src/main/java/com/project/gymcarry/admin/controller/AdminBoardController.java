package com.project.gymcarry.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.gymcarry.admin.AdminBoardDto;
import com.project.gymcarry.admin.TermNoticeDto;
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
		
		
		
		
		
		/* FOOTER 연결 */
		
		
		// 게시글 페이지 출력
		@GetMapping("content/term")
		public String termNoticeContent(
				@RequestParam("idx") int idx,
				Model model
				) {
			
			TermNoticeDto term = adminBoardService.termNoticeView(idx);
			
			System.out.println("게시글 출력");
			
			model.addAttribute("term", term);
			
			
			return "content/termContent";
		}
		
		
		// [약관 및 정책] 카테고리 게시판 리스트 출력
		@GetMapping("content/termlist")
		public String termBoardList(Model model) {
			
			List<AdminBoardDto> termBoardList = adminBoardService.termBoardList();
			model.addAttribute("termList", termBoardList);
			
			System.out.println(termBoardList);
			System.out.println("[약관 및 정책] 게시판 리스트 출력");
			
			return "content/termBoardList";
		}
		
		
		// [공지사항] 카테고리 게시판 리스트 출력
		@GetMapping("content/Noticelist")
		public String noticeBoardList(Model model) {

			List<AdminBoardDto> noticeBoardList = adminBoardService.noticeBoardList();
			model.addAttribute("noticeList", noticeBoardList);
			
			System.out.println(noticeBoardList);
			System.out.println("[공지사항] 게시판 리스트 출력");

			return "content/noticeBoardList";
		}
		
		
		
}
