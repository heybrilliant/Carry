package com.project.gymcarry.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.gymcarry.board.BoardDto;
import com.project.gymcarry.board.service.CommunityService;

@Controller
@RequestMapping
public class CommunityController {
	
	@Autowired
	private CommunityService communityService;


	// 게시글 전체 출력
	@GetMapping("community/boardlist")
	public String allCommunityList(Model model) {
		List<BoardDto> boardList = communityService.getBoardList();
		model.addAttribute("boardList", boardList);

		System.out.println("게시판 전체 출력");
		System.out.println(boardList.toString());

		return "community/community";
	}
	
	
}
