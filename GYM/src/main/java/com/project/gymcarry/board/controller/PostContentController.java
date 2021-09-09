package com.project.gymcarry.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
	public String boardDetail(@RequestParam("postidx") int postidx, Model model) {
		BoardDto boardDetail = communityService.getBoardDetail(postidx);
		model.addAttribute("boardDetail", boardDetail);

		
		 List<CommentDto> commList = commentService.getCommList(postidx);
		 model.addAttribute("commList", commList); 
		 
		

		System.out.println("게시판 상세 진입" + boardDetail.toString());

		return "community/postContent";
	}

	// 게시물 삭제
	@GetMapping("community/delete")
	public String deleteBoard(@RequestParam("postidx") int postidx) {

		communityService.getDeleteBoard(postidx);

		return "redirect:/community/boardlist";
	}

	// 댓글 등록
	@PostMapping("/insertComm")
	@ResponseBody
	public int insertComm(HttpServletRequest request) {
		int result = 0;

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("postidx", request.getParameter("postidx"));
		map.put("commentnick", request.getParameter("membernick"));
		map.put("commentcontent", request.getParameter("commContent"));

		try {
			result = commentService.insertComm(map);
		} catch (Exception e) {
			e.printStackTrace();
			result = -1;
		}
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/selectReplyList", produces = "application/json; charset=utf-8")
	public String selectReplyList(int postidx, Model model) {

		// ajax에서 에러를 처리해줌으로
		// try catch를 안해줘도됨(다른방법도 있음)
		List<CommentDto> commList = commentService.getCommList(postidx);

		model.addAttribute("commCount", commList.size());
		
		// JSON으로 담아도 되지만 편한 방법인 GSON으로 사용

		// yyyy-MM-dd hh:mm:ss
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

		return gson.toJson(commList);
	}

}
