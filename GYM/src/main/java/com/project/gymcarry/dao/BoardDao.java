package com.project.gymcarry.dao;

import com.project.gymcarry.board.BoardDto;

import java.util.List;

public interface BoardDao {
	
    // 게시판 글생성
    public void create(BoardDto dto) throws Exception;

    // 게시판 출력
    public BoardDto read(Integer postidx) throws Exception;

    // 게시판 수정
    public void update(BoardDto dto) throws Exception;

    // 게시판 삭제
    public void delete(Integer postidx) throws Exception;

    // 게시판 전체 리스트
    public List<BoardDto> listAll();
	
}