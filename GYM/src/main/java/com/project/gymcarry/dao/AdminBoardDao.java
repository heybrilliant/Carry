package com.project.gymcarry.dao;

import java.util.List;

import com.project.gymcarry.admin.AdminBoardDto;

public interface AdminBoardDao {

	// 전체 관리자 게시글 리스트
	List<AdminBoardDto> selectAllAdminBoard();

}
