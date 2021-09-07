package com.project.gymcarry.dao;

import com.project.gymcarry.board.BoardDto;

import java.util.List;

public interface BoardDao {

    // 게시판 전체 리스트
    List<BoardDto> selectBoardList();

    // 조회수 증가
    int updateViewCount(BoardDto boardDto);

}