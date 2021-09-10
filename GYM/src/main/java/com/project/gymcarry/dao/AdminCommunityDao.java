package com.project.gymcarry.dao;

import java.util.List;

import com.project.gymcarry.board.BoardDto;

public interface AdminCommunityDao {

	// 전체 관리자 게시글 리스트
	List<BoardDto> selectCommunityList();
	// 게시글 삭제
	public void deleteCommunity(int postidx);
	
}
