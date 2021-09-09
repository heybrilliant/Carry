package com.project.gymcarry.dao;

import com.project.gymcarry.board.BoardDto;
import com.project.gymcarry.board.Pagination;

import java.util.List;

public interface BoardDao {

    // 게시판 전체 리스트
    List<BoardDto> selectBoardList(Pagination pagination) throws Exception;

    public List<BoardDto> getBoardList(Pagination pagination) throws Exception;

    public BoardDto getBoardContent(int postidx) throws Exception;

    // 조회수
    public int updateViewCnt(int postidx) throws Exception;

    // 총 게시글 개수 확인 (페이징)
    public int getBoardListCnt() throws Exception;

    // 게시판 카테고리 가져오기
    List<BoardDto> getListCommuni();





}