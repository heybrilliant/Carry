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
    
    // 게시판 상세페이지
    BoardDto selectBoardDetail(int postidx);
    
    // 게시물 수정 입력된 값 그대로 출력
    BoardWriteDto selectBoardUpdate(int postidx);

    // 게시물 수정
    Integer updateBoardContent(Map<String, Object> map);
    
    // 게시물 삭제
    Integer deleteBoard(int postidx);
}