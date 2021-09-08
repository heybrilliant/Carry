package com.project.gymcarry.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.gymcarry.board.BoardDto;
import com.project.gymcarry.board.service.CommunityService;

@Controller
@RequestMapping
public class PostContentController {
	
	@Autowired
	private CommunityService communityService;
	
	@GetMapping("community/postContent")
	public String boardDetail(
			@RequestParam("postidx") int postidx,
			Model model
			) {
		BoardDto boardDetail = communityService.getBoardDetail(postidx);
		model.addAttribute("boardDetail", boardDetail);
		
		System.out.println("게시판 상세 진입" + boardDetail.toString());
		
		return "community/postContent";
	}
	
	
	@GetMapping("community/delete")
	public String deleteBoard(@RequestParam("postidx") int postidx) {
		
		communityService.getDeleteBoard(postidx);
		
		return "redirect:/community/boardlist";
	}
	
	
	
	
}
