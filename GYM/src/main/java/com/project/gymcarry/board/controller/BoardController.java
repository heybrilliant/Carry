package com.project.gymcarry.board.controller;

import com.project.gymcarry.board.Pagination;
import com.project.gymcarry.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;

@Controller
public class BoardController {

    @Inject
    private BoardService boardService;


    // 게시판 목록 조회
    @GetMapping("community/boardList")
    public String getBoardList (Model model
                                ,@RequestParam(required = false, defaultValue = "1")int page
                                ,@RequestParam(required = false,defaultValue = "1")int range)
                                throws Exception{

//    selectBoardList(@ModelAttribute("boardDto")BoardDto boardDto, Model model
//                                  ,@RequestParam(required = false, defaultValue = "1")int page
//                                  ,@RequestParam(required = false,defaultValue = "1")int range
//                                ) throws Exception{

        // 전체 리스트 출력
//        List<BoardDto> list = boardService.selectBoardList(boardDto);
//        model.addAttribute("boardList",list);

        //전체 게시글 개수 & 리스트 출력
        int listCnt = boardService.getBoardListCnt();

        // Pagination 객체 생성
        Pagination pagination = new Pagination();
        pagination.pageInfo(page, range, listCnt);

        model.addAttribute("pagination", pagination);
        model.addAttribute("boardList", boardService.getBoardList(pagination));

        return "community/community";

    }
}
