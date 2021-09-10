package com.project.gymcarry.board.service;

import com.project.gymcarry.board.BoardDto;
import com.project.gymcarry.board.BoardWriteDto;
import com.project.gymcarry.board.Pagination;

import java.util.List;
import java.util.Map;

public interface BoardService {

    // 전체 게시물 조회
    public List<BoardDto> getBoardList(Pagination pagination) throws Exception;

    ///총 게시글 개수 확인
    public int getBoardListCnt() throws Exception;

    // 게시판 카테고리 리스트
    public List<BoardDto> getListCommuni();

    // 게시글 입력
    public int getBoardWrite(Map<String, String> map) throws Exception;

    // 게시글 상세 페이지 출력
    public BoardDto getBoardDetail(int postidx) throws Exception;

    // 게시글 수정시 입력된 값 그대로 출력
    public BoardWriteDto getBoardUpdate(int postidx) throws Exception;

    // 게시글 수정
    public int getBoardContent(Map<String, Object> map) throws Exception;

    // 게시글 삭제
    public int getDeleteBoard(int postidx) throws Exception;






}
