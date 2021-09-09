package com.project.gymcarry.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.gymcarry.admin.AdminBoardDto;
import com.project.gymcarry.admin.ContentDto;
import com.project.gymcarry.admin.service.AdminBoardService;

@Controller
@RequestMapping
public class AdminBoardController {

		@Autowired
		private AdminBoardService adminBoardService;
	
	
		// 관리자 게시판 리스트 페이지로 이동
		@GetMapping("admin/board/list")
		public String adminBoardList(Model model) {
			
			List<AdminBoardDto> AdminBoardList = adminBoardService.AdminBoardList();
			model.addAttribute("BoardList", AdminBoardList);
			
			return "admin/adminBoard";
		}
		
		
		// 관리자 게시판 : 게시글 작성 페이지로 이동
		@GetMapping("admin/board/writeForm")
		public String noticeBoardWrite() {
			return "admin/adminBoardWrite";
		}
		
		
		// 관리자 게시판 : 게시글 작성
		@PostMapping("admin/board/write")
		public void writeAdminBoard(
				AdminBoardDto adminBoardDto,
				Model model
				) {
			
			int result = adminBoardService.writeAdminBoard(adminBoardDto);
			
			if(result == 1) {
				System.out.println("관리자 게시판 작성 완료");
			}
		}
		
		
		// 관리자 게시판 : 게시글 수정 페이지로 이동
		@GetMapping("admin/board/modifyForm")
		public String ContentModifyForm(
				@RequestParam("idx") int idx,
				Model model
				) {
			
			AdminBoardDto original = adminBoardService.getContentOriginal(idx);
			model.addAttribute("original", original);
			
			System.out.println("관리자 게시판 수정 페이지 진입 - 게시글 번호 " + idx);
			
			return "admin/contentModifyForm";
		}
		
		
		// 게시글 수정
		@PostMapping("admin/board/modify")
		@ResponseBody
		public String ContentModify(
				AdminBoardDto adminBoardDto,
				@RequestParam("idx") int idx,
				Model model
				) {
			
			adminBoardService.updateContent(adminBoardDto);
			System.out.println("게시글 수정 완료");
			
			return "admin/adminBoard";
		}
		
		
		// 게시글 삭제
		@GetMapping("admin/board/delete")
		public void deleteContent(
				@RequestParam("idx") int idx,
				Model model
				) {
			
			adminBoardService.deleteContent(idx);
			System.out.println(idx + "번 게시글 삭제 완료");
		}
		

		
		
		
		
		/* FOOTER 연결 */

		
		// [약관 및 정책] 카테고리 게시판 리스트 출력
		@GetMapping("content/termlist")
		public String termBoardList(Model model) {
			
			List<AdminBoardDto> termBoardList = adminBoardService.termBoardList();

			model.addAttribute("list", termBoardList);
			
			
			System.out.println("[약관 및 정책] 게시판 리스트 출력");
			
			return "content/termBoardList";
		}
		
		
		// [공지사항] 카테고리 게시판 리스트 출력
		@GetMapping("content/noticelist")
		public String noticeBoardList(Model model) {

			List<AdminBoardDto> noticeBoardList = adminBoardService.noticeBoardList();
			model.addAttribute("noticeList", noticeBoardList);
			
			System.out.println("[공지사항] 게시판 리스트 출력");

			return "content/noticeBoardList";
		}
		
		
		// 게시글 페이지 출력
		@GetMapping("content")
		public String contentView (
				@RequestParam("idx") int idx,
				Model model
				) {
			
			ContentDto con = adminBoardService.contentView(idx);
			model.addAttribute("content", con);

			System.out.println("게시글 출력");
			
			return "content/content";
		}
		
		
		
}
