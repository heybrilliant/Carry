package com.project.gymcarry.dao;

import com.project.gymcarry.board.BoardDto;
import com.project.gymcarry.board.BoardWriteDto;

import java.util.List;
import java.util.Map;

public interface BoardDao {

    // 게시판 전체 리스트
    List<BoardDto> selectBoardList();
    
    // 게시판 글쓰기
    Integer insertBoardWrite(Map<String, String> map);
}