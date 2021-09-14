package com.project.gymcarry.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.project.gymcarry.board.BoardDto;
import com.project.gymcarry.board.BoardLikeDto;
import com.project.gymcarry.board.BoardWriteDto;
import com.project.gymcarry.board.Pagination;

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
    
    // 게시물 좋아요 여부 확인
    BoardLikeDto selectBoardLike(@Param("postidx") int postidx, @Param("memidx") int memidx);
    
    // 게시물 좋아요 on
    Integer insertBoardLike(Map<String, Object> map);
    
    // 게시물 좋아요 off
    Integer deleteBoardLike(Map<String, Object> map);
    
    // 게시물 좋아요 총 갯수
    List<BoardLikeDto> selectBoardLikeLength(int postidx);
    
}