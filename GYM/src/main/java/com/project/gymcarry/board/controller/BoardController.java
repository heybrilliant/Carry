package com.project.gymcarry.board.controller;

import com.project.gymcarry.board.Pagination;
import com.project.gymcarry.board.BoardDto;
import com.project.gymcarry.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    // 게시판 목록 조회
    @GetMapping("community/boardlist")
    public String selectBoardList(Model model
                                ,@RequestParam(required = false, defaultValue = "1")int page
                                ,@RequestParam(required = false,defaultValue = "1")int range) throws Exception{

//    selectBoardList(@ModelAttribute("boardDto")BoardDto boardDto, Model model
//                                  ,@RequestParam(required = false, defaultValue = "1")int page
//                                  ,@RequestParam(required = false,defaultValue = "1")int range
//                                ) throws Exception{

        // 전체 리스트 출력
//        List<BoardDto> list = boardService.selectBoardList(boardDto);
//        model.addAttribute("boardList",list);
        //전체 게시글 개수

        int listCnt = boardService.getBoardListCnt();

        Pagination pagination = new Pagination();
        pagination.pageInfo(page, range, listCnt);

        model.addAttribute("pagination", pagination);
        model.addAttribute("boardList", boardService.selectBoardList(pagination));

        return "community/community";

    }
}
