package com.project.gymcarry.board.service;

import com.project.gymcarry.board.BoardDto;
import com.project.gymcarry.board.Pagination;

import java.util.List;

public interface BoardService {

    // 전체 게시물 조회
    public List<BoardDto> getBoardList(Pagination pagination) throws Exception;

    ///총 게시글 개수 확인
    public int getBoardListCnt() throws Exception;

    // 게시판 카테고리 리스트
    public List<BoardDto> getListCommuni();

}
