package com.project.gymcarry.board.controller;

import com.project.gymcarry.board.BoardDto;
import com.project.gymcarry.board.Pagination;
import com.project.gymcarry.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class BoardController {

    @Inject
    private BoardService boardService;


    // 게시판 목록 조회 & 페이징 처리
    @GetMapping("community/boardList")
    public String getBoardList (Model model
                                ,@RequestParam(required = false, defaultValue = "1")int page
                                ,@RequestParam(required = false,defaultValue = "1")int range)
                                throws Exception{

        int listCnt = boardService.getBoardListCnt();

        // Pagination 객체 생성
        Pagination pagination = new Pagination();
        pagination.pageInfo(page, range, listCnt);

        model.addAttribute("pagination", pagination);
        model.addAttribute("boardList", boardService.getBoardList(pagination));

        return "community/community";

    }

    // ajax 출력

    @PostMapping("community/boardList")
    public String getCategoryList(
            Model model
    ) {
    List<BoardDto> getCategoryList = boardService.getCategoryList();
    return list

}


}
