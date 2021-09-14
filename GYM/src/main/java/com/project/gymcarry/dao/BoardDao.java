package com.project.gymcarry.dao;

import java.util.List;
import java.util.Map;

import com.project.gymcarry.board.BoardDto;
import com.project.gymcarry.board.BoardWriteDto;
import com.project.gymcarry.board.Pagination;

public interface BoardDao {

	// 게시판 전체 리스트 출력
    public List<BoardDto> getBoardList(Pagination pagination) throws Exception;

    // 게시판 소통 리스트 출력
    public List<BoardDto> getBoardComm(Pagination pagination) throws Exception;

    // 게시판 질문/답변 리스트 출력
    public List<BoardDto> getBoardQnA(Pagination pagination) throws Exception;

    // 게시판 전체 리스트 개수 확인 (페이징)
    public int getBoardListCnt() throws Exception;

    // 게시판 소통 리스트 개수 확인 (페이징)
    public int getBoardCommCnt() throws Exception;

    // 게시판 질문/답변 개수 확인 (페이징)
    public int getBoardQnAtCnt() throws Exception;

    // 조회수
    public int updateViewCnt(int postidx) throws Exception;

    // 게시판 글쓰기
    Integer insertBoardWrite(Map<String, String> map);
    
    // 게시판 상세페이지
    BoardDto selectBoardDetail(int postidx);
    
    // 게시물 수정 입력된 값 그대로 출력
    BoardWriteDto selectBoardUpdate(int postidx);

    // 게시물 수정
    Integer updateBoardContent(Map<String, Object> map);
    
    // 게시물 삭제
    Integer deleteBoard(int postidx);
}