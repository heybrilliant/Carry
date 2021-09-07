package com.project.gymcarry.board.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.gymcarry.board.service.CommunityService;

@Controller
@RequestMapping
public class CommWriteController {
	
	@Autowired
	private CommunityService communityService;
	
	@GetMapping("community/write")
	public String writeView() {
		System.out.println("글쓰기 진입");
		return "community/commWrite";
	}
	
	// 글 작성
	@PostMapping("community/write")
	public String boardWrite(HttpServletRequest request, HttpSession session) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("postname", request.getParameter("postname"));
		map.put("postcontent", request.getParameter("postcontent"));
		map.put("postnick", request.getParameter("postnick"));
		map.put("memidx", request.getParameter("memidx"));
		map.put("boardcategory", request.getParameter("boardcategory"));
		
		System.out.println(map.toString());
		communityService.getBoardWrite(map);
		
		return "redirect:/community/community";
	}
	

	
	
}
