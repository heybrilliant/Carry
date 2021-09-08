package com.project.gymcarry.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.gymcarry.board.BoardDto;
import com.project.gymcarry.board.comment.CommentDto;
import com.project.gymcarry.board.comment.service.CommentService;
import com.project.gymcarry.board.service.CommunityService;

@Controller
@RequestMapping
public class PostContentController {
	
	@Autowired
	private CommunityService communityService;
	@Autowired
	private CommentService commentService;
	
	// 게시판 상세 페이지 
	@GetMapping("community/postContent")
	public String boardDetail(
			@RequestParam("postidx") int postidx,
			Model model
			) {
		BoardDto boardDetail = communityService.getBoardDetail(postidx);
		model.addAttribute("boardDetail", boardDetail);
		
		List<CommentDto> commList = commentService.getCommList(postidx);
		model.addAttribute("commList", commList);
		model.addAttribute("commCount", commList.size());
		
		System.out.println("게시판 상세 진입" + boardDetail.toString());
		
		return "community/postContent";
	}
	
	// 게시물 삭제
	@GetMapping("community/delete")
	public String deleteBoard(@RequestParam("postidx") int postidx) {
		
		communityService.getDeleteBoard(postidx);
		
		return "redirect:/community/boardlist";
	}
	
	
	
	
}
