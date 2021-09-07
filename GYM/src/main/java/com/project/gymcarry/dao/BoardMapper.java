package com.project.gymcarry.dao;

import com.project.gymcarry.board.BoardDto;

import java.util.List;

public interface BoardMapper {

    // 게시판 전체 리스트
    public List<BoardDto> listAll();
	
}